package dulandor.crystaltrainingmod.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class giveItems {
    public static void giveStartingItems(@NotNull ServerCommandSource source) {
        ServerPlayerEntity player = source.getPlayer();

        if (player != null) {
            // Give enchanted armor
            ItemStack helmet = new ItemStack(Items.NETHERITE_HELMET);
            ItemStack chestplate = new ItemStack(Items.NETHERITE_CHESTPLATE);
            ItemStack leggings = new ItemStack(Items.NETHERITE_LEGGINGS);
            ItemStack boots = new ItemStack(Items.NETHERITE_BOOTS);
            ItemStack sword = new ItemStack(Items.NETHERITE_SWORD);
            ItemStack pickaxe = new ItemStack(Items.NETHERITE_PICKAXE);
            // Enchant the armor pieces
            enchantItem(helmet, Enchantments.PROTECTION, 4);
            enchantItem(chestplate, Enchantments.PROTECTION, 4);
            enchantItem(leggings, Enchantments.BLAST_PROTECTION, 4);
            enchantItem(boots, Enchantments.PROTECTION, 4);
            enchantItem(helmet, Enchantments.UNBREAKING, 3);
            enchantItem(chestplate, Enchantments.UNBREAKING, 3);
            enchantItem(leggings, Enchantments.UNBREAKING, 3);
            enchantItem(boots, Enchantments.UNBREAKING, 3);
            enchantItem(helmet, Enchantments.MENDING, 1);
            enchantItem(chestplate, Enchantments.MENDING, 1);
            enchantItem(leggings, Enchantments.MENDING, 1);
            enchantItem(boots, Enchantments.MENDING, 1);
            enchantItem(boots, Enchantments.FEATHER_FALLING, 4);
            // Enchant the Sword
            enchantItem(sword, Enchantments.KNOCKBACK, 1);
            enchantItem(sword, Enchantments.SHARPNESS, 5);
            enchantItem(sword, Enchantments.UNBREAKING, 3);
            enchantItem(sword, Enchantments.MENDING, 1);
            enchantItem(sword, Enchantments.SWEEPING, 3);
            // Enchant the Pickaxe
            enchantItem(pickaxe, Enchantments.UNBREAKING, 3);
            enchantItem(pickaxe, Enchantments.MENDING, 1);
            enchantItem(pickaxe, Enchantments.EFFICIENCY, 5);
            enchantItem(pickaxe, Enchantments.FORTUNE, 3);
            // Make the Items
            ItemStack obsidianStack = new ItemStack(Items.OBSIDIAN, 64);
            ItemStack endcrystalStack = new ItemStack(Items.END_CRYSTAL, 64);
            ItemStack respawnanchorStack = new ItemStack(Items.RESPAWN_ANCHOR, 64);
            ItemStack glowstoneStack = new ItemStack(Items.GLOWSTONE, 64);
            ItemStack obsidianStack1 = new ItemStack(Items.OBSIDIAN, 64);
            ItemStack endcrystalStack1 = new ItemStack(Items.END_CRYSTAL, 64);
            ItemStack respawnanchorStack1 = new ItemStack(Items.RESPAWN_ANCHOR, 64);
            ItemStack glowstoneStack1 = new ItemStack(Items.GLOWSTONE, 64);
            ItemStack totemStack = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack1 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack2 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack3 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack4 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack5 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack6 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack7 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack8 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack9 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack10 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack11 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack12 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack13 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack14 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack15 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack16 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack17 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack18 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack19 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack20 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack totemStack21 = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack enderpearlStack = new ItemStack(Items.ENDER_PEARL, 16);
            ItemStack enderpearlStack1 = new ItemStack(Items.ENDER_PEARL, 16);
            ItemStack enderpearlStack2 = new ItemStack(Items.ENDER_PEARL, 16);
            ItemStack enderpearlStack3 = new ItemStack(Items.ENDER_PEARL, 16);
            ItemStack gappleStack = new ItemStack(Items.GOLDEN_APPLE, 64);
            // Give the Items to the Player
            player.setStackInHand(Hand.OFF_HAND, totemStack21);
            player.getInventory().setStack(0, sword);
            player.getInventory().setStack(1, obsidianStack);
            player.getInventory().setStack(2, endcrystalStack);
            player.getInventory().setStack(3, respawnanchorStack);
            player.getInventory().setStack(4, glowstoneStack);
            player.getInventory().setStack(5, totemStack);
            player.getInventory().setStack(6, enderpearlStack);
            player.getInventory().setStack(7, pickaxe);
            player.getInventory().setStack(8, gappleStack); // End of the Hotbar
            player.getInventory().setStack(9, totemStack1);
            player.getInventory().setStack(10, totemStack2);
            player.getInventory().setStack(11, totemStack3);
            player.getInventory().setStack(12, totemStack4);
            player.getInventory().setStack(13, totemStack5);
            player.getInventory().setStack(14, totemStack6);
            player.getInventory().setStack(15, enderpearlStack1);
            player.getInventory().setStack(16, totemStack7);
            player.getInventory().setStack(17, totemStack8); // End of the highest row
            player.getInventory().setStack(18, totemStack9);
            player.getInventory().setStack(19, totemStack10);
            player.getInventory().setStack(20, totemStack11);
            player.getInventory().setStack(21, totemStack12);
            player.getInventory().setStack(22, totemStack13);
            player.getInventory().setStack(23, totemStack14);
            player.getInventory().setStack(24, enderpearlStack2);
            player.getInventory().setStack(25, totemStack15);
            player.getInventory().setStack(26, totemStack16); // End of the middle row
            player.getInventory().setStack(27, totemStack17);
            player.getInventory().setStack(28, obsidianStack1);
            player.getInventory().setStack(29, endcrystalStack1);
            player.getInventory().setStack(30, respawnanchorStack1);
            player.getInventory().setStack(31, glowstoneStack1);
            player.getInventory().setStack(32, totemStack18);
            player.getInventory().setStack(33, enderpearlStack3);
            player.getInventory().setStack(34, totemStack19);
            player.getInventory().setStack(35, totemStack20);
            // Give the enchanted armor pieces to the player
            player.equipStack(EquipmentSlot.HEAD, helmet);
            player.equipStack(EquipmentSlot.CHEST, chestplate);
            player.equipStack(EquipmentSlot.LEGS, leggings);
            player.equipStack(EquipmentSlot.FEET, boots);
        }
    }
    private static void enchantItem(ItemStack itemStack, Enchantment enchantment, int level) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(itemStack);
        enchantments.put(enchantment, level);
        EnchantmentHelper.set(enchantments, itemStack);
    }
}
