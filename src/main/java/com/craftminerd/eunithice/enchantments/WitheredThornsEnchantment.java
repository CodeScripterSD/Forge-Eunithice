package com.craftminerd.eunithice.enchantments;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;

import java.util.Map;
import java.util.Random;

public class WitheredThornsEnchantment extends Enchantment {
    public WitheredThornsEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.ARMOR_CHEST, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 + 20 * (pEnchantmentLevel - 1);
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    @Override
    public boolean isTradeable() {
        return true;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity pUser, Entity pAttacker, int pLevel) {
        Random random = pUser.getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.getRandomItemWith(EunithiceEnchantments.WITHERED_THORNS.get(), pUser);
        if (shouldApplyEffect(pLevel, random)) {
            if (pAttacker != null && pAttacker instanceof LivingEntity) {
                ((LivingEntity)pAttacker).addEffect(new MobEffectInstance(MobEffects.WITHER, getDurationOfEffect(pLevel, random), pLevel - 1));
                if (shouldApplyEffect(pLevel - 1, random)) {
                    pUser.addEffect(new MobEffectInstance(MobEffects.WITHER, getDurationOfEffect(1, random) - 80, 0));
                }
            }
            if (entry != null) {
                entry.getValue().hurtAndBreak(2, pUser, (p_45208_) -> {
                    p_45208_.broadcastBreakEvent(entry.getKey());
                });
            }
        }
    }

    public boolean checkCompatibility(Enchantment pEnch) {
        return pEnch instanceof ThornsEnchantment || pEnch instanceof FireThornsEnchantment ? false : true;
    }

    private static boolean shouldApplyEffect(int pLevel, Random pRnd) {
        if (pLevel <= 0) {
            return false;
        } else {
            return pRnd.nextFloat() < 0.2F * (float)pLevel;
        }
    }

    public static int getDurationOfEffect(int pLevel, Random pRnd) {
        return pLevel > 10 ? (pLevel - 10) * 20 : ((1 + pRnd.nextInt(4)) * 20) + 80;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
