package dulandor.crystaltrainingmod.zombie;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class spawnZombie {
    public static void spawnCustomZombie(@NotNull ServerPlayerEntity player, int x, int y, int z) {
        // Your custom Zombie spawning code here
        ZombieEntity customZombie = new zombieEntity(EntityType.ZOMBIE, player.getWorld());
        customZombie.refreshPositionAndAngles(x, y, z, 0, 0);

        // Equip the custom Zombie with items
        ItemStack sword = new ItemStack(Items.NETHERITE_SWORD);
        ItemStack totemStack = new ItemStack(Items.TOTEM_OF_UNDYING, 25);
        ItemStack helmet = new ItemStack(Items.NETHERITE_HELMET);
        ItemStack chestplate = new ItemStack(Items.NETHERITE_CHESTPLATE);
        ItemStack leggings = new ItemStack(Items.NETHERITE_LEGGINGS);
        ItemStack boots = new ItemStack(Items.NETHERITE_BOOTS);
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
        customZombie.equipStack(EquipmentSlot.MAINHAND, sword);
        customZombie.equipStack(EquipmentSlot.OFFHAND, totemStack);
        customZombie.equipStack(EquipmentSlot.HEAD, helmet);
        customZombie.equipStack(EquipmentSlot.CHEST, chestplate);
        customZombie.equipStack(EquipmentSlot.LEGS, leggings);
        customZombie.equipStack(EquipmentSlot.FEET, boots);
        // Equip armor and totem similarly as before

        player.getWorld().spawnEntity(customZombie);
    }
    private static void enchantItem(ItemStack itemStack, Enchantment enchantment, int level) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(itemStack);
        enchantments.put(enchantment, level);
        EnchantmentHelper.set(enchantments, itemStack);
    }
}
