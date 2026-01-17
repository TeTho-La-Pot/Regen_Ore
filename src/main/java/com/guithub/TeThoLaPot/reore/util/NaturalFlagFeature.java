package com.guithub.TeThoLaPot.reore.util;

import com.guithub.TeThoLaPot.reore.tag.OnblockWorldTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class NaturalFlagFeature extends Feature<OreConfiguration> {
    public NaturalFlagFeature(Codec<OreConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> featurePlaceContext) {
        WorldGenLevel level = featurePlaceContext.level();
        BlockPos origin = featurePlaceContext.origin();
        RandomSource random = featurePlaceContext.random();
        OreConfiguration config = featurePlaceContext.config();

        boolean placedAny = false;

        for (OreConfiguration.TargetBlockState target : config.targetStates) {
            BlockState currentState = level.getBlockState(origin);

            if (target.target.test(currentState, random)) {

                if (level instanceof ServerLevel serverLevel) {
                    OnblockWorldTags onBlockTags = serverLevel.getDataStorage().computeIfAbsent(
                            OnblockWorldTags::load, OnblockWorldTags::new, "onblock_world_tag"
                    );
                    onBlockTags.setFlag(origin, false);
                }

                level.setBlock(origin, currentState, 3);
                placedAny = true;
            }
        }
        return placedAny;
    }
}
