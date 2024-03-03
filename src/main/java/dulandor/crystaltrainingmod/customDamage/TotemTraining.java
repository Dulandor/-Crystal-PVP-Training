package dulandor.crystaltrainingmod.customDamage;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.NotNull;
public class TotemTraining {
    public static boolean isRunning = false;
    private static int tickCounter = 0;
    private static final int TICKS_PER_POP = 20; // 20 ticks = 1 second

    public static void trainTotem(LivingEntity player) {
        System.out.println("Totem popping loop started");
        isRunning = true;

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (isRunning) {
                tickCounter++;
                if (tickCounter >= TICKS_PER_POP) {
                    System.out.println("Popping a totem!");
                    popTotem(player);
                    tickCounter = 0;
                }
            }
        });
    }

    public static void stopTotemPoppingLoop() {
        System.out.println("Totem popping loop stopped");
        isRunning = false;
    }

    private static void popTotem(@NotNull LivingEntity player) {
        System.out.println("Checking for a totem in the offhand");
        ItemStack offhandItem = player.getOffHandStack();

        if (offhandItem.getItem() == Items.TOTEM_OF_UNDYING) {
            System.out.println("Using the totem!");
            // Simulate using the totem
            damage(player);
        }
    }

    private static void damage(@NotNull LivingEntity entity) {
        System.out.println("Entity took damage!");

        // Apply the potion effect to the entity
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 10));
    }
}
