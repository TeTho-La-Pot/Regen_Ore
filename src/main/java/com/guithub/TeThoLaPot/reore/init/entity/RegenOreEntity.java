package com.guithub.TeThoLaPot.reore.init.entity;

import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.util.TickaleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils.*;

public class RegenOreEntity extends BlockEntity implements TickaleBlockEntity {
    private int ticks;


    public RegenOreEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.REGEN_ORE_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void tick() {
        BlockState state = getBlockState();
        BlockPos pos = getBlockPos();


        if (this.level == null || this.level.isClientSide()) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            return;
        }


        if (state.is(ModBlocks.REGEN_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_IRON_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_IRON_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickCopper) {
                this.level.setBlock(pos, ModBlocks.REGENED_COPPER_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDCopper) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_COPPER_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickGold) {
                this.level.setBlock(pos, ModBlocks.REGENED_GOLD_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDGold) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_GOLD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_NETHER_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickNGold) {
                this.level.setBlock(pos, ModBlocks.REGENED_NETHER_GOLD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DIAMOND_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDiamond) {
                this.level.setBlock(pos, ModBlocks.REGENED_DIAMOND_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDDiamond) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_DIAMOND_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickEmerald) {
                this.level.setBlock(pos, ModBlocks.REGENED_EMERALD_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDEmerald) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_EMERALD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickCoal) {
                this.level.setBlock(pos, ModBlocks.REGENED_COAL_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDCoal) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_COAL_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickLapis) {
                this.level.setBlock(pos, ModBlocks.REGENED_LAPIS_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDLapis) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_LAPIS_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickRedstone) {
                this.level.setBlock(pos, ModBlocks.REGENED_REDSTONE_ORE.get().defaultBlockState(), 3);
            }
        }
        if(state.is(ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDRedstone) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickNQuartz) {
                this.level.setBlock(pos, ModBlocks.REGENED_NETHER_QUARTZ_ORE.get().defaultBlockState(), 3);
            }
        }
    }

    @Override
    public int ticker() {
        return ticks++;
    }



    @Nullable
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        saveAdditional(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        handleUpdateTag(pkt.getTag());
    }
}

