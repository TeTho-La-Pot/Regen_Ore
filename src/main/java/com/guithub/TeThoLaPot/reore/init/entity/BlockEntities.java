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
                            ModBlocks.REGEN_IRON_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_IRON_ORE_ENTITY.get(),
                            ModBlocks.REGEN_COPPER_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get(),
                            ModBlocks.REGEN_GOLD_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get(),
                            ModBlocks.REGEN_NETHER_GOLD_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DIAMOND_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get(),
                            ModBlocks.REGEN_EMERALD_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get(),
                            ModBlocks.REGEN_COAL_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_COAL_ORE_ENTITY.get(),
                            ModBlocks.REGEN_LAPIS_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get(),
                            ModBlocks.REGEN_REDSTONE_ORE_ENTITY.get(),
                            ModBlocks.REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get(),
                            ModBlocks.REGEN_NETHER_QUARTZ_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_IRON_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_IRON_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_COPPER_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_COPPER_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_GOLD_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_GOLD_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_NETHER_GOLD_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DIAMOND_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_DIAMOND_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_EMERALD_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_EMERALD_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_COAL_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_COAL_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_LAPIS_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_LAPIS_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_REDSTONE_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_DEEPSLATE_REDSTONE_ORE_ENTITY.get(),
                            ModBlocks.V_REGEN_NETHER_QUARTZ_ORE_ENTITY.get(),

                            //TEST
                            ModBlocks.TEST_ORE.get()

                            //Create
//                            ModBlocks.CREATE_ZINC_ORE_ENTITY.get(),
//                            ModBlocks.CREATE_DEEPSLATE_ZINC_ORE_ENTITY.get(),
//
                            //Mekanism
//                            ModBlocks.MEKANISM_TIN_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_DEEPSLATE_TIN_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_OSUMIUM_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_DEEPSLATE_OSUMIUM_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_URANIUM_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_DEEPSLATE_URANIUM_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_FLUORITE_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_DEEPSLATE_FLUORITE_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_LEAD_ORE_ENTITY.get(),
//                            ModBlocks.MEKANISM_DEEPSLATE_LEAD_ORE_ENTITY.get()
                            ).build(null));



}
