package com.jjcraft.ttoi.armour;

import com.jjcraft.ttoi.init.ItemInit;
import com.jjcraft.ttoi.util.IDamageHandlingArmour;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CorruptedArmourItem extends ArmorItem implements IDamageHandlingArmour {
    public CorruptedArmourItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()){
            boolean fullset = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.CORRUPTED_HELMET.get() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.CORRUPTED_CHESTPLATE.get() && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.CORRUPTED_LEGGINGS.get() && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.CORRUPTED_BOOTS.get();
            if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.CORRUPTED_CHESTPLATE.get()) {
                // per piece custom
            }
            if (fullset) {
                player.addEffect(new MobEffectInstance(MobEffects.LUCK, 10));
                player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 10));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10));
            }
        }
    }

    @Override
    public float onDamaged(LivingEntity entity, EquipmentSlot slot, DamageSource source, float amount) {
        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity){
            attacker.hurt(DamageSource.ON_FIRE, amount / 2);
            attacker.setSecondsOnFire(10);
            return amount / 2;
        } else {
            return amount;
        }
    }
}