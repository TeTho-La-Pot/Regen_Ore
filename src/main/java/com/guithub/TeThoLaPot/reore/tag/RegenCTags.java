package com.guithub.TeThoLaPot.reore.tag;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;

public class RegenCTags{
    private static CompoundTag regenTag =null;

    public static void setRegenTag(CompoundTag tagHolder){
        regenTag = tagHolder;
    }

    public static CompoundTag getAndClearTag(){
        CompoundTag tagToReturn = regenTag;
        return tagToReturn;
    }
}
