package com.craftminerd.eunithice.recipe;

import com.craftminerd.eunithice.Eunithice;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EunithiceRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Eunithice.MODID);

    public static final RegistryObject<RecipeSerializer<WorkStationShapelessRecipe>> WORK_STATION_SHAPELESS_SERIALIZER = SERIALIZERS.register("work_station_shapeless", ()->
            WorkStationShapelessRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) { SERIALIZERS.register(eventBus); }
}
