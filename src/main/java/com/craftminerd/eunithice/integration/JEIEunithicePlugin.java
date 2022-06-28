package com.craftminerd.eunithice.integration;

import com.craftminerd.eunithice.Eunithice;
import com.craftminerd.eunithice.block.EunithiceBlocks;
import com.craftminerd.eunithice.recipe.WorkStationShapelessRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIEunithicePlugin implements IModPlugin {

    public static final RecipeType<WorkStationShapelessRecipe> WORK_STATION =
            RecipeType.create(Eunithice.MODID, "work_station_shapeless", WorkStationShapelessRecipe.class);

    private IRecipeCategory<WorkStationShapelessRecipe> workStationCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Eunithice.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(workStationCategory = new
                WorkStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<WorkStationShapelessRecipe> recipes = rm.getAllRecipesFor(WorkStationShapelessRecipe.Type.INSTANCE);
        registration.addRecipes(WORK_STATION, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(EunithiceBlocks.WORK_STATION.get()), WORK_STATION);
    }
}
