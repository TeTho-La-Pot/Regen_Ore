package com.guithub.TeThoLaPot.reore.init.block.OtherMod;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.RegenOreBlocks;
import com.guithub.TeThoLaPot.reore.item.Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CreateBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RE_Ore.MOD_ID);


    //Create
    public static final RegistryObject<Block> CREATE_ZINC_ORE_ENTITY = registerBlock("create_regen_zinc_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> CREATE_DEEPSLATE_ZINC_ORE_ENTITY = registerBlock("create_regen_deepslate_zinc_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));


    //Mekanism
    public static final RegistryObject<Block> MEKANISM_TIN_ORE_ENTITY = registerBlock("mekanism_regen_tin_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_DEEPSLATE_TIN_ORE_ENTITY = registerBlock("mekanism_regen_deepslate_tin_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_OSUMIUM_ORE_ENTITY = registerBlock("mekanism_regen_osumium_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_DEEPSLATE_OSUMIUM_ORE_ENTITY = registerBlock("mekanism_regen_deepslate_osumium_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_URANIUM_ORE_ENTITY = registerBlock("mekanism_regen_uranium_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_DEEPSLATE_URANIUM_ORE_ENTITY = registerBlock("mekanism_regen_deepslate_uranium_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_FLUORITE_ORE_ENTITY = registerBlock("mekanism_regen_fluorite_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_DEEPSLATE_FLUORITE_ORE_ENTITY = registerBlock("mekanism_regen_deepslate_fluorite_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_LEAD_ORE_ENTITY = registerBlock("mekanism_regen_lead_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> MEKANISM_DEEPSLATE_LEAD_ORE_ENTITY = registerBlock("mekanism_regen_deepslate_lead_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private  static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}



