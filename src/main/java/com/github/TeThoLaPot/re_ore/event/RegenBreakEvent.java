package com.github.TeThoLaPot.re_ore.event;

import com.github.TeThoLaPot.re_ore.RE_Ore;
import com.github.TeThoLaPot.re_ore.config.RegenOreCommonConfig;
import com.github.TeThoLaPot.re_ore.init.block.Re_Blocks;
import com.github.TeThoLaPot.re_ore.tag.OnblockWorldTags;
import com.github.TeThoLaPot.re_ore.tag.RegenTags;
import com.github.TeThoLaPot.re_ore.tag.RegenWorldTags;
import com.github.TeThoLaPot.re_ore.util.RegenTickUtils;
import com.github.TeThoLaPot.re_ore.util.RegenWorkUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

import static com.github.TeThoLaPot.re_ore.item.Re_Items.BreakStuff;

@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
public class RegenBreakEvent {

    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        if (levelAccessor.isClientSide() || !(levelAccessor instanceof ServerLevel level)) return;

        Player player = event.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        Holder<Level> dimensionHolder = level.registryAccess().registryOrThrow(Registries.DIMENSION)
                .getHolder(level.dimension()).orElse(null);

        if (dimensionHolder == null || !dimensionHolder.is(RegenTags.Dimensions.REGEN_DIMENSION)) return;

