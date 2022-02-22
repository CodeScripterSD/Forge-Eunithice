package com.craftminerd.eunithice.block.custom;

import com.craftminerd.eunithice.enchantments.EunithiceEnchantments;
import com.craftminerd.eunithice.item.EunithiceItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MobBoxType extends Block {
    public MobBoxType(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            if (pPlayer.experienceLevel >= 40 || pPlayer.isCreative()) {
                if (!pPlayer.isCreative()) pPlayer.giveExperienceLevels(-40);
                Zombie SpeedyZombie = EntityType.ZOMBIE.create(pLevel);
                SpeedyZombie.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 24000, 9));
                SpeedyZombie.setItemSlot(EquipmentSlot.CHEST, EunithiceItems.PLATED_DIAMOND_CHESTPLATE.get().getDefaultInstance());
                SpeedyZombie.setPos(pPos.getX(), pPos.getY()+1, pPos.getZ());

                pLevel.addFreshEntity(SpeedyZombie);
            } else {
                pLevel.playSound(pPlayer, pPos, SoundEvents.ANVIL_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
                return InteractionResult.FAIL;
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
