package dulandor.crystaltrainingmod.registry;

import dulandor.crystaltrainingmod.util.TeleportationUtil;
import dulandor.crystaltrainingmod.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.Objects;

import static dulandor.crystaltrainingmod.customDamage.TotemTraining.*;
import static dulandor.crystaltrainingmod.items.giveItems.giveStartingItems;
import static dulandor.crystaltrainingmod.zombie.spawnZombie.spawnCustomZombie;
import static net.minecraft.server.command.CommandManager.literal;

public class CommandRegistry {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("arena")
                    .executes(ctx -> {
                        ServerPlayerEntity player = ctx.getSource().getPlayer();
                        assert player != null;
                        World world = Objects.requireNonNull(player.getServer()).getWorld(World.OVERWORLD);
                        assert world != null;
                        TeleportationUtil.teleportPlayer(player, world);
                        return 1;
                    }));

            dispatcher.register(literal("overworld")
                    .executes(ctx -> {
                        ServerPlayerEntity player = ctx.getSource().getPlayer();
                        assert player != null;
                        World world = Objects.requireNonNull(player.getServer()).getWorld(ModDimensions.ARENA_LEVEL_KEY);
                        assert world != null;
                        TeleportationUtil.teleportPlayer(player, world);
                        return 1;
                    }));
            dispatcher.register(literal("k1")
                    .executes(context -> {
                        giveStartingItems(context.getSource());
                        return 1;
                    }));
            dispatcher.register(literal("zombie")
                    .executes(ctx -> {
                        ServerPlayerEntity player = ctx.getSource().getPlayer();
                        assert player != null;
                        int x = (int) player.getX();
                        int y = (int) player.getY();
                        int z = (int) player.getZ();

                        // Spawn the custom Zombie with items
                        spawnCustomZombie(player, x, y, z);
                        return 1;
                    }));
            dispatcher.register(literal("totem")
                    .executes(ctx -> {
                        ServerPlayerEntity player = ctx.getSource().getPlayer();
                        assert player != null;
                        if (isRunning) {
                            // If the loop is already running, stop it
                            stopTotemPoppingLoop();
                        } else {
                            // If the loop is not running, start it
                            trainTotem(player);
                        }
                        System.out.println("Totem Training initialized!");
                        return 1;
                    })
            );
        });
    }
}
