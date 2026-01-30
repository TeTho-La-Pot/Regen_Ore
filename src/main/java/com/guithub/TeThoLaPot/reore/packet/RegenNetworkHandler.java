package com.guithub.TeThoLaPot.reore.packet;

import com.guithub.TeThoLaPot.reore.RE_Ore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class RegenNetworkHandler {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation("re_ore", "re_ore_channel"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    private static int packetId = 0;
    private static int id() { return packetId++; }

    public static void register(){
        CHANNEL.registerMessage(id(),
                OnBlockTagPacket.class,
                OnBlockTagPacket::encode,
                OnBlockTagPacket::decode,
                OnBlockTagPacket::handle
                );
    }

    public static void sendToPlayer(Object message, ServerPlayer player){
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static void sendToAll(Object message){
        CHANNEL.send(PacketDistributor.ALL.noArg(), message);
    }
}
