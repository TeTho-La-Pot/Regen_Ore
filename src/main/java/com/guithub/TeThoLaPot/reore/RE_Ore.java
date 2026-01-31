package com.guithub.TeThoLaPot.reore;

import com.guithub.TeThoLaPot.reore.config.RegenOreCommonConfig;
import com.guithub.TeThoLaPot.reore.init.block.Re_Blocks;
import com.guithub.TeThoLaPot.reore.init.entity.BlockEntities;
import com.guithub.TeThoLaPot.reore.item.BreakStuff;
import com.guithub.TeThoLaPot.reore.item.CreativeModTabs;
import com.guithub.TeThoLaPot.reore.item.Re_Items;
import com.guithub.TeThoLaPot.reore.packet.RegenNetworkHandler;
import com.guithub.TeThoLaPot.reore.recipe.ReLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RE_Ore.MOD_ID)
public class RE_Ore {
    public static final String MOD_ID = "re_ore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RE_Ore(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        CreativeModTabs.register(modEventBus);

        Re_Items.register(modEventBus);

        Re_Blocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        BlockEntities.BLOCK_ENTITIES.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RegenOreCommonConfig.SPEC, "RegenOre.toml");

        ReLootModifiers.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(RegenNetworkHandler::register);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
        }
    }

    private void onClientSetup(final FMLClientSetupEvent event){
        event.enqueueWork(() -> {
            ItemProperties.register(Re_Items.BreakStuff.get(),
                    new ResourceLocation("re_ore", "mode"),
                    (stack, level, entity, seed) -> {
                if (stack.getItem() instanceof BreakStuff item) {
                    return (float) item.modeNum(stack);
                }
                return 0.0f;
                    });
        });
    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

}
