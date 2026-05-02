package com.github.TeThoLaPot.regen_resources.mixin;

import com.github.TeThoLaPot.tt_core.TT_core;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {

    /**
     * setBlockメソッドに割り込み、ブロックが変更（置換や移動による削除）される際に
     * その座標に紐づいている再生データや設置情報を削除します。
     * これにより、ピストン移動などで鉱石の位置が変わった際に古い場所から再生されるのを防ぎます。
     */
    @Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z", at = @At("HEAD"))
    private void onSetBlock(BlockPos pos, BlockState state, int flags, int recursionLeft, CallbackInfoReturnable<Boolean> cir) {
        Level level = (Level) (Object) this;

        // サーバー側のみ処理
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            TT_core.removeBlockData(serverLevel, pos);
        }
    }
}
