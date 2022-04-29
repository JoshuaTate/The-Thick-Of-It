package com.jjcraft.ttoi.world;

import com.jjcraft.ttoi.world.gen.ModEntityGeneration;
import com.jjcraft.ttoi.world.gen.ModTreeGeneration;
import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.world.gen.ModFlowerGeneration;
import com.jjcraft.ttoi.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TTOIMain.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);

        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);

        ModEntityGeneration.onEntitySpawn(event);
    }
}
