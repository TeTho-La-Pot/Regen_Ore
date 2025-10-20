package com.guithub.TeThoLaPot.reore.jade;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.init.entity.RegenOreEntity;
import com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils;
import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import com.guithub.TeThoLaPot.reore.util.TickaleBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

import static com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils.*;
import static com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils.n_preset10;

public enum RegenTickComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config){
        if (RegenTickUtils.isCanRegen(accessor.getBlockState())) {
            if (accessor.getServerData().contains("Tick")) {
                tooltip.add(Component.translatable("re_ore.regen", accessor.getServerData().getInt("Tick"))
                        .append("%"));
            }
        }
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        TickaleBlockEntity tickale = (TickaleBlockEntity) accessor.getBlockEntity();
        BlockState state = accessor.getBlockState();

        if (state.is(ModBlocks.TEST_ORE.get())){
            data.putInt("Tick", (int) (100 / preset01 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET01.get())){
            data.putInt("Tick", (int) (100 / preset01 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET02.get())){
            data.putInt("Tick", (int) (100 / preset02 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET03.get())){
            data.putInt("Tick", (int) (100 / preset03 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET04.get())){
            data.putInt("Tick", (int) (100 / preset04 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET05.get())){
            data.putInt("Tick", (int) (100 / preset05 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET06.get())){
            data.putInt("Tick", (int) (100 / preset06 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET07.get())){
            data.putInt("Tick", (int) (100 / preset07 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET08.get())){
            data.putInt("Tick", (int) (100 / preset08 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET09.get())){
            data.putInt("Tick", (int) (100 / preset09 * tickale.ticker()));
        }
        if (state.is(ModBlocks.REGEN_PRESET10.get())){
            data.putInt("Tick", (int) (100 / preset10 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET01.get())){
            data.putInt("Tick", (int) (100 / d_preset01 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET02.get())){
            data.putInt("Tick", (int) (100 / d_preset02 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET03.get())){
            data.putInt("Tick", (int) (100 / d_preset03 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET04.get())){
            data.putInt("Tick", (int) (100 / d_preset04 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET05.get())){
            data.putInt("Tick", (int) (100 / d_preset05 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET06.get())){
            data.putInt("Tick", (int) (100 / d_preset06 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET07.get())){
            data.putInt("Tick", (int) (100 / d_preset07 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET08.get())){
            data.putInt("Tick", (int) (100 / d_preset08 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET09.get())){
            data.putInt("Tick", (int) (100 / d_preset09 * tickale.ticker()));
        }
        if (state.is(ModBlocks.D_REGEN_PRESET10.get())){
            data.putInt("Tick", (int) (100 / d_preset10 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET01.get())){
            data.putInt("Tick", (int) (100 / n_preset01 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET02.get())){
            data.putInt("Tick", (int) (100 / n_preset02 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET03.get())){
            data.putInt("Tick", (int) (100 / n_preset03 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET04.get())){
            data.putInt("Tick", (int) (100 / n_preset04 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET05.get())){
            data.putInt("Tick", (int) (100 / n_preset05 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET06.get())){
            data.putInt("Tick", (int) (100 / n_preset06 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET07.get())){
            data.putInt("Tick", (int) (100 / n_preset07 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET08.get())){
            data.putInt("Tick", (int) (100 / n_preset08 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET09.get())){
            data.putInt("Tick", (int) (100 / n_preset09 * tickale.ticker()));
        }
        if (state.is(ModBlocks.N_REGEN_PRESET10.get())){
            data.putInt("Tick", (int) (100 / n_preset10 * tickale.ticker()));
        }
    }

    @Override
    public ResourceLocation getUid(){
        return new ResourceLocation(RE_Ore.MOD_ID, "regen_tick");
    }
}
