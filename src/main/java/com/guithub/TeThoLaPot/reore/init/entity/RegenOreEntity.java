package com.guithub.TeThoLaPot.reore.init.entity;

import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.tag.RegenCTags;
import com.guithub.TeThoLaPot.reore.util.TickaleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.guithub.TeThoLaPot.reore.event.RegenBreakEvent;
import org.jetbrains.annotations.Nullable;

import static com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils.*;
import static net.minecraft.core.registries.Registries.BLOCK;

public class RegenOreEntity extends BlockEntity implements TickaleBlockEntity {
    private int ticks;
    private BlockState savedState;

    public RegenOreEntity(BlockPos Pos, BlockState State) {
        super(BlockEntities.REGEN_ORE_ENTITY.get(), Pos, State);
    }

//    @Override
//    public void load(CompoundTag regenStateTag){
//        super.saveAdditional(regenStateTag);
//        if (this.savedState !=null){
//            regenStateTag.put("state_r",NbtUtils.writeBlockState(this.savedState));
//        }
//    }

    @Override
    public void tick() {

        CompoundTag re_tag = RegenCTags.getAndClearTag();

        BlockState state = getBlockState();
        BlockPos pos = getBlockPos();
        HolderLookup.RegistryLookup<Block> blockLookup = this.level.registryAccess().lookupOrThrow(Registries.BLOCK);


        if (this.level == null || this.level.isClientSide()) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            return;
        }

//追加鉱石

        if (state.is(ModBlocks.REGEN_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_IRON_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_IRON_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_COPPER_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_COPPER_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_GOLD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, ModBlocks.REGENED_IRON_ORE.get().defaultBlockState(), 3);
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
        if (state.is(ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDDiamond) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_DIAMOND_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickEmerald) {
                this.level.setBlock(pos, ModBlocks.REGENED_EMERALD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDEmerald) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_EMERALD_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickCoal) {
                this.level.setBlock(pos, ModBlocks.REGENED_COAL_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDCoal) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_COAL_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickLapis) {
                this.level.setBlock(pos, ModBlocks.REGENED_LAPIS_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDLapis) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_LAPIS_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickRedstone) {
                this.level.setBlock(pos, ModBlocks.REGENED_REDSTONE_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDRedstone) {
                this.level.setBlock(pos, ModBlocks.REGENED_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickNQuartz) {
                this.level.setBlock(pos, ModBlocks.REGENED_NETHER_QUARTZ_ORE.get().defaultBlockState(), 3);
            }
        }

//バニラ鉱石

        if (state.is(ModBlocks.V_REGEN_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickIron) {
                this.level.setBlock(pos, Blocks.IRON_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_IRON_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDIron) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickCopper) {
                this.level.setBlock(pos, Blocks.COPPER_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDCopper) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickGold) {
                this.level.setBlock(pos, Blocks.GOLD_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDGold) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_NETHER_GOLD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickNGold) {
                this.level.setBlock(pos, Blocks.NETHER_GOLD_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DIAMOND_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDiamond) {
                this.level.setBlock(pos, Blocks.DIAMOND_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDDiamond) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickEmerald) {
                this.level.setBlock(pos, Blocks.EMERALD_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDEmerald) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickCoal) {
                this.level.setBlock(pos, Blocks.COAL_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_COAL_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDCoal) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_COAL_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickLapis) {
                this.level.setBlock(pos, Blocks.LAPIS_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDLapis) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickRedstone) {
                this.level.setBlock(pos, Blocks.REDSTONE_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickDRedstone) {
                this.level.setBlock(pos, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), 3);
            }
        }
        if (state.is(ModBlocks.V_REGEN_NETHER_QUARTZ_ORE_ENTITY.get())) {
            if (this.ticks++ >= tickNQuartz) {
                this.level.setBlock(pos, Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 3);
            }
        }

        //TEST
        if (state.is(ModBlocks.TEST_ORE.get())) {

            CompoundTag testTag = new CompoundTag();
//            HolderLookup.RegistryLookup<Block> blockLookup = this.level.registryAccess().lookupOrThrow(Registries.BLOCK);
            this.savedState = NbtUtils.readBlockState(this.level.registryAccess().lookupOrThrow(Registries.BLOCK), re_tag.getCompound("state_r"));
            if (this.ticks++ >= 100) {
                this.level.setBlock(pos, savedState, 3);
            }
        }

//Create

//        if (ModList.get().isLoaded("create")) {
//            if (state.is(ModBlocks.CREATE_ZINC_ORE_ENTITY.get())) {
//                if (this.ticks++ >= tickZinc) {
//                    this.level.setBlock(pos, AllBlocks.ZINC_ORE.get().defaultBlockState(), 3);
//                }
//            }
//            if (state.is(ModBlocks.CREATE_DEEPSLATE_ZINC_ORE_ENTITY.get())) {
//                if (this.ticks++ >= tickDZinc) {
//                    this.level.setBlock(pos, AllBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState(), 3);
//                }
//            }
//        }

//Mekanism

//        if (ModList.get().isLoaded("mekanism")) {
//            if (state.is(ModBlocks.MEKANISM_TIN_ORE_ENTITY.get())) {
//                if (this.ticks++ >= tickZinc) {
//                    this.level.setBlock(pos, MekanismBlocks.ORES.get(OreType.TIN).stoneBlock().defaultBlockState(), 3);
//                }
//            }
//            if (state.is(ModBlocks.MEKANISM_DEEPSLATE_TIN_ORE_ENTITY.get())) {
//                if (this.ticks++ >= tickDZinc) {
//                    this.level.setBlock(pos, MekanismBlocks.ORES.get(OreType.TIN).deepslateBlock().defaultBlockState(), 3);
//                }
//            }
//        }
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

