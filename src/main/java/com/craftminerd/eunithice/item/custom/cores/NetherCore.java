package com.craftminerd.eunithice.item.custom.cores;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NetherCore extends CoreType {
    public NetherCore(Item.Properties properties) {
        super(properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }

}
