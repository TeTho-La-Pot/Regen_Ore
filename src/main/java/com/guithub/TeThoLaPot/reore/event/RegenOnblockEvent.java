package com.guithub.TeThoLaPot.reore.event;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import com.guithub.TeThoLaPot.reore.tag.RegenWorldTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.x;

@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
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
        }
    }
}
