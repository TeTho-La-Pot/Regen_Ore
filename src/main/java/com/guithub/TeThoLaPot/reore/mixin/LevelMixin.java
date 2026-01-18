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

        if (level.isClientSide || level.getServer() == null || !level.getServer().isReady()) {
            return;
        }

        if ((flags & 64) != 0) {
            return;
        }

        BlockState oldState = level.getBlockState(pos);

        OnblockWorldTags data = level.getServer().overworld().getDataStorage()
                .computeIfAbsent(OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag");

        if (newState.isAir()) {
            data.removeFlag(pos);
        } else if (oldState.getBlock() != newState.getBlock()){
            data.setFlag(pos, true);
        }
    }
}
