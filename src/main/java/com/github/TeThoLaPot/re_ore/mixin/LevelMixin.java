package com.github.TeThoLaPot.re_ore.mixin;

import com.github.TeThoLaPot.re_ore.packet.OnBlockTagPacket;
import com.github.TeThoLaPot.re_ore.packet.RegenNetworkHandler;
import com.github.TeThoLaPot.re_ore.tag.OnblockWorldTags;
import com.github.TeThoLaPot.re_ore.tag.RegenTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {

    @Inject(method = "setBlock", at = @At("HEAD"), remap = true)
    private void onSetBlock(BlockPos pos, BlockState newState, int flags, CallbackInfoReturnable<Boolean> cir) {
        Level level = (Level) (Object) this;

        if (level.getBlockState(pos).is(RegenTags.Blocks.DONE_REGEN) || level.getBlockState(pos).is(RegenTags.Blocks.CAN_REGEN)) {
            if (level.isClientSide || level.getServer() == null || !level.getServer().isReady()) {
                return;
            }

            boolean isMoving = (flags & 64) != 0;

            BlockState oldState = level.getBlockState(pos);

            OnblockWorldTags data = level.getServer().overworld().getDataStorage()
                    .computeIfAbsent(OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag");

            if (newState.isAir()) {
                if (!isMoving) {
                    data.removeFlag(pos);
                    RegenNetworkHandler.sendToAll(new OnBlockTagPacket(pos, true));
                }
            } else if (oldState.getBlock() != newState.getBlock()) {
                data.setFlag(pos, true);
                RegenNetworkHandler.sendToAll(new OnBlockTagPacket(pos, true));


            }
        }
    }
}