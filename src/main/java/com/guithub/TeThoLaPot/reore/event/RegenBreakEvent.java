package com.guithub.TeThoLaPot.reore.event;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.init.entity.RegenOreEntity;
import com.guithub.TeThoLaPot.reore.tag.RegenCTags;
import com.guithub.TeThoLaPot.reore.util.RegenCooldownUtils;
import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID)
public class RegenBreakEvent extends ModBlocks{

//    public static List<BlockPos> getPositionList(CompoundTag tag) {
//        List<BlockPos> list = new ArrayList<>();
//        if(tag !=null) {
//            if(!tag.contains("positionList")){
//                tag.put("positionList,", new CompoundTag());
//            }
//            CompoundTag posTag = tag.getCompound("positionList");
//            list.add(NbtUtils.readBlockPos(posTag.getCompound("location")));
//        }
//    return list;
//    }

    @SubscribeEvent
    public static void blockBreak(BlockEvent.BreakEvent event) {



        CompoundTag regenPosTag = new CompoundTag();
        CompoundTag regenStateTag = new CompoundTag();



        LevelAccessor levelAccessor = event.getLevel();
        ServerLevel level = (ServerLevel) levelAccessor;
        Player player = event.getPlayer();
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);



        if (player.isCreative()) {
            if (RegenTickUtils.isCanRegen(levelAccessor.getBlockState(pos)) || RegenTickUtils.isDoneRegen(levelAccessor.getBlockState(pos))) {
                level.removeBlock(pos, false);
            }
            if (RegenCooldownUtils.vanillaRegen == true && RegenTickUtils.vRegen(levelAccessor.getBlockState(pos))){
                level.removeBlock(pos, false);
            }
        }

