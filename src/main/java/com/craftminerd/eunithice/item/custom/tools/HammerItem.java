package com.craftminerd.eunithice.item.custom.tools;

import com.craftminerd.eunithice.util.EunithiceTags;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class HammerItem extends DiggerItem {


    Random random = new Random();

    public HammerItem(float pAttackDamageModifier, float pAttackSpeedModifier, Tier pTier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, EunithiceTags.Blocks.MINEABLE_WITH_HAMMER, pProperties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Nonnull
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack itemstack) {
        ItemStack stack = itemstack.copy();
        hurtItem(stack);
        return stack;
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos clickedPos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            Block blockClicked = pContext.getLevel().getBlockState(clickedPos).getBlock();
            if (isHammerableBlock(blockClicked)) {
                if (player.isCreative()) {
                    pContext.getLevel().destroyBlock(clickedPos, false);
                } else {
                    pContext.getLevel().destroyBlock(clickedPos, true);

                    pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                        p.broadcastBreakEvent(pContext.getHand());
                    });
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private void hurtItem(ItemStack stack) {
        if (stack.getMaxDamage() - stack.getDamageValue() <= 1) {
            stack.shrink(1);
        } else {
            stack.hurt(1, random, null);
        }
    }

    protected boolean isHammerableBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(EunithiceTags.Blocks.HAMMERABLE_BLOCKS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        // TODO Auto-generated method stub

        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.common_hammer_tooltip"));

        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }
}
