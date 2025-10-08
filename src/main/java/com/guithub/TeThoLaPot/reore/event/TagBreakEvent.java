package com.guithub.TeThoLaPot.reore.event;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.guithub.TeThoLaPot.reore.tag.RegenTags.Blocks.V_REGEN;

@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
public class TagBreakEvent extends ModBlocks {

    @SubscribeEvent
    public static void getTagBreakEvent(BlockEvent.BreakEvent event){

        LevelAccessor levelAccessor = event.getLevel();
        ServerLevel level = (ServerLevel) levelAccessor;
        Player player = event.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        CompoundTag breakedBlockTag = new CompoundTag();

//        if (state.is(V_REGEN)) {
//            breakedBlockTag.put("state", NbtUtils.writeBlockState(state));
//
//
//        }
    }
}
