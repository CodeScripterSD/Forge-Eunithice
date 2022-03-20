package com.craftminerd.eunithice.item.custom.cores;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExtractionCore extends CoreType{
    public ExtractionCore(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, @NotNull List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.extraction_core_0"));
        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.extraction_core_1"));
        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }
    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

}
