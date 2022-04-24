package com.jjcraft.ttoi.events;

import com.jjcraft.ttoi.util.IDamageHandlingArmour;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmourHandlers {

    @SubscribeEvent
    public static void armourAttackHandler(LivingDamageEvent event){
        for (ItemStack armor : event.getEntityLiving().getArmorSlots()){
            if (armor.getItem() instanceof IDamageHandlingArmour) {
                float newDamage = ((IDamageHandlingArmour)armor.getItem()).onDamaged(event.getEntityLiving(), armor.getEquipmentSlot(), event.getSource(), event.getAmount());
                event.setAmount(newDamage);
            }
        }
    }
}