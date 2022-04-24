package com.jjcraft.ttoi.blocks;

import com.jjcraft.ttoi.util.HelperMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class Wheatsoil_Farmland extends FarmBlock {

    public Wheatsoil_Farmland(Block.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        Item[] hoes = {Items.WOODEN_HOE,Items.STONE_HOE,Items.IRON_HOE,Items.GOLDEN_HOE,Items.DIAMOND_HOE,Items.NETHERITE_HOE};

        if (!world.isClientSide() && HelperMethods.arrayContainsObject(hoes, held.getItem())) {
            BlockState above = world.getBlockState(pos.above());
            return InteractionResult.CONSUME;
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        Block plant = plantable.getPlant(world, pos.relative(facing)).getBlock();

        if (plant == Blocks.WHEAT) {
            return true;
        } else {
            return super.canSustainPlant(state, world, pos, facing, plantable);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        BlockState above = world.getBlockState(pos.above());
        if (above.isAir()){
            world.setBlockAndUpdate(pos.above(), Blocks.WHEAT.defaultBlockState());
        }
    }
}