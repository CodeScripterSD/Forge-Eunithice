package com.craftminerd.eunithice.item.custom.tools;

import com.craftminerd.eunithice.item.custom.tiers.EunithiceToolTiers;
import com.craftminerd.eunithice.util.EunithiceTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class DiamondHammer extends HammerItem {
    public DiamondHammer(Properties pProperties) {
        super(0f, -1f, EunithiceToolTiers.PLATED_DIAMOND, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos clickedPos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            Block blockClicked = pContext.getLevel().getBlockState(clickedPos.below(0)).getBlock();
            if (isHammerableBlock(blockClicked)) {
                if (!player.isCreative()) {
                    pContext.getLevel().destroyBlock(clickedPos, true, player);
                    hurtItem(player.getItemInHand(player.getUsedItemHand()));
                } else {
                    pContext.getLevel().destroyBlock(clickedPos, false, player);
                }
            }
        }
        return super.useOn(pContext);
    }

    private void hurtItem(ItemStack stack) {
        if (stack.getMaxDamage() - stack.getDamageValue() <= 1) {
            stack.shrink(1);
        } else {
            stack.hurt(1, random, null);
        }
    }

    private boolean isHammerableBlock(Block block) {
        return EunithiceTags.Blocks.HAMMERABLE_BLOCKS.contains(block) || block == Blocks.OBSIDIAN;
    }

    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.diamond_hammer_tooltip"));
        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }
}
