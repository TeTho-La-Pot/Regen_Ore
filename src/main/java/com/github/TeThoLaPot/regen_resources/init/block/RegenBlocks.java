package com.github.TeThoLaPot.regen_resources.init.block;

import com.github.TeThoLaPot.regen_resources.init.entity.BlockEntities;
import com.github.TeThoLaPot.regen_resources.util.TickaleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RegenBlocks extends DropExperienceBlock implements EntityBlock {
    public RegenBlocks(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state){
        return BlockEntities.REGEN_ORE_ENTITY.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity>BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type){
        return TickaleBlockEntity.getTickerHelper(level);
    }

}
