package com.craftminerd.eunithice.enchantments;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Map;
import java.util.Random;

public class FireThornsEnchantment extends Enchantment {
    public FireThornsEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.ARMOR, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 10 + 20 * (pEnchantmentLevel - 1);
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    public boolean canEnchant(Item p_44806_) {
        return p_44806_ instanceof ArmorItem && ((((ArmorItem)p_44806_).getSlot() == EquipmentSlot.FEET) || (((ArmorItem)p_44806_).getSlot() == EquipmentSlot.LEGS));
    }

    @Override
    public void doPostHurt(LivingEntity pUser, Entity pAttacker, int pLevel) {
        Random random = pUser.getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.getRandomItemWith(EunithiceEnchantments.FIRE_THORNS.get(), pUser);
        if (shouldApplyFire(pLevel, random)) {
            if (pAttacker != null) {
                pAttacker.setSecondsOnFire(pAttacker.getRemainingFireTicks() + getFireLengthAmount(pLevel, random));
            }
            if (entry != null) {
                entry.getValue().hurtAndBreak(2, pUser, (p_45208_) -> {
                    p_45208_.broadcastBreakEvent(entry.getKey());
                });
            }
        }
    }

    public static boolean shouldApplyFire(int pLevel, Random pRnd) {
        if (pLevel <= 0) {
            return false;
        } else {
            return pRnd.nextFloat() < 0.25F * (float)pLevel;
        }
    }

    public static int getFireLengthAmount(int pLevel, Random pRnd) {
        return pLevel > 10 ? pLevel - 10 : 1 + pRnd.nextInt(4);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
