package com.github.TeThoLaPot.regen_resources.packet;

import com.github.TeThoLaPot.regen_resources.util.RegenTickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

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
