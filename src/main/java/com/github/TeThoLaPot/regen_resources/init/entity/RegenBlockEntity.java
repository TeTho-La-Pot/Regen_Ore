package com.github.TeThoLaPot.regen_resources.init.entity;

import com.github.TeThoLaPot.tt_core.TT_core;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RegenBlockEntity extends BlockEntity {

    public RegenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.REGEN_ORE_ENTITY.get(), pos, state);
    }

    /**
     * Jade (Waila) などから「何のブロックに戻るか」を取得するための補助メソッド
     */
    public CompoundTag getRegenData() {
        if (this.level instanceof ServerLevel serverLevel) {
            return TT_core.getBlockData(serverLevel, this.worldPosition);
        }
        // クライアント側の場合は、APIで作成した TTClientData から取得
        // (TT_coreのパケット同期機能がここで活きます)
        return com.github.TeThoLaPot.tt_core.network.TTClientData.getPlayerData();
        // ※実際には座標ごとの同期パケットを今後追加するとより正確になります。
    }

    /**
     * 再生までの残り時間を計算する
     */
    public long getRemainingTicks() {
        CompoundTag data = getRegenData();
        if (data.contains("execute_at")) {
            return data.getLong("execute_at") - this.level.getGameTime();
        }
        return -1;
    }
}


