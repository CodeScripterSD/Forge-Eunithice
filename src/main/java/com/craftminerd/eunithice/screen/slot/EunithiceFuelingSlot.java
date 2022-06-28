package com.craftminerd.eunithice.screen.slot;

import com.craftminerd.eunithice.util.EunithiceTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class EunithiceFuelingSlot extends SlotItemHandler {
    public EunithiceFuelingSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        if (PotionUtils.getPotion(stack) == Potions.WATER || stack.is(EunithiceTags.Items.CORES)) {
            return true;
        } else return false;
    }
}
