package com.guithub.TeThoLaPot.reore.mixin;

import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(PistonBaseBlock.class)
public class PistonMoveMixin {

    @Inject(method = "moveBlocks", at = @At("HEAD"), remap = true)
    private void onMoveBlocks(Level level, BlockPos pos, Direction direction, boolean extending, CallbackInfoReturnable<Boolean> cir) {
        if (level.isClientSide || !(level instanceof ServerLevel serverLevel)) return;

        PistonStructureResolver resolver = new PistonStructureResolver(level, pos, direction, extending);
        if (resolver.resolve()) {
            List<BlockPos> movedPositions = resolver.getToPush();
            OnblockWorldTags data = serverLevel.getDataStorage().computeIfAbsent(OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag");

            for (BlockPos oldPos : movedPositions) {
                BlockPos destination = oldPos.relative(direction);
                data.removeFlag(destination);
            }

            Map<BlockPos, Boolean> updates = new HashMap<>();
            for (BlockPos oldPos : movedPositions) {
                    updates.put(oldPos.relative(direction), true);
                    data.removeFlag(oldPos);
            }

            updates.forEach(data::setFlag);
        }
    }
}