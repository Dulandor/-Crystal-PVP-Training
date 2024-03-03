package dulandor.crystaltrainingmod;

import dulandor.crystaltrainingmod.registry.CommandRegistry;
import net.fabricmc.api.ModInitializer;

public class CrystalTrainingMod implements ModInitializer {
    public static final String MOD_ID = "crystaltrainingmod";

    @Override
    public void onInitialize() {
        CommandRegistry.registerCommands();
    }
}
