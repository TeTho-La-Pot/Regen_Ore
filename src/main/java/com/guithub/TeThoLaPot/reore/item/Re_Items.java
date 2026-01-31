package com.guithub.TeThoLaPot.reore.item;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Re_Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RE_Ore.MOD_ID);

    public static final RegistryObject<Item> BreakStuff = ITEMS.register("break_stuff",
            () -> new BreakStuff(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> Ancient_Fragment = ITEMS.register("ancient_fragment",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}