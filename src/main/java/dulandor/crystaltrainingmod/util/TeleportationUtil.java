package dulandor.crystaltrainingmod.util;

import dulandor.crystaltrainingmod.world.dimension.ModDimensions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class TeleportationUtil {

    public static void teleportPlayer(@NotNull ServerPlayerEntity player, @NotNull World world) {
        if (!world.isClient) {
            if (!player.isSneaking()) {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    if (player instanceof ServerPlayerEntity) {
                        if (world.getRegistryKey() == ModDimensions.ARENA_LEVEL_KEY) {
                            ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                            if (overWorld != null) {
                                BlockPos destPos = getSurfacePos(player.getBlockPos(), overWorld);
                                player.teleport(overWorld, destPos.getX(), destPos.getY(), destPos.getZ(),
                                        player.bodyYaw, player.prevPitch);
                            }
                        } else {
                            ServerWorld arena = server.getWorld(ModDimensions.ARENA_LEVEL_KEY);
                            if (arena != null) {
                                BlockPos destPos = getSurfacePos(player.getBlockPos(), arena);
                                player.teleport(arena, destPos.getX(), destPos.getY(), destPos.getZ(),
                                        player.bodyYaw, player.prevPitch);
                            }
                        }
                    }
                }
            }
        }
    }
    public static BlockPos getSurfacePos(@NotNull BlockPos pos, @NotNull World world) {
        BlockPos.Mutable mutablePos = new BlockPos.Mutable(pos.getX(),
                Math.max(pos.getY() + 5, world.getBottomY()), pos.getZ());

        int maxIterations = 5;
        int searchRadius = 25;

        while (world.isAir(mutablePos.down()) && mutablePos.getY() > world.getBottomY()) {
            mutablePos.move(Direction.DOWN);
        }

        for (int i = 0; i < maxIterations; i++) {
            // Find the top non-air solid block from the bottom
            while (!world.isAir(mutablePos) && mutablePos.getY() < world.getTopY()) {
                mutablePos.move(Direction.UP);
            }

            // Check if the position above and below are suitable (adjust conditions)
            if (world.getBlockState(mutablePos).isAir() && world.getLightLevel(mutablePos.up()) > 7) {
                // Perform a wider cave check
                if (isCaveClear(mutablePos, world, searchRadius)) {
                    return mutablePos.toImmutable();
                }
                mutablePos.move(Direction.UP, searchRadius);
            }
        }

        // No suitable position found, return original position (or consider error handling)
        return pos.toImmutable();
    }

    private static boolean isCaveClear(@NotNull BlockPos pos, World world, int radius) {
        BlockPos.Mutable searchBlockPos = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());

        for (int counter = 0; counter < radius; counter++) {
            if (world.isAir(searchBlockPos) && searchBlockPos.getY() < world.getTopY()) {
                searchBlockPos.move(Direction.UP);
            }

            if (!world.isAir(searchBlockPos) && searchBlockPos.getY() < world.getTopY()) {
                return false; // Cave check failed
            }
        }
        return true; // Cave check passed
    }
}