package com.jjcraft.ttoi.init;

import com.google.gson.JsonObject;
import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.blocks.CNFurnace;
import com.jjcraft.ttoi.blocks.Wheatgrass;
import com.jjcraft.ttoi.blocks.Wheatsoil;
import com.jjcraft.ttoi.blocks.Wheatsoil_Farmland;
import com.jjcraft.ttoi.entities.BaneOfTheRich;
import com.jjcraft.ttoi.recipes.Compactor;
import com.jjcraft.ttoi.util.HelperMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.extensions.IForgeRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TTOIMain.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> COMPACTOR = RECIPES.register("compactor",
            () -> new Compactor(new ResourceLocation(TTOIMain.MOD_ID,"/resources/data/ttoi/recipes/compactor.json"),"compactor",));

    (ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result, float experience, int cookTime)

    public RecipeInit() {
    }
}
