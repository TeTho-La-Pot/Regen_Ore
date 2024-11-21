package com.guithub.TeThoLaPot.reore.event;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
public class BreakEvent {
    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event){

        LevelAccessor levelAccessor = event.getLevel();
        ServerLevel level = (ServerLevel) levelAccessor;
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();

        BlockState state = level.getBlockState(pos);

        if (player.isCreative()){
          if (state.is(RegenTags.Blocks.STOP_REGEN)){
                level.removeBlock(pos, false);
          }
        }
    }
}
