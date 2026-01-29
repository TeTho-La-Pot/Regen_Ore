package com.guithub.TeThoLaPot.reore.init.entity;

import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.guithub.TeThoLaPot.reore.tag.RegenWorldTags;
import com.guithub.TeThoLaPot.reore.util.TickaleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import static com.guithub.TeThoLaPot.reore.util.RegenWorkUtils.*;

public class RegenOreEntity extends BlockEntity implements TickaleBlockEntity {
    private int ticks;
    private BlockState savedState;
    private BlockPos savedPos;

    public RegenOreEntity(BlockPos Pos, BlockState State) {
        super(BlockEntities.REGEN_ORE_ENTITY.get(), Pos, State);
    }

    @Override
    public void tick() {
        this.ticks++;

        BlockState state = this.getBlockState();
        BlockPos pos = this.getBlockPos();

        RegenWorldTags worldTags = ((ServerLevel) level).getDataStorage().computeIfAbsent(
                RegenWorldTags::load,RegenWorldTags::new,"regen_world_tag");
        OnblockWorldTags onBolckTags = ((ServerLevel) level).getDataStorage().computeIfAbsent(
                OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag"
        );

        ListTag regenList = worldTags.getRegenBlockList();

        for (int i = regenList.size() - 1; i >= 0; i--){
            CompoundTag stateTag = regenList.getCompound(i);
            CompoundTag posTag = regenList.getCompound(i);

        if (this.level == null || this.level.isClientSide()) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            return;
        }

            if (state.is(ModBlocks.REGEN_PRESET01.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_1"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_1"));
                if (this.ticks >= preset01 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset01 + 10) {
                            this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                        }
                    }
                }
            if (state.is(ModBlocks.REGEN_PRESET02.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_2"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_2"));
                if (this.ticks >= preset02 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset02 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET03.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_3"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_3"));
                if (this.ticks >= preset03 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset03 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET04.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_4"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_4"));
                if (this.ticks >= preset04 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset04 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET05.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_5"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_5"));
                if (this.ticks >= preset05 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset05 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET06.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_6"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_6"));
                if (this.ticks >= preset06 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset06 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET07.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_7"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_7"));
                if (this.ticks >= preset07 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset07 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET08.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_8"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_8"));
                if (this.ticks >= preset08 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset08 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET09.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_9"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_9"));
                if (this.ticks >= preset09 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset09 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.REGEN_PRESET10.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_10"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_10"));
                if (this.ticks >= preset10 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= preset10 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }

            if (state.is(ModBlocks.D_REGEN_PRESET01.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_1"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_1"));
                if (this.ticks >= d_preset01 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset01 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET02.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_2"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_2"));
                if (this.ticks >= d_preset02 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset02 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET03.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_3"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_3"));
                if (this.ticks >= d_preset03 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset03 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET04.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_4"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_4"));
                if (this.ticks >= d_preset04 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset04 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET05.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_5"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_5"));
                if (this.ticks >= d_preset05 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset05 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET06.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_6"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_6"));
                if (this.ticks >= d_preset06 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset06 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET07.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_7"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_7"));
                if (this.ticks >= d_preset07 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset07 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET08.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_8"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_8"));
                if (this.ticks >= d_preset08 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset08 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET09.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_9"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_9"));
                if (this.ticks >= d_preset09 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset09 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.D_REGEN_PRESET10.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_10"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_10"));
                if (this.ticks >= d_preset10 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= d_preset10 + 10){
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }

            if (state.is(ModBlocks.N_REGEN_PRESET01.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_1"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_1"));
                if (this.ticks >= n_preset01 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset01 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET02.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_2"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_2"));
                if (this.ticks >= n_preset02 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset02 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET03.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_3"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_3"));
                if (this.ticks >= n_preset03 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset03 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET04.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_4"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_4"));
                if (!(this.ticks < n_preset04) && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset04 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET05.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_5"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_5"));
                if (this.ticks >= n_preset05 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset05 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET06.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_6"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_6"));
                if (this.ticks >= n_preset06 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset06 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET07.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_7"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_7"));
                if (this.ticks >= n_preset07 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset07 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET08.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_8"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_8"));
                if (this.ticks >= n_preset08 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset08 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET09.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_9"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_9"));
                if (this.ticks >= n_preset09 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset09 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            if (state.is(ModBlocks.N_REGEN_PRESET10.get())) {
                this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_10"));
                this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_10"));
                if (this.ticks >= n_preset10 && pos.equals(savedPos)) {
                    this.level.setBlock(pos, savedState, 3);
                    regenList.remove(i);
                    this.setChanged();
                }else {
                    if (this.ticks >= n_preset10 + 10) {
                        this.level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }

            if (onBolckTags.hasFlag(pos) == true){
                onBolckTags.setFlag(pos, false);
            } else {
                onBolckTags.removeFlag(pos);
            }

                if (regenList.isEmpty()) {
                    regenList.remove("regen_block_list");
            }
        }
    }

    @Override
    public int ticker() {
        return ticks;
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

