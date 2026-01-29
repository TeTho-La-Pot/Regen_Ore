package com.guithub.TeThoLaPot.reore.tag;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;


public class OnblockWorldTags extends SavedData {
    private static final String DATA_NAME = "onblock_world_tag";

    public final Map<BlockPos, Boolean>blockFlags = new HashMap<>();

    public boolean getFlag(BlockPos pos){
        return blockFlags.getOrDefault(pos, false);
    }

    public void setFlag(BlockPos pos, boolean value){
        blockFlags.put(pos, value);
        this.setDirty();
    }

    public boolean hasFlag(BlockPos pos) {
        return this.blockFlags.containsKey(pos);
    }

    public static OnblockWorldTags load(CompoundTag nbt){
        OnblockWorldTags data = new OnblockWorldTags();
        ListTag list = nbt.getList("BlockFlags", Tag.TAG_COMPOUND);
        for (int i =0; i < list.size(); i++){
            CompoundTag entry = list.getCompound(i);
            BlockPos pos = BlockPos.of(entry.getLong("pos"));
            boolean value = entry.getBoolean("value");
            data.blockFlags.put(pos, value);
        }
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt){
        ListTag list = new ListTag();
        for (Map.Entry<BlockPos, Boolean> entry : blockFlags.entrySet()){
            CompoundTag tag = new CompoundTag();
            tag.putLong("pos", entry.getKey().asLong());
            tag.putBoolean("value", entry.getValue());
            list.add(tag);
        }
        nbt.put("BlockFlags", list);
        return nbt;
    }

    public void removeFlag(BlockPos pos){
        this.blockFlags.remove(pos);
        this.setDirty();
    }
}
