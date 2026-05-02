package com.github.TeThoLaPot.regen_resources.tag;

import com.github.TeThoLaPot.regen_resources.RegenResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;

public class RegenTags {
    public static class Blocks{
        public static final TagKey<Block> CAN_REGEN = tag("can_regen");
        public static final TagKey<Block> DONE_REGEN = tag("done_regen");

        //Presets
        public static final TagKey<Block> PRESET_01 = tag("preset01");
        public static final TagKey<Block> PRESET_02 = tag("preset02");
        public static final TagKey<Block> PRESET_03 = tag("preset03");
        public static final TagKey<Block> PRESET_04 = tag("preset04");
        public static final TagKey<Block> PRESET_05 = tag("preset05");
        public static final TagKey<Block> PRESET_06 = tag("preset06");
        public static final TagKey<Block> PRESET_07 = tag("preset07");
        public static final TagKey<Block> PRESET_08 = tag("preset08");
        public static final TagKey<Block> PRESET_09 = tag("preset09");
        public static final TagKey<Block> PRESET_10 = tag("preset10");
        public static final TagKey<Block> D_PRESET_01 = tag("d_preset01");
        public static final TagKey<Block> D_PRESET_02 = tag("d_preset02");
        public static final TagKey<Block> D_PRESET_03 = tag("d_preset03");
        public static final TagKey<Block> D_PRESET_04 = tag("d_preset04");
        public static final TagKey<Block> D_PRESET_05 = tag("d_preset05");
        public static final TagKey<Block> D_PRESET_06 = tag("d_preset06");
        public static final TagKey<Block> D_PRESET_07 = tag("d_preset07");
        public static final TagKey<Block> D_PRESET_08 = tag("d_preset08");
        public static final TagKey<Block> D_PRESET_09 = tag("d_preset09");
        public static final TagKey<Block> D_PRESET_10 = tag("d_preset10");
        public static final TagKey<Block> N_PRESET_01 = tag("n_preset01");
        public static final TagKey<Block> N_PRESET_02 = tag("n_preset02");
        public static final TagKey<Block> N_PRESET_03 = tag("n_preset03");
        public static final TagKey<Block> N_PRESET_04 = tag("n_preset04");
        public static final TagKey<Block> N_PRESET_05 = tag("n_preset05");
        public static final TagKey<Block> N_PRESET_06 = tag("n_preset06");
        public static final TagKey<Block> N_PRESET_07 = tag("n_preset07");
        public static final TagKey<Block> N_PRESET_08 = tag("n_preset08");
        public static final TagKey<Block> N_PRESET_09 = tag("n_preset09");
        public static final TagKey<Block> N_PRESET_10 = tag("n_preset10");
        public static final TagKey<Block> DEBRIS_PRESET = tag("debris_preset");
        public static final TagKey<Block> E_PRESET_01 = tag("e_preset01");
        public static final TagKey<Block> E_PRESET_02 = tag("e_preset02");
        public static final TagKey<Block> E_PRESET_03 = tag("e_preset03");
        public static final TagKey<Block> E_PRESET_04 = tag("e_preset04");
        public static final TagKey<Block> E_PRESET_05 = tag("e_preset05");
        public static final TagKey<Block> E_PRESET_06 = tag("e_preset06");
        public static final TagKey<Block> E_PRESET_07 = tag("e_preset07");
        public static final TagKey<Block> E_PRESET_08 = tag("e_preset08");
        public static final TagKey<Block> E_PRESET_09 = tag("e_preset09");
        public static final TagKey<Block> E_PRESET_10 = tag("e_preset10");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(RegenResources.MOD_ID, name));
        }


    }

    public static class Dimensions{

        public static final TagKey<Level> REGEN_DIMENSION = dimensionTag("regen_dimension");

        private static TagKey<Level> dimensionTag(String name){
            return TagKey.create(Registries.DIMENSION, new ResourceLocation(RegenResources.MOD_ID, name));
        }
    }
}
