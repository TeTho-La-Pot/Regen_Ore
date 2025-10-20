package com.guithub.TeThoLaPot.reore.item;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RE_Ore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REORE_TAB = CREATIVE_MOD_TABS.register("reore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.TORE.get()))
                    .title(Component.translatable("creativetab.reore_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.TORE.get());

                        pOutput.accept(ModBlocks.TEST_ORE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
