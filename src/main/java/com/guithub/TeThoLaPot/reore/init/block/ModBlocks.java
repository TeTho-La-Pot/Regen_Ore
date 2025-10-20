package com.guithub.TeThoLaPot.reore.init.block;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.item.Items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RE_Ore.MOD_ID);

    public static final RegistryObject<Block> TEST_ORE = registerBlock("test_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));

    //Normal Skins
    public static final RegistryObject<Block> REGEN_PRESET01 = registerBlock("regen_preset01",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET02 = registerBlock("regen_preset02",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET03 = registerBlock("regen_preset03",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET04 = registerBlock("regen_preset04",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET05 = registerBlock("regen_preset05",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET06 = registerBlock("regen_preset06",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET07 = registerBlock("regen_preset07",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET08 = registerBlock("regen_preset08",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET09 = registerBlock("regen_preset09",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

    public static final RegistryObject<Block> REGEN_PRESET10 = registerBlock("regen_preset10",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));


    //Normal Skins
    public static final RegistryObject<Block> D_REGEN_PRESET01 = registerBlock("d_regen_preset01",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET02 = registerBlock("d_regen_preset02",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET03 = registerBlock("d_regen_preset03",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET04 = registerBlock("d_regen_preset04",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET05 = registerBlock("d_regen_preset05",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET06 = registerBlock("d_regen_preset06",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET07 = registerBlock("d_regen_preset07",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET08 = registerBlock("d_regen_preset08",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET09 = registerBlock("d_regen_preset09",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> D_REGEN_PRESET10 = registerBlock("d_regen_preset10",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).noLootTable()));

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
