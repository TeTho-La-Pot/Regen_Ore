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

//                        pOutput.accept(ModBlocks.REGEN_IRON_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_IRON_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_IRON_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_COPPER_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_COPPER_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_COPPER_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_GOLD_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_GOLD_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_GOLD_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_NETHER_GOLD_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_NETHER_GOLD_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_DIAMOND_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DIAMOND_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_DIAMOND_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_EMERALD_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_EMERALD_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_EMERALD_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_COAL_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_COAL_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_COAL_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_LAPIS_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_LAPIS_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_LAPIS_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_REDSTONE_ORE.get());
//                        pOutput.accept(ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_DEEPSLATE_REDSTONE_ORE.get());

//                        pOutput.accept(ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get());
                        pOutput.accept(ModBlocks.REGENED_NETHER_QUARTZ_ORE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
