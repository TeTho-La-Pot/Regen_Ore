package com.github.TeThoLaPot.regen_resources.event;

import com.github.TeThoLaPot.regen_resources.Config;
import com.github.TeThoLaPot.regen_resources.RegenResources;
import com.github.TeThoLaPot.regen_resources.init.block.Re_Blocks;
import com.github.TeThoLaPot.tt_core.TT_core;
import com.github.TeThoLaPot.tt_core.api.TTDataBank;
import com.github.TeThoLaPot.tt_core.api.TTDataUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// 指定された形式に変更
@Mod.EventBusSubscriber(modid = RegenResources.MOD_ID)
public class ResourceRegenEvent {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        BlockState brokenState = event.getState();
        BlockPos pos = event.getPos();

        // 1. 再生対象か、かつプレイヤー設置（サバイバル）ではないかチェック
        CompoundTag posData = TT_core.getBlockData(level, pos);
        boolean isPlayerPlaced = posData.getString("origin").equals("player");

        if (Config.isRegenTarget(brokenState) && !isPlayerPlaced) {
            // 2. 座標に「何に戻るか」の情報を保存
            CompoundTag data = new CompoundTag();
            TTDataUtils.putBlockPos(data, "pos", pos);
            TTDataUtils.putBlockState(data, "state", brokenState);
            TT_core.saveBlockData(level, pos, data);

            // 3. 未来の再生を予約
            TTDataBank.schedulePersistentTask(level, "regen_process", Config.REGEN_DELAY.get(), data);

            // 4. 壊れた場所に RegenBlock を設置
            // event.setCanceled(true) はせず、直後にBlockを置換する形が1.21でも安定します
            level.getServer().execute(() -> {
                level.setBlock(pos, Re_Blocks.REGEN_BLOCK.get().defaultBlockState(), 3);
            });
        }
    }

}
