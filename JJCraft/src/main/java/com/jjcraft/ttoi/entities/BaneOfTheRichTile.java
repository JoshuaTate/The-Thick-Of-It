package com.jjcraft.ttoi.entities;

import com.jjcraft.ttoi.init.ItemInit;
import com.jjcraft.ttoi.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class BaneOfTheRichTile extends BlockEntity {
    short timer = 0;
    boolean isActive = true;

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("active", this.isActive);
        nbt.putShort("timer", this.timer);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.isActive = nbt.getBoolean("active");
        this.timer = nbt.getShort("timer");
    }

    public void toggle(){
        this.isActive = !this.isActive;
    }

    public BaneOfTheRichTile(BlockPos pos, BlockState state) {
        super(TileEntityInit.MOB_SLAYER.get(), pos, state);
    }

    final int RANGE = 20;
    private void hurtMobs() {
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
        AABB box = new AABB(topCorner, bottomCorner);

        List<Entity> entities = this.level.getEntities(null, box);
        for (Entity target : entities){
            if (target instanceof LivingEntity && !(target instanceof Player)){
                target.hurt(DamageSource.LIGHTNING_BOLT, 10);
                this.level.playSound(null, this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
            else if(target instanceof Player) {
                boolean hit = false;
                if(((Player) target).getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.CORRUPTED_HELMET.get()) {
                    target.hurt(DamageSource.DRAGON_BREATH, 6);
                    hit = true;
                }
                if(((Player) target).getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.CORRUPTED_CHESTPLATE.get()) {
                    target.hurt(DamageSource.DRAGON_BREATH, 6);
                    hit = true;
                }
                if(((Player) target).getItemBySlot(EquipmentSlot.LEGS).getItem() == ItemInit.CORRUPTED_LEGGINGS.get()) {
                    target.hurt(DamageSource.DRAGON_BREATH, 6);
                    hit = true;
                }
                if(((Player) target).getItemBySlot(EquipmentSlot.FEET).getItem() == ItemInit.CORRUPTED_BOOTS.get()) {
                    target.hurt(DamageSource.DRAGON_BREATH, 6);
                    hit = true;
                }
                if(hit) {
                    this.level.playSound(null, this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ(), SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
        BaneOfTheRichTile tile = (BaneOfTheRichTile) be;
        if (!level.isClientSide() && tile.isActive){
            tile.timer++;
            if (tile.timer > 20){
                tile.timer = 0;

                // only do this once per second
                tile.hurtMobs();
            }
        }
    }
}