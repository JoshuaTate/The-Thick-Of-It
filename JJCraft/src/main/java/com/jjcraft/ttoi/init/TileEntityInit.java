package com.jjcraft.ttoi.init;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.entities.BaneOfTheRichTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TTOIMain.MOD_ID);

    public static final RegistryObject<BlockEntityType<BaneOfTheRichTile>> MOB_SLAYER = TILE_ENTITY_TYPES.register("mob_slayer",
            () -> BlockEntityType.Builder.of(BaneOfTheRichTile::new, BlockInit.BANE_OF_THE_RICH.get()).build(null));
}