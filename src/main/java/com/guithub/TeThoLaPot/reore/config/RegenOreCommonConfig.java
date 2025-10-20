package com.guithub.TeThoLaPot.reore.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RegenOreCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_01;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_02;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_03;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_04;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_05;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_06;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_07;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_08;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_09;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGEN_PRESET_10;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_01;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_02;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_03;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_04;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_05;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_06;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_07;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_08;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_09;
    public static final ForgeConfigSpec.ConfigValue<Integer> D_REGEN_PRESET_10;

    static {
        BUILDER.push("Configs for RegenOre Mod");

        REGEN_PRESET_01 = BUILDER.comment("Cooldown of block regen registered in preset 01")
                .define("Preset 01", 100);
        REGEN_PRESET_02 = BUILDER.comment("Cooldown of block regen registered in preset 02")
                .define("Preset 02", 200);
        REGEN_PRESET_03 = BUILDER.comment("Cooldown of block regen registered in preset 03")
                .define("Preset 03", 300);
        REGEN_PRESET_04 = BUILDER.comment("Cooldown of block regen registered in preset 04")
                .define("Preset 04", 400);
        REGEN_PRESET_05 = BUILDER.comment("Cooldown of block regen registered in preset 05")
                .define("Preset 05", 500);
        REGEN_PRESET_06 = BUILDER.comment("Cooldown of block regen registered in preset 06")
                .define("Preset 06", 600);
        REGEN_PRESET_07 = BUILDER.comment("Cooldown of block regen registered in preset 07")
                .define("Preset 07", 700);
        REGEN_PRESET_08 = BUILDER.comment("Cooldown of block regen registered in preset 08")
                .define("Preset 08", 800);
        REGEN_PRESET_09 = BUILDER.comment("Cooldown of block regen registered in preset 09")
                .define("Preset 09", 900);
        REGEN_PRESET_10 = BUILDER.comment("Cooldown of block regen registered in preset 10")
                .define("Preset 10", 1000);

        D_REGEN_PRESET_01 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 01")
                .define("Preset 01", 100);
        D_REGEN_PRESET_02 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 02")
                .define("Preset 02", 200);
        D_REGEN_PRESET_03 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 03")
                .define("Preset 03", 300);
        D_REGEN_PRESET_04 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 04")
                .define("Preset 04", 400);
        D_REGEN_PRESET_05 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 05")
                .define("Preset 05", 500);
        D_REGEN_PRESET_06 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 06")
                .define("Preset 06", 600);
        D_REGEN_PRESET_07 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 07")
                .define("Preset 07", 700);
        D_REGEN_PRESET_08 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 08")
                .define("Preset 08", 800);
        D_REGEN_PRESET_09 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 09")
                .define("Preset 09", 900);
        D_REGEN_PRESET_10 = BUILDER.comment("Cooldown of block regen registered in deepslate preset 10")
                .define("Preset 10", 1000);





        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
