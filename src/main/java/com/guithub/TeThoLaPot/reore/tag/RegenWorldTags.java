package com.guithub.TeThoLaPot.reore.tag;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;


public class RegenWorldTags extends SavedData {
    private static final String DATA_NAME = "regen_world_tag";
    private CompoundTag dataTag = new CompoundTag();

    public RegenWorldTags(){
        super();
    }

    public static RegenWorldTags load(CompoundTag nbt){
        RegenWorldTags data = new RegenWorldTags();
        data.dataTag = nbt.getCompound("dataTag");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt){
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
}
