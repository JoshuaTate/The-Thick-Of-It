package com.jjcraft.ttoi.recipes;

import com.google.gson.JsonObject;
import com.jjcraft.ttoi.init.RecipeInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class Compactor extends CraftingRecipe {

    private final ResourceLocation id;
    final String group;
    final Ingredient ingredient;
    final ItemStack result;
    final float experience;
    final int cookTime;

    public Compactor(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result, float experience, int cookTime) {
        super(resourceLocation,group,ingredient,result,experience,cookTime);
        this.id = resourceLocation;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
        this.experience = experience;
        this.cookTime = cookTime;
    }
}

