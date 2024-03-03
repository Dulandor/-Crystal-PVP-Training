package dulandor.crystaltrainingmod.world.dimension;

import dulandor.crystaltrainingmod.CrystalTrainingMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> ARENA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(CrystalTrainingMod.MOD_ID, "arena"));
    public static final RegistryKey<World> ARENA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(CrystalTrainingMod.MOD_ID, "arena"));
    public static final RegistryKey<DimensionType> ARENA_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(CrystalTrainingMod.MOD_ID, "arena_type"));
}
