package com.jjcraft.ttoi.entity.client.armor;

import com.jjcraft.ttoi.item.custom.CitrineArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CitrineArmorRenderer extends GeoArmorRenderer<CitrineArmorItem> {
    public CitrineArmorRenderer() {
        super(new CitrineArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
