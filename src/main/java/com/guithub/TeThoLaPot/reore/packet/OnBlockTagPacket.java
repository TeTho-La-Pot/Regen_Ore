package com.guithub.TeThoLaPot.reore.packet;

import com.guithub.TeThoLaPot.reore.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

import static java.time.chrono.JapaneseChronology.INSTANCE;

public class OnBlockTagPacket {
    private final BlockPos pos;
    private final  boolean flag;

    public OnBlockTagPacket(BlockPos pos, boolean flag){
        this.pos = pos;
        this.flag = flag;
    }

    public static OnBlockTagPacket decode(FriendlyByteBuf buf){
        return new OnBlockTagPacket(buf.readBlockPos(), buf.readBoolean());
    }

    public void encode(FriendlyByteBuf buf){
        buf.writeBlockPos(this.pos);
        buf.writeBoolean(this.flag);
    }

    public void handle(Supplier<NetworkEvent.Context> context){
        NetworkEvent.Context ctx = context.get();
        ctx.enqueueWork(() -> {
            RegenTickUtils.updateFlag(this.pos, this.flag);
        });
        ctx.setPacketHandled(true);
    }
}
