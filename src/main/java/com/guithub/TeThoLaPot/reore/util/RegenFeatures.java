package com.guithub.TeThoLaPot.reore.util;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegenFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, RE_Ore.MOD_ID);

    public static final RegistryObject<Feature<OreConfiguration>> NATURAL_REGEN_FEATURE =
            FEATURES.register("natural_regen_feature",
                    () -> new NaturalFlagFeature(OreConfiguration.CODEC));

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
