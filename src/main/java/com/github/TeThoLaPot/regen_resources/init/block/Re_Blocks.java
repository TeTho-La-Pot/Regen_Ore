package com.github.TeThoLaPot.regen_resources.init.block;

import com.github.TeThoLaPot.regen_resources.RegenResources;
import com.github.TeThoLaPot.regen_resources.init.block.RegenBlocks; // クラス名は既存のものを想定
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Re_Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RegenResources.MOD_ID);

    // 時間ごとに分けていたものを廃止し、これ一つに統合します
    public static final RegistryObject<Block> REGEN_BLOCK = BLOCKS.register("regen_block",
            () -> new RegenBlocks(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(-1.0F, 3600000.0F) // 破壊不可設定
                    .noLootTable()
            )
    );

    // ※ もし REGEN_BLOCK_1, 2... などがあれば、それらは削除して大丈夫です
}

