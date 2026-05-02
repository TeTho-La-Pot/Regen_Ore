package com.github.TeThoLaPot.regen_resources.event;

import com.github.TeThoLaPot.regen_resources.init.item.BreakStuff;
import com.github.TeThoLaPot.tt_core.TT_core;
import com.github.TeThoLaPot.tt_core.api.TTDataBank;
import com.github.TeThoLaPot.tt_core.api.TTDataUtils;
import com.github.TeThoLaPot.regen_resources.Config;
import com.github.TeThoLaPot.regen_resources.init.block.Re_Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "regen_resources")
public class RegenBreakEvent {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        BlockState state = event.getState();

        // --- 1. 再生待ちブロック(REGEN_BLOCK)の撤去判定 ---
        if (state.getBlock() == Re_Blocks.REGEN_BLOCK.get()) {
            ItemStack offhandStack = player.getOffhandItem();

            // オフハンドに「破壊装置」を持っているか
            if (offhandStack.getItem() instanceof BreakStuff breakItem) {
                // モードが 1 (ON) かどうかを確認
                if (breakItem.modeNum(offhandStack) == 1) {
                    // 再生予約データを削除して復活を完全に止める
                    TT_core.removeBlockData(level, pos);
                    // ここで return することで、イベントがそのまま進行し、ブロックが破壊されます
                    return;
                }
            }

            // 条件（ONモードの装置をオフハンドに持つ）を満たさない場合は破壊をキャンセル
            // これにより通常ツールや一括破壊MOD等から保護されます
            event.setCanceled(true);
            return;
        }

        // --- 2. 通常の鉱石破壊時の再生予約ロジック ---
        if (Config.isRegenTarget(state)) {
            // サバイバル設置チェック（TT_core API利用）
            if (TT_core.getBlockData(level, pos).getString("origin").equals("player")) return;

            long delay = Config.getDelayForBlock(state);
            CompoundTag data = new CompoundTag();
            TTDataUtils.putBlockPos(data, "pos", pos);
            TTDataUtils.putBlockState(data, "state", state);
            data.putLong("execute_at", level.getGameTime() + delay);
            TT_core.saveBlockData(level, pos, data);

            TTDataBank.schedulePersistentTask(level, "regen_process", delay, data);

            level.getServer().execute(() -> {
                level.setBlock(pos, Re_Blocks.REGEN_BLOCK.get().defaultBlockState(), 3);
            });
        }
    }


    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        if (event.getEntity() instanceof Player player && !player.isCreative()) {
            CompoundTag data = new CompoundTag();
            data.putString("origin", "player");
            TT_core.saveBlockData(level, event.getPos(), data);
        }
    }
}