        if (!player.isCreative()) {
            if (offHand.isEmpty() || offHand.getTag().getInt("mode") == 0 || offHand.getTag() == null) {
                if (state.is(ModBlocks.REGENED_COAL_ORE.get()) || state.is(ModBlocks.REGEN_COAL_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_COAL_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_COAL_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_IRON_ORE.get()) || state.is(ModBlocks.REGEN_IRON_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_IRON_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_IRON_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_COPPER_ORE.get()) || state.is(ModBlocks.REGEN_COPPER_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_COPPER_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_COPPER_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_GOLD_ORE.get()) || state.is(ModBlocks.REGEN_GOLD_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_GOLD_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_NETHER_GOLD_ORE.get()) || state.is(ModBlocks.REGEN_NETHER_GOLD_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_NETHER_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DIAMOND_ORE.get()) || state.is(ModBlocks.REGEN_DIAMOND_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DIAMOND_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_DIAMOND_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_EMERALD_ORE.get()) || state.is(ModBlocks.REGEN_EMERALD_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_EMERALD_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_EMERALD_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_REDSTONE_ORE.get()) || state.is(ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_REDSTONE_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_LAPIS_ORE.get()) || state.is(ModBlocks.REGEN_LAPIS_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_LAPIS_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_DEEPSLATE_LAPIS_ORE.get()) || state.is(ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }
                if (state.is(ModBlocks.REGENED_NETHER_QUARTZ_ORE.get()) || state.is(ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get())) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }

                if (RegenCooldownUtils.vanillaRegen == true) {
                    //Vanilla Ores
                    if (state.is(Blocks.COAL_ORE) || state.is(ModBlocks.V_REGEN_COAL_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_COAL_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_COAL_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_COAL_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_COAL_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.IRON_ORE) || state.is(ModBlocks.V_REGEN_IRON_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_IRON_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_IRON_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_IRON_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.COPPER_ORE) || state.is(ModBlocks.V_REGEN_COPPER_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_COPPER_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_COPPER_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.GOLD_ORE) || state.is(ModBlocks.V_REGEN_GOLD_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_GOLD_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.NETHER_GOLD_ORE) || state.is(ModBlocks.V_REGEN_NETHER_GOLD_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_NETHER_GOLD_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DIAMOND_ORE) || state.is(ModBlocks.V_REGEN_DIAMOND_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DIAMOND_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_DIAMOND_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.EMERALD_ORE) || state.is(ModBlocks.V_REGEN_EMERALD_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_EMERALD_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_EMERALD_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.REDSTONE_ORE) || state.is(ModBlocks.V_REGEN_REDSTONE_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_REDSTONE_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_REDSTONE_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.LAPIS_ORE) || state.is(ModBlocks.V_REGEN_LAPIS_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_LAPIS_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.DEEPSLATE_LAPIS_ORE) || state.is(ModBlocks.V_REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }
                    if (state.is(Blocks.NETHER_QUARTZ_ORE) || state.is(ModBlocks.V_REGEN_NETHER_QUARTZ_ORE_ENTITY.get())) {
                        if (mainHand.isCorrectToolForDrops(state)) {
                            state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                            state.getBlock().popExperience(level, pos, event.getExpToDrop());
                        }
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.V_REGEN_NETHER_QUARTZ_ORE_ENTITY.get().defaultBlockState(), 3);
                        event.setCanceled(true);
                    }

                    //破壊時のNBT登録お試しコード
                    if (state.is(Blocks.STONE)) {

//                        List<BlockPos> regenPosList = new ArrayList<>();
//                        regenPosList.add(pos);
//                        List<BlockState> regenStateList = new ArrayList<>();
//                        regenStateList.add(state);

                        regenStateTag.put("state_r", NbtUtils.writeBlockState(state));
                        regenPosTag.put("pos_r", NbtUtils.writeBlockPos(pos));

                        RegenCTags.setRegenTag(regenStateTag);
                        RegenCTags.setRegenTag(regenPosTag);



                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                    level.setBlock(pos, ModBlocks.TEST_ORE.get().defaultBlockState(), 3);
                    event.setCanceled(true);
                }


                    //Create Ores
//                    if (ModList.get().isLoaded("create")) {
//                        if (state.is(AllBlocks.ZINC_ORE.get()) || state.is(ModBlocks.CREATE_ZINC_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.CREATE_ZINC_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(AllBlocks.DEEPSLATE_ZINC_ORE.get()) || state.is(ModBlocks.CREATE_DEEPSLATE_ZINC_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.CREATE_DEEPSLATE_ZINC_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                    }
//
//                    //Mekanism Ores
//                    if (ModList.get().isLoaded("mekanism")) {
//                        if (state.is(MekanismBlocks.ORES.get(OreType.TIN).stoneBlock()) || state.is(ModBlocks.MEKANISM_TIN_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_TIN_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.TIN).deepslateBlock()) || state.is(ModBlocks.MEKANISM_DEEPSLATE_TIN_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_DEEPSLATE_TIN_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.OSMIUM).stoneBlock()) || state.is(ModBlocks.MEKANISM_OSUMIUM_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_OSUMIUM_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.OSMIUM).deepslateBlock()) || state.is(ModBlocks.MEKANISM_DEEPSLATE_OSUMIUM_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_DEEPSLATE_OSUMIUM_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.URANIUM).stoneBlock()) || state.is(ModBlocks.MEKANISM_URANIUM_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_URANIUM_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.URANIUM).deepslateBlock()) || state.is(ModBlocks.MEKANISM_DEEPSLATE_URANIUM_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_DEEPSLATE_URANIUM_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.FLUORITE).stoneBlock()) || state.is(ModBlocks.MEKANISM_FLUORITE_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_FLUORITE_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.FLUORITE).deepslateBlock()) || state.is(ModBlocks.MEKANISM_DEEPSLATE_FLUORITE_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_DEEPSLATE_FLUORITE_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.LEAD).stoneBlock()) || state.is(ModBlocks.MEKANISM_LEAD_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_LEAD_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                        if (state.is(MekanismBlocks.ORES.get(OreType.LEAD).deepslateBlock()) || state.is(ModBlocks.MEKANISM_DEEPSLATE_LEAD_ORE_ENTITY.get())) {
//                            if (mainHand.isCorrectToolForDrops(state)) {
//                                state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
//                                state.getBlock().popExperience(level, pos, event.getExpToDrop());
//                            }
//                            level.removeBlock(pos, false);
//                            level.setBlock(pos, ModBlocks.MEKANISM_DEEPSLATE_LEAD_ORE_ENTITY.get().defaultBlockState(), 3);
//                            event.setCanceled(true);
//                        }
//                    }
                }
            } else if (offHand.getTag().getInt("mode") == 1){
                if (RegenTickUtils.isCanRegen(levelAccessor.getBlockState(pos)) || RegenTickUtils.isDoneRegen(levelAccessor.getBlockState(pos))) {
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                }
                if (RegenCooldownUtils.vanillaRegen == true && RegenTickUtils.vRegen(levelAccessor.getBlockState(pos))){
                    if (mainHand.isCorrectToolForDrops(state)) {
                        state.getBlock().playerDestroy(player.level(), player, pos, state, null, mainHand);
                        state.getBlock().popExperience(level, pos, event.getExpToDrop());
                    }
                    level.removeBlock(pos, false);
                }
            }
        }
    }
}