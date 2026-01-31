package com.guithub.TeThoLaPot.reore.jade;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.Re_Blocks;
import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import com.guithub.TeThoLaPot.reore.tag.RegenWorldTags;
import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import com.guithub.TeThoLaPot.reore.util.TickaleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

import static com.guithub.TeThoLaPot.reore.util.RegenWorkUtils.*;

public enum RegenTickComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    private BlockState savedState;
    private BlockPos savedPos;



    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        BlockState state = accessor.getBlockState();
        BlockPos pos = accessor.getPosition();

        if (RegenTickUtils.isCanRegen(state)){
            if (accessor.getServerData().contains("regen_block")){
                tooltip.add(Component.translatable("re_ore.regen_block", accessor.getServerData().getString("regen_block")));
            }
        }

        if (RegenTickUtils.isCanRegen(state) || RegenTickUtils.isDoneRegen(state)) {
            if (accessor.getServerData().contains("can_regen")) {
                tooltip.add(Component.translatable("re_ore.can_regen", accessor.getServerData().getBoolean("can_regen")));
            } else {
                if (RegenTickUtils.onBlockSync(pos) == false){
                    tooltip.add(Component.translatable("re_ore.can_regen", true));
                } else if (RegenTickUtils.onBlockSync(pos) == true){
                    tooltip.add(Component.translatable("re_ore.can_regen", false));
                }
            }
        }

        if (RegenTickUtils.isCanRegen(state)) {
            if (accessor.getServerData().contains("Tick")) {
                tooltip.add(Component.translatable("re_ore.regen", accessor.getServerData().getInt("Tick"))
                        .append("%"));
            }
        }
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {

        Level level = accessor.getLevel();
        if (!(level instanceof ServerLevel serverLevel)) return;
        BlockPos pos = accessor.getPosition();
        BlockState state = accessor.getBlockState();

        RegenWorldTags worldTags = serverLevel.getDataStorage().computeIfAbsent(
                RegenWorldTags::load, RegenWorldTags::new, "regen_world_tag"
        );
        OnblockWorldTags onBolckTags = serverLevel.getDataStorage().computeIfAbsent(
                OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag"
        );

        ListTag regenList = worldTags.getRegenBlockList();

        for (int i = regenList.size() - 1; i >= 0; i--) {
            CompoundTag stateTag = regenList.getCompound(i);
            CompoundTag posTag = regenList.getCompound(i);


            if (state.is(RegenTags.Blocks.CAN_REGEN) || state.is(RegenTags.Blocks.DONE_REGEN)) {
                boolean flag = onBolckTags.getFlag(pos);
                boolean hasFlag = onBolckTags.hasFlag(pos);
                data.putBoolean("can_regen", !flag);
            }

            if (accessor.getBlockEntity() instanceof TickaleBlockEntity tickale) {

                if (state.is(Re_Blocks.REGEN_PRESET01.get())) {
                    data.putInt("Tick", (int) (100 / preset01 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_1"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_1"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET02.get())) {
                    data.putInt("Tick", (int) (100 / preset02 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_2"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_2"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET03.get())) {
                    data.putInt("Tick", (int) (100 / preset03 * tickale.ticker()));
                }
                if (state.is(Re_Blocks.REGEN_PRESET04.get())) {
                    data.putInt("Tick", (int) (100 / preset04 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_4"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_4"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET05.get())) {
                    data.putInt("Tick", (int) (100 / preset05 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_5"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_5"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET06.get())) {
                    data.putInt("Tick", (int) (100 / preset06 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_6"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_6"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET07.get())) {
                    data.putInt("Tick", (int) (100 / preset07 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_7"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_7"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET08.get())) {
                    data.putInt("Tick", (int) (100 / preset08 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_8"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_8"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET09.get())) {
                    data.putInt("Tick", (int) (100 / preset09 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_9"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_9"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.REGEN_PRESET10.get())) {
                    data.putInt("Tick", (int) (100 / preset10 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("state_10"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("pos_10"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET01.get())) {
                    data.putInt("Tick", (int) (100 / d_preset01 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_1"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_1"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET02.get())) {
                    data.putInt("Tick", (int) (100 / d_preset02 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_2"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_2"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET03.get())) {
                    data.putInt("Tick", (int) (100 / d_preset03 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_3"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_3"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET04.get())) {
                    data.putInt("Tick", (int) (100 / d_preset04 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_4"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_4"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET05.get())) {
                    data.putInt("Tick", (int) (100 / d_preset05 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_5"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_5"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET06.get())) {
                    data.putInt("Tick", (int) (100 / d_preset06 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_6"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_6"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET07.get())) {
                    data.putInt("Tick", (int) (100 / d_preset07 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_7"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_7"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET08.get())) {
                    data.putInt("Tick", (int) (100 / d_preset08 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_8"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_8"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET09.get())) {
                    data.putInt("Tick", (int) (100 / d_preset09 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_9"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_9"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.D_REGEN_PRESET10.get())) {
                    data.putInt("Tick", (int) (100 / d_preset10 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("d_state_10"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("d_pos_10"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET01.get())) {
                    data.putInt("Tick", (int) (100 / n_preset01 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_1"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_1"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET02.get())) {
                    data.putInt("Tick", (int) (100 / n_preset02 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_2"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_2"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET03.get())) {
                    data.putInt("Tick", (int) (100 / n_preset03 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_3"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_3"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET04.get())) {
                    data.putInt("Tick", (int) (100 / n_preset04 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_4"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_4"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET05.get())) {
                    data.putInt("Tick", (int) (100 / n_preset05 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_5"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_5"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET06.get())) {
                    data.putInt("Tick", (int) (100 / n_preset06 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_6"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_6"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET07.get())) {
                    data.putInt("Tick", (int) (100 / n_preset07 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_7"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_7"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET08.get())) {
                    data.putInt("Tick", (int) (100 / n_preset08 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_8"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_8"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET09.get())) {
                    data.putInt("Tick", (int) (100 / n_preset09 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_9"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_9"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.N_REGEN_PRESET10.get())) {
                    data.putInt("Tick", (int) (100 / n_preset10 * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("n_state_10"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("n_pos_10"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
                if (state.is(Re_Blocks.DEBRIS_REGEN_PRESET.get())) {
                    data.putInt("Tick", (int) (100 / debris_preset * tickale.ticker()));
                    this.savedState = NbtUtils.readBlockState(serverLevel.registryAccess().lookupOrThrow(Registries.BLOCK), stateTag.getCompound("debris_state"));
                    this.savedPos = NbtUtils.readBlockPos(posTag.getCompound("debris_pos"));
                    String blockName = savedState.getBlock().getName().getString();
                    if (pos.equals(savedPos)) {
                        data.putString("regen_block", blockName);
                    }
                }
            }
        }
    }

    @Override
    public ResourceLocation getUid(){
        return new ResourceLocation(RE_Ore.MOD_ID, "regen_tick");
    }
}
