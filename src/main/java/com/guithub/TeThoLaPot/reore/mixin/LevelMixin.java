package com.guithub.TeThoLaPot.reore.mixin;

import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {

    @Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z", at = @At("HEAD"))
    private void onSetBlock(BlockPos pos, BlockState newState, int flags, int recursion, CallbackInfoReturnable<Boolean> cir) {
        Level level = (Level) (Object) this;

        // 1. クライアントサイドおよび、サーバーがまだ準備できていない（初期生成中）場合は除外
        if (level.isClientSide || level.getServer() == null || !level.getServer().isReady()) {
            return;
        }

        // 2. ピストンによる移動処理（Flag 64）での呼び出しを除外
        // PistonMoveMixin で別途「データの引っ越し」を管理しているため、ここで新規付与してはいけない
        if ((flags & 64) != 0) {
            return;
        }

        OnblockWorldTags data = level.getServer().overworld().getDataStorage()
                .computeIfAbsent(OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag");

        if (newState.isAir()) {
            // 空気（破壊）される場合はフラグを削除
            data.removeFlag(pos);
        } else {
            // それ以外（プレイヤー設置、コマンド、他MODの設置）はフラグを付与
            data.setFlag(pos, true);
        }
    }
}
