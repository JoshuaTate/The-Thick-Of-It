package com.jjcraft.ttoi.init;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.blocks.CNFurnace;
import com.jjcraft.ttoi.blocks.Wheatgrass;
import com.jjcraft.ttoi.blocks.Wheatsoil;
import com.jjcraft.ttoi.blocks.Wheatsoil_Farmland;
import com.jjcraft.ttoi.entities.BaneOfTheRich;
import com.jjcraft.ttoi.util.HelperMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TTOIMain.MOD_ID);

    public static final RegistryObject<Block> CORBYNITE = BLOCKS.register("corbynite",
            () -> new Block(Block.Properties.of(Material.STONE).strength(4f, 1200f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_BLOCK = BLOCKS.register("corrupted_block",
            () -> new Block(Block.Properties.of(Material.STONE).strength(20f, 5000f).requiresCorrectToolForDrops().lightLevel((state) -> 0)));

    public static final RegistryObject<Block> ASCENDED_BLOCK = BLOCKS.register("ascended_block",
            () -> new Block(Block.Properties.of(Material.STONE).strength(20f, 5000f).requiresCorrectToolForDrops().lightLevel((state) -> 15)));

    public static final RegistryObject<Block> WHEATSOIL = BLOCKS.register("wheatsoil",
            () -> new Wheatsoil(Block.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> WHEATGRASS = BLOCKS.register("wheatgrass",
            () -> new Wheatgrass(Block.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> WHEATSOIL_FARMLAND = BLOCKS.register("wheatsoil_farmland",
            () -> new Wheatsoil_Farmland(Block.Properties.copy(Blocks.FARMLAND)));

    public static final RegistryObject<Block> BERNIE_SAND = BLOCKS.register("bernie_sand",
            () -> new Block(Block.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> CNFURNACE = BLOCKS.register("cnfurnace",
            () -> new CNFurnace(Block.Properties.copy(Blocks.FURNACE)));

    public static final RegistryObject<Block> BANE_OF_THE_RICH = BLOCKS.register("bane_of_the_rich",
            () -> new BaneOfTheRich(Block.Properties.copy(Blocks.IRON_BLOCK)));

    public BlockInit() {
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
            final Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
}
