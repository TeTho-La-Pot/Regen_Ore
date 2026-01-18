package com.guithub.TeThoLaPot.reore.event;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import com.guithub.TeThoLaPot.reore.tag.RegenWorldTags;
import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import static com.guithub.TeThoLaPot.reore.item.Items.TORE;


@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
public class RegenBreakEvent extends ModBlocks {
    private BlockState pState;
    private BlockPos pPos;

    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event) {
        CompoundTag newRegenTag = new CompoundTag();
        LevelAccessor levelAccessor = event.getLevel();
        ServerLevel level = (ServerLevel) levelAccessor;
        Player player = event.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        BlockEntity bEntity = event.getLevel().getBlockEntity(event.getPos());
        Holder<Level> dimensionHolder = levelAccessor.registryAccess().registryOrThrow(Registries.DIMENSION).getHolder(level.dimension()).orElse(null);


        if (levelAccessor.isClientSide()) {
            return;
        }

        boolean isRegenDimension = dimensionHolder.is(RegenTags.Dimensions.REGEN_DIMENSION);
//        System.out.println("HAVE TAGS?:" + isRegenDimension);
//        System.out.println("DIMENSION:" + ((ServerLevel) levelAccessor).dimension().location());

        if (dimensionHolder != null && isRegenDimension) {

            RegenWorldTags worldTags = level.getDataStorage().computeIfAbsent(
                    RegenWorldTags::load, RegenWorldTags::new, "regen_world_tag"
            );
            OnblockWorldTags onBolckTags = level.getDataStorage().computeIfAbsent(
                    OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag"
            );

            if (player.isCreative()) {
                if (RegenTickUtils.isCanRegen(levelAccessor.getBlockState(pos)) || RegenTickUtils.isDoneRegen(levelAccessor.getBlockState(pos))) {
                    level.removeBlock(pos, false);
                }
            } else if (onBolckTags.getFlag(pos) == false || onBolckTags == null) {
                if (!offHand.is(TORE.get()) || offHand.getTag().getInt("mode") == 0) {
                    if (state.is(RegenTags.Blocks.CAN_REGEN)) {
                        event.setCanceled(true);
                    }

                    if (state.is(RegenTags.Blocks.PRESET_01)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_1", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_1", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET01.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_02)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_2", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_2", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET02.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_03)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_3", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_3", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET03.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_04)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_4", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_4", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET04.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_05)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_5", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_5", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET05.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_06)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_6", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_6", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET06.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_07)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_7", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_7", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET07.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_08)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_8", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_8", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET08.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_09)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_9", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_9", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET09.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.PRESET_10)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("state_10", NbtUtils.writeBlockState(state));
                        newRegenTag.put("pos_10", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.REGEN_PRESET10.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_01)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_1", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_1", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET01.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_02)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_2", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_2", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET02.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_03)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_3", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_3", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET03.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_04)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_4", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_4", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET04.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_05)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_5", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_5", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET05.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_06)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_6", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_6", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET06.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_07)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_7", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_7", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET07.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_08)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_8", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_8", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET08.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_09)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_9", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_9", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET09.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.D_PRESET_10)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("d_state_10", NbtUtils.writeBlockState(state));
                        newRegenTag.put("d_pos_10", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.D_REGEN_PRESET10.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_01)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_1", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_1", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET01.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_02)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_2", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_2", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET02.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_03)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_3", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_3", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET03.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_04)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_4", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_4", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET04.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_05)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_5", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_5", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET05.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_06)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_6", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_6", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET06.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_07)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_7", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_7", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET07.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_08)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_8", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_8", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET08.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_09)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_9", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_9", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET09.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(RegenTags.Blocks.N_PRESET_10)) {

                        CompoundTag currentRegenTag = worldTags.getDataTag();
                        ListTag regenlistTag = worldTags.getRegenBlockList();

                        newRegenTag.put("n_state_10", NbtUtils.writeBlockState(state));
                        newRegenTag.put("n_pos_10", NbtUtils.writeBlockPos(pos));
                        regenlistTag.add(newRegenTag);

                        worldTags.setDataTag(currentRegenTag);
                        worldTags.setRegenBlockList(regenlistTag);

                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.N_REGEN_PRESET10.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }

                } else if (offHand.getTag().getInt("mode") == 1) {
                    if (RegenTickUtils.isCanRegen(levelAccessor.getBlockState(pos)) || RegenTickUtils.isDoneRegen(levelAccessor.getBlockState(pos))) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                    }
                    level.removeBlock(pos, false);
                }

            }

            //破壊時の耐久値減少の処理
            if (!mainHand.isEmpty() && mainHand.isDamageableItem() && state.is(RegenTags.Blocks.DONE_REGEN)) {
                if (mainHand.getItem() instanceof DiggerItem) {
                    mainHand.hurtAndBreak(1, event.getPlayer(), (player1) -> {
                        player.broadcastBreakEvent(event.getPlayer().getUsedItemHand());
                    });
                }
            }

            if (onBolckTags.getFlag(pos) == true){
                onBolckTags.removeFlag(pos);
            }
        }
    }
}