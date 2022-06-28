package com.craftminerd.eunithice.integration;

import com.craftminerd.eunithice.Eunithice;
import com.craftminerd.eunithice.block.EunithiceBlocks;
import com.craftminerd.eunithice.recipe.WorkStationShapelessRecipe;
import com.craftminerd.eunithice.util.EunithiceTags;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

@SuppressWarnings("removal")
public class WorkStationRecipeCategory implements IRecipeCategory<WorkStationShapelessRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Eunithice.MODID, "work_station_shapeless");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Eunithice.MODID, "textures/gui/work_station_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public WorkStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(EunithiceBlocks.WORK_STATION.get()));
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Work Station");
    }
    @Override
    public IDrawable getBackground() {
        return this.background;
    }
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }
    @Override
    public ResourceLocation getUid() {
        return UID;
    }
    @Override
    public Class<? extends WorkStationShapelessRecipe> getRecipeClass() {
        return WorkStationShapelessRecipe.class;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull WorkStationShapelessRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        int slotsLeft = 4;
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if (recipe.getIngredients().get(i).getItems()[0].is(EunithiceTags.Items.CORES)) {
                builder.addSlot(RecipeIngredientRole.INPUT, 26, 40).addIngredients(recipe.getIngredients().get(i)); // CORE SLOT
            }
            else if (recipe.getIngredients().get(i).getItems()[0].is(EunithiceTags.Items.HAMMERS)) {
                builder.addSlot(RecipeIngredientRole.INPUT, 62, 18).addIngredients(recipe.getIngredients().get(i)); // HAMMER SLOT
            } else {
                switch (slotsLeft) {
                    case 4:
                        builder.addSlot(RecipeIngredientRole.INPUT, 98, 9).addIngredients(recipe.getIngredients().get(i));
                        slotsLeft -=1;
                        break;
                    case 3:
                        builder.addSlot(RecipeIngredientRole.INPUT, 116, 9).addIngredients(recipe.getIngredients().get(i));
                        slotsLeft -=1;
                        break;
                    case 2:
                        builder.addSlot(RecipeIngredientRole.INPUT, 98, 27).addIngredients(recipe.getIngredients().get(i));
                        slotsLeft -= 1;
                        break;
                    case 1:
                        builder.addSlot(RecipeIngredientRole.INPUT, 5, 116).addIngredients(recipe.getIngredients().get(i));
                        slotsLeft -= 1;
                        break;
                    default:
                        throw new IndexOutOfBoundsException("Error occurred whilst setting recipe in JEI integration");
                }
            }
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem());
    }
}
