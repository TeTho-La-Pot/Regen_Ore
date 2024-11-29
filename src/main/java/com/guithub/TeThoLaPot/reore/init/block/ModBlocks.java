package com.guithub.TeThoLaPot.reore.init.block;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.item.Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));


    //鉄鉱石
    public static final RegistryObject<Block> REGEN_IRON_ORE_ENTITY = registerBlock("regen_iron_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_IRON_ORE = registerBlock("regened_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_IRON_ORE_ENTITY = registerBlock("regen_deepslate_iron_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_IRON_ORE = registerBlock("regened_deepslate_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));


    //銅鉱石
    public static final RegistryObject<Block> REGEN_COPPER_ORE_ENTITY = registerBlock("regen_copper_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_COPPER_ORE = registerBlock("regened_copper_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_COPPER_ORE_ENTITY = registerBlock("regen_deepslate_copper_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_COPPER_ORE = registerBlock("regened_deepslate_copper_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));


    //金鉱石・ネザー金鉱石
    public static final RegistryObject<Block> REGEN_GOLD_ORE_ENTITY = registerBlock("regen_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_GOLD_ORE = registerBlock("regened_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_GOLD_ORE_ENTITY = registerBlock("regen_deepslate_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_GOLD_ORE = registerBlock("regened_deepslate_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));

    public static final RegistryObject<Block> REGEN_NETHER_GOLD_ORE_ENTITY = registerBlock("regen_nether_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).noLootTable()));

    public static final RegistryObject<Block> REGENED_NETHER_GOLD_ORE = registerBlock("regened_nether_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)));


    //ダイヤモンド
    public static final RegistryObject<Block> REGEN_DIAMOND_ORE_ENTITY = registerBlock("regen_diamond_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DIAMOND_ORE = registerBlock("regened_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY = registerBlock("regen_deepslate_diamond_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_DIAMOND_ORE = registerBlock("regened_deepslate_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));


    //エメラルド
    public static final RegistryObject<Block> REGEN_EMERALD_ORE_ENTITY = registerBlock("regen_emerald_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_EMERALD_ORE = registerBlock("regened_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_EMERALD_ORE_ENTITY = registerBlock("regen_deepslate_emerald_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_EMERALD_ORE = registerBlock("regened_deepslate_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)));


    //石炭
    public static final RegistryObject<Block> REGEN_COAL_ORE_ENTITY = registerBlock("regen_coal_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_COAL_ORE = registerBlock("regened_coal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_COAL_ORE_ENTITY = registerBlock("regen_deepslate_coal_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_COAL_ORE = registerBlock("regened_deepslate_coal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COAL_ORE)));


    //ラピスラズリ
    public static final RegistryObject<Block> REGEN_LAPIS_ORE_ENTITY = registerBlock("regen_lapis_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_LAPIS_ORE = registerBlock("regened_lapis_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_LAPIS_ORE_ENTITY = registerBlock("regen_deepslate_lapis_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_LAPIS_ORE = registerBlock("regened_deepslate_lapis_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_LAPIS_ORE)));


    //レッドストーン
    public static final RegistryObject<Block> REGEN_REDSTONE_ORE_ENTITY = registerBlock("regen_redstone_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> REGENED_REDSTONE_ORE = registerBlock("regened_redstone_ore",
            () -> new RegenRedstoneBlocks(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));

    public static final RegistryObject<Block> REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY = registerBlock("regen_deepslate_redstone_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> REGENED_DEEPSLATE_REDSTONE_ORE = registerBlock("regened_deepslate_redstone_ore",
            () -> new RegenRedstoneBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_REDSTONE_ORE)));


    //ネザークォーツ
    public static final RegistryObject<Block> REGEN_NETHER_QUARTZ_ORE_ENTITY = registerBlock("regen_nether_quartz_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).noLootTable()));

    public static final RegistryObject<Block> REGENED_NETHER_QUARTZ_ORE = registerBlock("regened_nether_quartz_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)));



    //バニラ鉱石
    public static final RegistryObject<Block> V_REGEN_IRON_ORE_ENTITY = registerBlock("v_regen_iron_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_IRON_ORE_ENTITY = registerBlock("v_regen_deepslate_iron_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_COPPER_ORE_ENTITY = registerBlock("v_regen_copper_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_COPPER_ORE_ENTITY = registerBlock("v_regen_deepslate_copper_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_GOLD_ORE_ENTITY = registerBlock("v_regen_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_GOLD_ORE_ENTITY = registerBlock("v_regen_deepslate_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_NETHER_GOLD_ORE_ENTITY = registerBlock("v_regen_nether_gold_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DIAMOND_ORE_ENTITY = registerBlock("v_regen_diamond_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY = registerBlock("v_regen_deepslate_diamond_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_EMERALD_ORE_ENTITY = registerBlock("v_regen_emerald_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_EMERALD_ORE_ENTITY = registerBlock("v_regen_deepslate_emerald_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_COAL_ORE_ENTITY = registerBlock("v_regen_coal_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_COAL_ORE_ENTITY = registerBlock("v_regen_deepslate_coal_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_LAPIS_ORE_ENTITY = registerBlock("v_regen_lapis_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_LAPIS_ORE_ENTITY = registerBlock("v_regen_deepslate_lapis_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_REDSTONE_ORE_ENTITY = registerBlock("v_regen_redstone_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY = registerBlock("v_regen_deepslate_redstone_ore",
            () -> new RegenRedstoneBlocks(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noLootTable()));

    public static final RegistryObject<Block> V_REGEN_NETHER_QUARTZ_ORE_ENTITY = registerBlock("v_regen_nether_quartz_ore",
            () -> new RegenOreBlocks(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).noLootTable()));



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
