package com.guithub.TeThoLaPot.reore.init.entity;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.Re_Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
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
                            Re_Blocks.TEST_ORE.get(),
                            Re_Blocks.REGEN_PRESET01.get(),
                            Re_Blocks.REGEN_PRESET02.get(),
                            Re_Blocks.REGEN_PRESET03.get(),
                            Re_Blocks.REGEN_PRESET04.get(),
                            Re_Blocks.REGEN_PRESET05.get(),
                            Re_Blocks.REGEN_PRESET06.get(),
                            Re_Blocks.REGEN_PRESET07.get(),
                            Re_Blocks.REGEN_PRESET08.get(),
                            Re_Blocks.REGEN_PRESET09.get(),
                            Re_Blocks.REGEN_PRESET10.get(),
                            Re_Blocks.D_REGEN_PRESET01.get(),
                            Re_Blocks.D_REGEN_PRESET02.get(),
                            Re_Blocks.D_REGEN_PRESET03.get(),
                            Re_Blocks.D_REGEN_PRESET04.get(),
                            Re_Blocks.D_REGEN_PRESET05.get(),
                            Re_Blocks.D_REGEN_PRESET06.get(),
                            Re_Blocks.D_REGEN_PRESET07.get(),
                            Re_Blocks.D_REGEN_PRESET08.get(),
                            Re_Blocks.D_REGEN_PRESET09.get(),
                            Re_Blocks.D_REGEN_PRESET10.get(),
                            Re_Blocks.N_REGEN_PRESET01.get(),
                            Re_Blocks.N_REGEN_PRESET02.get(),
                            Re_Blocks.N_REGEN_PRESET03.get(),
                            Re_Blocks.N_REGEN_PRESET04.get(),
                            Re_Blocks.N_REGEN_PRESET05.get(),
                            Re_Blocks.N_REGEN_PRESET06.get(),
                            Re_Blocks.N_REGEN_PRESET07.get(),
                            Re_Blocks.N_REGEN_PRESET08.get(),
                            Re_Blocks.N_REGEN_PRESET09.get(),
                            Re_Blocks.N_REGEN_PRESET10.get(),
                            Re_Blocks.DEBRIS_REGEN_PRESET.get()

                            ).build(null));



}
