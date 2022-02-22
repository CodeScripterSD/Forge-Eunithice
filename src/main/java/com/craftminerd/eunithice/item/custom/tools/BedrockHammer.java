package com.craftminerd.eunithice.item.custom.tools;

import com.craftminerd.eunithice.item.custom.tiers.EunithiceToolTiers;
import com.craftminerd.eunithice.util.EunithiceTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class BedrockHammer extends DiggerItem {

    public BedrockHammer(Properties pProperties) {
        super(20000f, 20000f, EunithiceToolTiers.CHARRED_DIAMOND, EunithiceTags.Blocks.MINEABLE_WITH_HAMMER, pProperties);
    }
    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
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

    private boolean isHammerableBlock(Block block) {
        return block == Blocks.BEDROCK;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        // TODO Auto-generated method stub

        pToolTipComponents.add(new TranslatableComponent("tooltip.eunithice.bedrock_hammer_tooltip1"));

        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }
}
