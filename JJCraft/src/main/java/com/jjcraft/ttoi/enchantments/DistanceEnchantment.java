package com.jjcraft.ttoi.enchantments;

import com.jjcraft.ttoi.init.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DistanceEnchantment extends Enchantment {
    static EnchantmentCategory POVERTY_STAFF_TYPE = EnchantmentCategory.create("poverty_staff", item -> item == ItemInit.POVERTY_STAFF.get());

    public DistanceEnchantment() {
        super(Rarity.COMMON, POVERTY_STAFF_TYPE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
}
