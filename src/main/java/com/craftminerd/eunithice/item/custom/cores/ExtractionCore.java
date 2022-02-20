package com.craftminerd.eunithice.item.custom.cores;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ExtractionCore extends CoreType{
    public ExtractionCore(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        // TODO Auto-generated method stub

        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.extraction_core_0"));
        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.extraction_core_1"));

        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1))) hurtItem(pPlayer.getItemInHand(pUsedHand));
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
