package com.jjcraft.ttoi.init;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.enchantments.BridgeEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TTOIMain.MOD_ID);

    private static Object BridgeEnchantment;
    public static final RegistryObject<Enchantment> BRIDGE = ENCHANTMENTS.register("bridge", BridgeEnchantment::new);
}