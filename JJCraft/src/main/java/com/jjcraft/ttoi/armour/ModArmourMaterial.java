package com.jjcraft.ttoi.armour;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.init.BlockInit;
import com.jjcraft.ttoi.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmourMaterial implements ArmorMaterial {
    GREEN(TTOIMain.MOD_ID + ":green", 20, new int[]{4, 7, 9, 4}, 50, SoundEvents.ARMOR_EQUIP_LEATHER, 1.0F, 0.1F, () -> {
        return Ingredient.of(ItemInit.GREEN_INGOT.get());
    }),
    CORBYN(TTOIMain.MOD_ID + ":corbyn", 1000, new int[]{4, 7, 9, 4}, 50, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.1F, () -> {
        return Ingredient.of(ItemInit.GREEN_INGOT.get());
    }),
    CORRUPTED(TTOIMain.MOD_ID + ":corrupted", 5000, new int[]{4, 7, 9, 4}, 50, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.1F, () -> {
        return Ingredient.of(BlockInit.CORRUPTED_BLOCK.get());
    }),
    ASCENDED(TTOIMain.MOD_ID + ":ascended", 5000, new int[]{4, 7, 9, 4}, 50, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, 0.1F, () -> {
        return Ingredient.of(BlockInit.ASCENDED_BLOCK.get());
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmourMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = protection;
        this.enchantmentValue = enchantability;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}