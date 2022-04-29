package com.jjcraft.ttoi.init;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.armour.AscendedArmourItem;
import com.jjcraft.ttoi.armour.CorruptedArmourItem;
import com.jjcraft.ttoi.armour.ModArmourMaterial;
import com.jjcraft.ttoi.items.GreenIngot;
import com.jjcraft.ttoi.items.PovertyStaff;
import com.jjcraft.ttoi.items.Umbrella;
import com.jjcraft.ttoi.util.ModItemTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TTOIMain.MOD_ID);

    public static final RegistryObject<Item> GREEN_INGOT = ITEMS.register("green_ingot",
            () -> new GreenIngot(new Item.Properties().tab(ModCreativeTab.instance), 200));

    public static final RegistryObject<Item> CORBYNITE_INGOT = ITEMS.register("corbynite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));

    // WEAPONS
    public static final RegistryObject<Item> CORBYNITE_SWORD = ITEMS.register("corbynite_sword",
            () -> new SwordItem(ModItemTier.CORBYN, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORBYNITE_PICAXE = ITEMS.register("corbynite_picaxe",
            () -> new PickaxeItem(ModItemTier.CORBYN, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORBYNITE_AXE = ITEMS.register("corbynite_axe",
            () -> new AxeItem(ModItemTier.CORBYN, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORBYNITE_SHOVEL = ITEMS.register("corbynite_shovel",
            () -> new ShovelItem(ModItemTier.CORBYN, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORBYNITE_HOE = ITEMS.register("corbynite_hoe",
            () -> new HoeItem(ModItemTier.CORBYN, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> POVERTY_STAFF = ITEMS.register("poverty_staff",
            () -> new PovertyStaff(new Item.Properties().tab(ModCreativeTab.instance).durability(50)));

    public static final RegistryObject<Item> UMBRELLA = ITEMS.register("umbrella",
            () -> new Umbrella(new Item.Properties().tab(ModCreativeTab.instance).durability(50)));

    // ARMOUR
    public static final RegistryObject<Item> GREEN_HELMET = ITEMS.register("green_helmet",
            () -> new ArmorItem(ModArmourMaterial.GREEN, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> GREEN_CHESTPLATE = ITEMS.register("green_chestplate",
            () -> new ArmorItem(ModArmourMaterial.GREEN, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> GREEN_LEGGINGS = ITEMS.register("green_leggings",
            () -> new ArmorItem(ModArmourMaterial.GREEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> GREEN_BOOTS = ITEMS.register("green_boots",
            () -> new ArmorItem(ModArmourMaterial.GREEN, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORRUPTED_HELMET = ITEMS.register("corrupted_helmet",
            () -> new CorruptedArmourItem(ModArmourMaterial.CORRUPTED, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORRUPTED_CHESTPLATE = ITEMS.register("corrupted_chestplate",
            () -> new CorruptedArmourItem(ModArmourMaterial.CORRUPTED, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORRUPTED_LEGGINGS = ITEMS.register("corrupted_leggings",
            () -> new CorruptedArmourItem(ModArmourMaterial.CORRUPTED, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> CORRUPTED_BOOTS = ITEMS.register("corrupted_boots",
            () -> new CorruptedArmourItem(ModArmourMaterial.CORRUPTED, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> ASCENDED_HELMET = ITEMS.register("ascended_helmet",
            () -> new AscendedArmourItem(ModArmourMaterial.ASCENDED, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> ASCENDED_CHESTPLATE = ITEMS.register("ascended_chestplate",
            () -> new AscendedArmourItem(ModArmourMaterial.ASCENDED, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> ASCENDED_LEGGINGS = ITEMS.register("ascended_leggings",
            () -> new AscendedArmourItem(ModArmourMaterial.ASCENDED, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> ASCENDED_BOOTS = ITEMS.register("ascended_boots",
            () -> new AscendedArmourItem(ModArmourMaterial.ASCENDED, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTab.instance)));

    public ItemInit() {
    }

    public static class ModCreativeTab extends CreativeModeTab {
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "The Thick Of It");

        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GREEN_INGOT.get());
        }
    }
}