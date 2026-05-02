package com.github.TeThoLaPot.regen_resources.jade;

import com.github.TeThoLaPot.tt_core.TT_core;
import com.github.TeThoLaPot.regen_resources.RegenResources;
import com.github.TeThoLaPot.regen_resources.init.entity.RegenBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum RegenResourcesJadeProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        // 対象がRegenBlockEntityか確認
        if (accessor.getBlockEntity() instanceof RegenBlockEntity regenEntity) {
            // サーバーから同期されたデータをTT_core経由で取得
            // ※TT_coreのパケット同期により、クライアント側でもデータが参照可能
            CompoundTag data = TT_core.getBlockData((net.minecraft.server.level.ServerLevel) accessor.getLevel(), accessor.getPosition());

            if (data.contains("execute_at")) {
                // 1. 残り時間の計算
                long remaining = data.getLong("execute_at") - accessor.getLevel().getGameTime();
                if (remaining > 0) {
                    tooltip.add(Component.translatable("tooltip.regen_resources.time_remaining", remaining / 20));
                }

                // 2. 何に戻るか（元の鉱石名）の表示
                // TTDataUtilsで保存したBlockStateから名前を取得
                if (data.contains("state")) {
                    CompoundTag stateTag = data.getCompound("state");
                    String blockId = stateTag.getString("Name");
                    tooltip.add(Component.literal("§7Target: ").append(Component.translatable(blockId)));
                }
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(RegenResources.MOD_ID, "regen_info");
    }
}
