package com.github.TeThoLaPot.regen_resources.event;

import com.github.TeThoLaPot.regen_resources.RegenResources;
import com.github.TeThoLaPot.regen_resources.tag.OnblockWorldTags;
import com.github.TeThoLaPot.regen_resources.tag.RegenTags;
import com.github.TeThoLaPot.regen_resources.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RegenResources.MOD_ID)
public class RegenOnblockEvent {

    @SubscribeEvent
    public static void onBlock(BlockEvent.EntityPlaceEvent event){
        if (event.getLevel().isClientSide()) return;

        LevelAccessor levelAccessor = event.getLevel();
        ServerLevel level = (ServerLevel) levelAccessor;
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        OnblockWorldTags onBolckTags = level.getDataStorage().computeIfAbsent(
                OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag"
        );

        if (event.getEntity() instanceof ServerPlayer player && state.is(RegenTags.Blocks.DONE_REGEN)) {
            boolean isPlaced = !player.isCreative();
            onBolckTags.setFlag(pos, isPlaced);


            if (isPlaced) {
                RegenTickUtils.updateFlag(pos, true);
            } else {
                RegenTickUtils.updateFlag(pos, false);
            }
        }
    }
}