        if (state.is(RegenTags.Blocks.CAN_REGEN) || state.is(RegenTags.Blocks.DONE_REGEN)) {
            RegenWorldTags worldTags = level.getDataStorage().computeIfAbsent(RegenWorldTags::load, RegenWorldTags::new, "regen_world_tag");
            OnblockWorldTags onBlockTags = level.getDataStorage().computeIfAbsent(OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag");

            if (player.isCreative()) {
                if (RegenTickUtils.isCanRegen(state) || RegenTickUtils.isDoneRegen(state)) return;
            } else if (!onBlockTags.getFlag(pos)) {
                if (!RegenWorkUtils.can_natural_regen && !onBlockTags.hasFlag(pos)) return;

                if (!offHand.is(BreakStuff.get()) || offHand.getOrCreateTag().getInt("mode") == 0) {
                    if (state.is(RegenTags.Blocks.CAN_REGEN)) event.setCanceled(true);

                    // ----------PRESETS----------
                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_01, RegenOreCommonConfig.MAX_HEIGHT_01, RegenOreCommonConfig.MIN_HEIGHT_01, "", "_1", Re_Blocks.REGEN_PRESET01);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_02, RegenOreCommonConfig.MAX_HEIGHT_02, RegenOreCommonConfig.MIN_HEIGHT_02, "", "_2", Re_Blocks.REGEN_PRESET02);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_03, RegenOreCommonConfig.MAX_HEIGHT_03, RegenOreCommonConfig.MIN_HEIGHT_03, "", "_3", Re_Blocks.REGEN_PRESET03);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_04, RegenOreCommonConfig.MAX_HEIGHT_04, RegenOreCommonConfig.MIN_HEIGHT_04, "", "_4", Re_Blocks.REGEN_PRESET04);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_05, RegenOreCommonConfig.MAX_HEIGHT_05, RegenOreCommonConfig.MIN_HEIGHT_05, "", "_5", Re_Blocks.REGEN_PRESET05);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_06, RegenOreCommonConfig.MAX_HEIGHT_06, RegenOreCommonConfig.MIN_HEIGHT_06, "", "_6", Re_Blocks.REGEN_PRESET06);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_07, RegenOreCommonConfig.MAX_HEIGHT_07, RegenOreCommonConfig.MIN_HEIGHT_07, "", "_7", Re_Blocks.REGEN_PRESET07);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_08, RegenOreCommonConfig.MAX_HEIGHT_08, RegenOreCommonConfig.MIN_HEIGHT_08, "", "_8", Re_Blocks.REGEN_PRESET08);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_09, RegenOreCommonConfig.MAX_HEIGHT_09, RegenOreCommonConfig.MIN_HEIGHT_09, "", "_9", Re_Blocks.REGEN_PRESET09);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.PRESET_10, RegenOreCommonConfig.MAX_HEIGHT_10, RegenOreCommonConfig.MIN_HEIGHT_10, "", "_10", Re_Blocks.REGEN_PRESET10);

                    //----------D_PRESETS----------
                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_01, RegenOreCommonConfig.D_MAX_HEIGHT_01, RegenOreCommonConfig.D_MIN_HEIGHT_01, "d_", "_1", Re_Blocks.D_REGEN_PRESET01);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_02, RegenOreCommonConfig.D_MAX_HEIGHT_02, RegenOreCommonConfig.D_MIN_HEIGHT_02, "d_", "_2", Re_Blocks.D_REGEN_PRESET02);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_03, RegenOreCommonConfig.D_MAX_HEIGHT_03, RegenOreCommonConfig.D_MIN_HEIGHT_03, "d_", "_3", Re_Blocks.D_REGEN_PRESET03);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_04, RegenOreCommonConfig.D_MAX_HEIGHT_04, RegenOreCommonConfig.D_MIN_HEIGHT_04, "d_", "_4", Re_Blocks.D_REGEN_PRESET04);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_05, RegenOreCommonConfig.D_MAX_HEIGHT_05, RegenOreCommonConfig.D_MIN_HEIGHT_05, "d_", "_5", Re_Blocks.D_REGEN_PRESET05);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_06, RegenOreCommonConfig.D_MAX_HEIGHT_06, RegenOreCommonConfig.D_MIN_HEIGHT_06, "d_", "_6", Re_Blocks.D_REGEN_PRESET06);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_07, RegenOreCommonConfig.D_MAX_HEIGHT_07, RegenOreCommonConfig.D_MIN_HEIGHT_07, "d_", "_7", Re_Blocks.D_REGEN_PRESET07);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_08, RegenOreCommonConfig.D_MAX_HEIGHT_08, RegenOreCommonConfig.D_MIN_HEIGHT_08, "d_", "_8", Re_Blocks.D_REGEN_PRESET08);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_09, RegenOreCommonConfig.D_MAX_HEIGHT_09, RegenOreCommonConfig.D_MIN_HEIGHT_09, "d_", "_9", Re_Blocks.D_REGEN_PRESET09);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.D_PRESET_10, RegenOreCommonConfig.D_MAX_HEIGHT_10, RegenOreCommonConfig.D_MIN_HEIGHT_10, "d_", "_10", Re_Blocks.D_REGEN_PRESET10);

                    //----------N_PRESETS----------
                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_01, RegenOreCommonConfig.N_MAX_HEIGHT_01, RegenOreCommonConfig.N_MIN_HEIGHT_01, "n_", "_1", Re_Blocks.N_REGEN_PRESET01);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_02, RegenOreCommonConfig.N_MAX_HEIGHT_02, RegenOreCommonConfig.N_MIN_HEIGHT_02, "n_", "_2", Re_Blocks.N_REGEN_PRESET02);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_03, RegenOreCommonConfig.N_MAX_HEIGHT_03, RegenOreCommonConfig.N_MIN_HEIGHT_03, "n_", "_3", Re_Blocks.N_REGEN_PRESET03);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_04, RegenOreCommonConfig.N_MAX_HEIGHT_04, RegenOreCommonConfig.N_MIN_HEIGHT_04, "n_", "_4", Re_Blocks.N_REGEN_PRESET04);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_05, RegenOreCommonConfig.N_MAX_HEIGHT_05, RegenOreCommonConfig.N_MIN_HEIGHT_05, "n_", "_5", Re_Blocks.N_REGEN_PRESET05);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_06, RegenOreCommonConfig.N_MAX_HEIGHT_06, RegenOreCommonConfig.N_MIN_HEIGHT_06, "n_", "_6", Re_Blocks.N_REGEN_PRESET06);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_07, RegenOreCommonConfig.N_MAX_HEIGHT_07, RegenOreCommonConfig.N_MIN_HEIGHT_07, "n_", "_7", Re_Blocks.N_REGEN_PRESET07);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_08, RegenOreCommonConfig.N_MAX_HEIGHT_08, RegenOreCommonConfig.N_MIN_HEIGHT_08, "n_", "_8", Re_Blocks.N_REGEN_PRESET08);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_09, RegenOreCommonConfig.N_MAX_HEIGHT_09, RegenOreCommonConfig.N_MIN_HEIGHT_09, "n_", "_9", Re_Blocks.N_REGEN_PRESET09);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.N_PRESET_10, RegenOreCommonConfig.N_MAX_HEIGHT_10, RegenOreCommonConfig.N_MIN_HEIGHT_10, "n_", "_10", Re_Blocks.N_REGEN_PRESET10);

                    //----------OTHERS_PRESETS----------
                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.DEBRIS_PRESET, RegenOreCommonConfig.DEBRIS_MAX_HEIGHT, RegenOreCommonConfig.DEBRIS_MIN_HEIGHT, "debris_", "", Re_Blocks.DEBRIS_REGEN_PRESET);

                    //----------E_PRESETS----------
                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_01, RegenOreCommonConfig.E_MAX_HEIGHT_01, RegenOreCommonConfig.E_MIN_HEIGHT_01, "e_", "_1", Re_Blocks.E_REGEN_PRESET01);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_02, RegenOreCommonConfig.E_MAX_HEIGHT_02, RegenOreCommonConfig.E_MIN_HEIGHT_02, "e_", "_2", Re_Blocks.E_REGEN_PRESET02);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_03, RegenOreCommonConfig.E_MAX_HEIGHT_03, RegenOreCommonConfig.E_MIN_HEIGHT_03, "e_", "_3", Re_Blocks.E_REGEN_PRESET03);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_04, RegenOreCommonConfig.E_MAX_HEIGHT_04, RegenOreCommonConfig.E_MIN_HEIGHT_04, "e_", "_4", Re_Blocks.E_REGEN_PRESET04);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_05, RegenOreCommonConfig.E_MAX_HEIGHT_05, RegenOreCommonConfig.E_MIN_HEIGHT_05, "e_", "_5", Re_Blocks.E_REGEN_PRESET05);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_06, RegenOreCommonConfig.E_MAX_HEIGHT_06, RegenOreCommonConfig.E_MIN_HEIGHT_06, "e_", "_6", Re_Blocks.E_REGEN_PRESET06);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_07, RegenOreCommonConfig.E_MAX_HEIGHT_07, RegenOreCommonConfig.E_MIN_HEIGHT_07, "e_", "_7", Re_Blocks.E_REGEN_PRESET07);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_08, RegenOreCommonConfig.E_MAX_HEIGHT_08, RegenOreCommonConfig.E_MIN_HEIGHT_08, "e_", "_8", Re_Blocks.E_REGEN_PRESET08);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_09, RegenOreCommonConfig.E_MAX_HEIGHT_09, RegenOreCommonConfig.E_MIN_HEIGHT_09, "e_", "_9", Re_Blocks.E_REGEN_PRESET09);

                    processRegen(event, level, player, state, pos, mainHand, worldTags,
                            RegenTags.Blocks.E_PRESET_10, RegenOreCommonConfig.E_MAX_HEIGHT_10, RegenOreCommonConfig.E_MIN_HEIGHT_10, "e_", "_10", Re_Blocks.E_REGEN_PRESET10);
                }
            }
        }
    }

    private static void processRegen(BlockEvent.BreakEvent event, ServerLevel level, Player player, BlockState state, BlockPos pos,
                                     ItemStack mainHand, RegenWorldTags worldTags, TagKey<Block> tag,
                                     ForgeConfigSpec.ConfigValue<Integer> maxHeight, ForgeConfigSpec.ConfigValue<Integer> minHeight,
                                     String type, String number,
                                     Supplier<Block> regenBlock) {

        if (!state.is(tag)) return;

        int Y = pos.getY();
        if (Y <= maxHeight.get() && Y >= minHeight.get()) {
            CompoundTag newRegenTag = new CompoundTag();
            ListTag regenlistTag = worldTags.getRegenBlockList();
            newRegenTag.put(type + "state" + number, NbtUtils.writeBlockState(state));
            newRegenTag.put(type + "pos" + number, NbtUtils.writeBlockPos(pos));
            regenlistTag.add(newRegenTag);
            worldTags.setRegenBlockList(regenlistTag);

            if (mainHand.isCorrectToolForDrops(state)) {
                LootParams.Builder paramsBuilder = new LootParams.Builder(level)
                        .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .withParameter(LootContextParams.BLOCK_STATE, state)
                        .withOptionalParameter(LootContextParams.BLOCK_ENTITY, level.getBlockEntity(pos))
                        .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                        .withParameter(LootContextParams.TOOL, mainHand);

                List<ItemStack> drops = state.getDrops(paramsBuilder);
                for (ItemStack stack : drops) {
                    ItemEntity itemEntity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack);
                    itemEntity.setNoPickUpDelay();
                    level.addFreshEntity(itemEntity);
                }
                state.getBlock().popExperience(level, player.getOnPos(), event.getExpToDrop());
            }

            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            event.setExpToDrop(0);
            level.getServer().execute(() ->{
                level.setBlock(pos, regenBlock.get().defaultBlockState(), 3);
            });
        }
    }
}