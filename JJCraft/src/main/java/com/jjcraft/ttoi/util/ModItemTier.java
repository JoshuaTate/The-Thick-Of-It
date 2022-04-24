package com.jjcraft.ttoi.util;

import com.jjcraft.ttoi.init.BlockInit;
import com.jjcraft.ttoi.init.ItemInit;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import javax.swing.*;
import javax.swing.UIDefaults.LazyValue;
import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    GREEN(0, 25, 1.0F, 0.0F, 0, () -> {
        return Ingredient.of(ItemInit.GREEN_INGOT.get());
    }),
    CORBYN(4, 2000, 10.0F, 4.0F, 15, () -> {
        return Ingredient.of(BlockInit.CORBYNITE.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = durability;
        this.speed = miningSpeed;
        this.damage = damage;
        this.enchantmentValue = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}