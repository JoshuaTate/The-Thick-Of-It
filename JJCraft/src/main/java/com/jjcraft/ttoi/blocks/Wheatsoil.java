package com.jjcraft.ttoi.blocks;

import com.jjcraft.ttoi.init.BlockInit;
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
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class Wheatsoil extends Block {

    public Wheatsoil(Block.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        Item[] hoes = {Items.WOODEN_HOE,Items.STONE_HOE,Items.IRON_HOE,Items.GOLDEN_HOE,Items.DIAMOND_HOE,Items.NETHERITE_HOE};

        if (!world.isClientSide() && HelperMethods.arrayContainsObject(hoes, held.getItem())) {
            world.setBlockAndUpdate(pos, BlockInit.WHEATSOIL_FARMLAND.get().defaultBlockState());
            return InteractionResult.SUCCESS;
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        world.setBlockAndUpdate(pos, BlockInit.WHEATGRASS.get().defaultBlockState());
    }
}
