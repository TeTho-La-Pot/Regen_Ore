package com.guithub.TeThoLaPot.reore.item;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.Re_Blocks;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Re_Items.BreakStuff.get()))
                    .title(Component.translatable("creativetab.reore_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //Item
                        pOutput.accept(Re_Items.BreakStuff.get());
                        pOutput.accept(Re_Items.Ancient_Fragment.get());

                        //Block
                        pOutput.accept(Re_Blocks.TEST_ORE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
