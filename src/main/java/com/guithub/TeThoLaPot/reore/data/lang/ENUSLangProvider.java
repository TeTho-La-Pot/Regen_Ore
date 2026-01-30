package com.guithub.TeThoLaPot.reore.data.lang;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import com.guithub.TeThoLaPot.reore.init.block.ModBlocks;
import com.guithub.TeThoLaPot.reore.item.Items;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLangProvider extends LanguageProvider {
    public ENUSLangProvider(PackOutput output) {
        super(output, RE_Ore.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        //Items
        addItem(Items.TORE, "Raw Test Ore");

        //Blocks
        addBlock(ModBlocks.TEST_ORE, "Test Ore");

        //CreativeTabs
        add("creativetab.reore_tab", "Regen Ore");

        //Jade
        add("config.jade.plugin_re_ore.regen_tick", "Regen Time");
        add("re_ore.regen", "RegenCooldown: %s");
        add("re_ore.can_regen", "Regenerate");
    }
}
