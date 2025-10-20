package com.guithub.TeThoLaPot.reore.init.entity;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RE_Ore.MOD_ID);

    public static final RegistryObject<BlockEntityType<RegenOreEntity>> REGEN_ORE_ENTITY =
            BLOCK_ENTITIES.register("regen_ore_entity",
                    () -> BlockEntityType.Builder.of(RegenOreEntity::new,

                            //TEST
                            ModBlocks.TEST_ORE.get(),
                            ModBlocks.REGEN_PRESET01.get(),
                            ModBlocks.REGEN_PRESET02.get(),
                            ModBlocks.REGEN_PRESET03.get(),
                            ModBlocks.REGEN_PRESET04.get(),
                            ModBlocks.REGEN_PRESET05.get(),
                            ModBlocks.REGEN_PRESET06.get(),
                            ModBlocks.REGEN_PRESET07.get(),
                            ModBlocks.REGEN_PRESET08.get(),
                            ModBlocks.REGEN_PRESET09.get(),
                            ModBlocks.REGEN_PRESET10.get(),
                            ModBlocks.D_REGEN_PRESET01.get(),
                            ModBlocks.D_REGEN_PRESET02.get(),
                            ModBlocks.D_REGEN_PRESET03.get(),
                            ModBlocks.D_REGEN_PRESET04.get(),
                            ModBlocks.D_REGEN_PRESET05.get(),
                            ModBlocks.D_REGEN_PRESET06.get(),
                            ModBlocks.D_REGEN_PRESET07.get(),
                            ModBlocks.D_REGEN_PRESET08.get(),
                            ModBlocks.D_REGEN_PRESET09.get(),
                            ModBlocks.D_REGEN_PRESET10.get()

                            ).build(null));



}
