package com.guithub.TeThoLaPot.reore.tag;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.saveddata.SavedData;


public class RegenWorldTags extends SavedData {
    private static final String DATA_NAME = "regen_world_tag";

    private CompoundTag dataTag = new CompoundTag();
    private ListTag regenBlockList = new ListTag();

    public RegenWorldTags(){
        super();
    }

    public static RegenWorldTags load(CompoundTag nbt){
        RegenWorldTags data = new RegenWorldTags();

        if (nbt.contains("dataTag")){
            data.dataTag = nbt.getCompound("dataTag");
        }

        if (data.dataTag.contains("regen_block_list")){
            data.regenBlockList = data.dataTag.getList("regen_block_list", CompoundTag.TAG_COMPOUND);
        }

        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt){
        this.dataTag.put("regen_block_list", this.regenBlockList);
        nbt.put("dataTag", dataTag);
        return nbt;
    }

    public CompoundTag getDataTag(){
        return this.dataTag;
    }

    public void setDataTag(CompoundTag dataTag){
        this.dataTag = dataTag;
        this.setDirty();
    }

    public ListTag getRegenBlockList() {
        return this.regenBlockList;
    }

    public void setRegenBlockList(ListTag regenBlockList){
        this.regenBlockList = regenBlockList;
        this.setDirty();
    }
}
