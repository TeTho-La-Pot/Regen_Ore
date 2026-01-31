package com.guithub.TeThoLaPot.reore.recipe;

import com.google.common.base.Suppliers;
import com.guithub.TeThoLaPot.reore.config.RegenOreCommonConfig;
import com.guithub.TeThoLaPot.reore.item.Re_Items;
import com.guithub.TeThoLaPot.reore.util.RegenWorkUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.function.Supplier;

public class AncientDebrisModifier extends LootModifier {
    public static final Supplier<Codec<AncientDebrisModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, AncientDebrisModifier::new)));

    public AncientDebrisModifier(LootItemCondition[] conditionsIn){
        super(conditionsIn);
    }

    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (RegenWorkUtils.enable_change_ancient_debris_drops) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(Re_Items.Ancient_Fragment.get(), 4));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec(){
        return CODEC.get();
    }
}
