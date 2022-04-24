package com.jjcraft.ttoi.armour;

import com.jjcraft.ttoi.init.ItemInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AscendedArmourItem extends ArmorItem {
    public AscendedArmourItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()){
            boolean fullset = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.ASCENDED_HELMET.get() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.ASCENDED_CHESTPLATE.get() && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.ASCENDED_LEGGINGS.get() && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.ASCENDED_BOOTS.get();
            if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.ASCENDED_CHESTPLATE.get()) {
                // per piece custom
            }
            if (fullset) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 10));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10));
                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 10));
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10));
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10));
                player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 10));
            }
        }
    }
}