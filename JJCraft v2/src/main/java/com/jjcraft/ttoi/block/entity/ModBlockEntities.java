package com.jjcraft.ttoi.block.entity;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.block.ModBlocks;
import com.jjcraft.ttoi.block.entity.custom.GemCuttingStationBlockEntity;
import com.jjcraft.ttoi.block.entity.custom.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TTOIMain.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_cutting_station_block_entity", () ->
                    BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new,
                            ModBlocks.GEM_CUTTING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.EBONY_WALL_SIGN.get(),
                            ModBlocks.EBONY_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
