package com.jjcraft.ttoi.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class CNFurnace extends FurnaceBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CNFurnace(Block.Properties properties) {
        super(properties);
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true, Explosion.BlockInteraction.DESTROY);
        super.wasExploded(world, pos, explosion);
    }
}