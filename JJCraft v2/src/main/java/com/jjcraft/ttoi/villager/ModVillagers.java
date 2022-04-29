package com.jjcraft.ttoi.villager;

import com.google.common.collect.ImmutableSet;
import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, TTOIMain.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, TTOIMain.MOD_ID);

    public static final RegistryObject<PoiType> GEM_CUTTING_POI = POI_TYPES.register("gem_cutting_poi",
            () -> new PoiType("gem_cutting_poi",
                    PoiType.getBlockStates(ModBlocks.GEM_CUTTING_STATION.get()), 1, 1));

    public static final RegistryObject<VillagerProfession> GEM_CUTTER =
            VILLAGER_PROFESSIONS.register("gem_cutter",
                    () -> new VillagerProfession("gem_cutter", GEM_CUTTING_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, GEM_CUTTING_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
