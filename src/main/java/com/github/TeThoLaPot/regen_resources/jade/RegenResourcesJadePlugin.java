package com.github.TeThoLaPot.regen_resources.jade;

import com.github.TeThoLaPot.regen_resources.init.block.RegenBlocks; // 実際のクラス名に合わせてください
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class RegenResourcesJadePlugin implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        // register ではなく registerClient を使用し、
        // registerBlockComponent でプロバイダーを登録します
        registration.registerBlockComponent(RegenResourcesJadeProvider.INSTANCE, RegenBlocks.class);
    }
}

