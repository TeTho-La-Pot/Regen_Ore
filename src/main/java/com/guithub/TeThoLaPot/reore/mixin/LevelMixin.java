package com.guithub.TeThoLaPot.reore.mixin;

import com.guithub.TeThoLaPot.reore.packet.OnBlockTagPacket;
import com.guithub.TeThoLaPot.reore.packet.RegenNetworkHandler;
import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
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