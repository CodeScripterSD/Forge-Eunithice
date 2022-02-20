package com.craftminerd.eunithice.item.custom.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class EunithiceFoods {
    public static final FoodProperties LEURITE_BREAD = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F).build();
    public static final FoodProperties MEATBALL_SOUP = (new FoodProperties.Builder()).nutrition(9).saturationMod(1.2F).build();
    public static final FoodProperties VEGETABLE_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(1.2F).build();
    public static final FoodProperties FRUIT_DISH = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).build();

    public static final FoodProperties REVIVAL_SANDWICH = (new FoodProperties.Builder()).nutrition(30).saturationMod(5f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 2400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 72000, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 72000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 72000, 3), 1.0F).build();

}
