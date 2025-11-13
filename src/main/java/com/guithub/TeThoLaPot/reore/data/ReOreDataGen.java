package com.guithub.TeThoLaPot.reore.data;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.data.lang.ENUSLangProvider;
import com.guithub.TeThoLaPot.reore.data.loot.ReOreLootTables;
import com.guithub.TeThoLaPot.reore.data.model.ReOreBlockStateProvider;
import com.guithub.TeThoLaPot.reore.data.model.ReOreItemModelProvider;
import com.guithub.TeThoLaPot.reore.data.tag.ReOreBlockTagsProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = RE_Ore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ReOreDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

//        generator.addProvider(event.includeClient(), new ReOreItemModelProvider(packOutput, existingFileHelper));
//        generator.addProvider(event.includeClient(), new ReOreBlockStateProvider(packOutput, existingFileHelper));
//        generator.addProvider(event.includeClient(), new ENUSLangProvider(packOutput));
//        generator.addProvider(event.includeClient(), ReOreLootTables.create(packOutput));
//        generator.addProvider(event.includeServer(), new ReOreBlockTagsProvider(packOutput, lookUpProvider, existingFileHelper));
    }
}
