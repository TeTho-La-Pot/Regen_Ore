package com.guithub.TeThoLaPot.reore.item;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;


public class BreakStaff extends Item {
    public BreakStaff(Properties pProperties) {
        super(pProperties);
    }

    private void modeChange(ItemStack stack){
        if (stack.getTag() == null){
            stack.setTag(new CompoundTag());
        }
        stack.getTag().putInt("mode", modeNum(stack) < 1 ? modeNum(stack) + 1 : 0);
    }

    public int modeNum(ItemStack stack){
        if (stack.getTag() == null) {
            return 0;
        }
        return stack.getTag().getInt("mode");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand useHand) {
        ItemStack stack = player.getItemInHand(useHand);
        if (player.isSteppingCarefully()){
            player.startUsingItem(useHand);
            modeChange(stack);
            level.playSound(player, player, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        if (modeNum(stack) == 0) {return false;}
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide) {
            if (stack.getTag() == null) {
                stack.setTag(new CompoundTag());
                stack.getTag().putInt("mode", 0);
            }
        }
    }
}
