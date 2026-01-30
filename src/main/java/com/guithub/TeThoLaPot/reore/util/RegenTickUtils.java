package com.guithub.TeThoLaPot.reore.util;

import com.guithub.TeThoLaPot.reore.tag.RegenTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.Range.is;

public class RegenTickUtils {

    public static boolean isCanRegen(BlockState state){
        return state.is(RegenTags.Blocks.CAN_REGEN);
    }

    public static boolean isDoneRegen(BlockState state){
        return state.is(RegenTags.Blocks.DONE_REGEN);
    }

    public static boolean onBlockSync(BlockPos pos){
        return RegenTickUtils.getFlag(pos);
    }

    private static final Map<BlockPos, Boolean> REGEN_FLAGS = new HashMap<>();

    public static void updateFlag(BlockPos pos, boolean flag){
        REGEN_FLAGS.put(pos,flag);
    }

    public static boolean getFlag(BlockPos pos) {
        if (RegenWorkUtils.can_natural_regen == true) {
            return REGEN_FLAGS.getOrDefault(pos, false);
        } else {
            return REGEN_FLAGS.getOrDefault(pos, true);
        }
    }

    public static void clear(BlockPos pos){
        REGEN_FLAGS.clear();
    }

//    public static boolean preset01(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_01);
//    }
//    public static boolean preset02(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_02);
//    }
//    public static boolean preset03(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_03);
//    }
//    public static boolean preset04(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_04);
//    }
//    public static boolean preset05(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_05);
//    }
//    public static boolean preset06(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_06);
//    }
//    public static boolean preset07(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_07);
//    }
//    public static boolean preset08(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_08);
//    }
//    public static boolean preset09(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_09);
//    }
//    public static boolean preset10(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_10);
//    }
//
//    public static boolean d_preset01(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_01);
//    }
//    public static boolean d_preset02(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_02);
//    }
//    public static boolean d_preset03(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_03);
//    }
//    public static boolean d_preset04(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_04);
//    }
//    public static boolean d_preset05(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_05);
//    }
//    public static boolean d_preset06(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_06);
//    }
//    public static boolean d_preset07(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_07);
//    }
//    public static boolean d_preset08(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_08);
//    }
//    public static boolean d_preset09(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_09);
//    }
//    public static boolean d_preset10(BlockState state){
//        return state.is(RegenTags.Blocks.D_PRESET_10);
//    }
//
//    public static boolean n_preset01(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_01);
//    }
//    public static boolean n_preset02(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_02);
//    }
//    public static boolean n_preset03(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_03);
//    }
//    public static boolean n_preset04(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_04);
//    }
//    public static boolean n_preset05(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_05);
//    }
//    public static boolean n_preset06(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_06);
//    }
//    public static boolean n_preset07(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_07);
//    }
//    public static boolean n_preset08(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_08);
//    }
//    public static boolean n_preset09(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_09);
//    }
//    public static boolean n_preset10(BlockState state){
//        return state.is(RegenTags.Blocks.PRESET_10);
//    }
}
