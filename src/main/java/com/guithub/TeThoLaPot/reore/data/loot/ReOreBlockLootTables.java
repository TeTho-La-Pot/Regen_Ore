package com.guithub.TeThoLaPot.reore.data.loot;

import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

// NOT USE NOW...

public class ReOreBlockLootTables extends BlockLootSubProvider {
    protected ReOreBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
    }


//    protected LootTable.Builder createNetherGoldLikeOreDrops(Block pBlock, Item pItem) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock,
//                        LootItem.lootTableItem(pItem)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
