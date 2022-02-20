package com.craftminerd.eunithice.item.custom.cores;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class NetherCore extends CoreType {
    public NetherCore(Item.Properties properties) {
        super(properties);
    }

    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }

}
