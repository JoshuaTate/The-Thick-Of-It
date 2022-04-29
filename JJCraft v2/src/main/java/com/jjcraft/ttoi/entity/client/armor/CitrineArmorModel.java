package com.jjcraft.ttoi.entity.client.armor;

import com.jjcraft.ttoi.TTOIMain;
import com.jjcraft.ttoi.item.custom.CitrineArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitrineArmorModel extends AnimatedGeoModel<CitrineArmorItem> {
    @Override
    public ResourceLocation getModelLocation(CitrineArmorItem object) {
        return new ResourceLocation(TTOIMain.MOD_ID, "geo/citrine_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CitrineArmorItem object) {
        return new ResourceLocation(TTOIMain.MOD_ID, "textures/models/armor/citrine_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CitrineArmorItem animatable) {
        return new ResourceLocation(TTOIMain.MOD_ID, "animations/armor_animation.json");
    }
}
