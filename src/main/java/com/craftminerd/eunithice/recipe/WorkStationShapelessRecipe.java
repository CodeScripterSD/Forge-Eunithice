package com.craftminerd.eunithice.recipe;

import com.craftminerd.eunithice.Eunithice;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import org.jetbrains.annotations.Nullable;


public class WorkStationShapelessRecipe implements Recipe<SimpleContainer> {
    private final String group;
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;

    public WorkStationShapelessRecipe(ResourceLocation id,String group, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.group = group;
        this.id = id;
        this.result = result;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for (int j = 0; j < pContainer.getContainerSize()-1; ++j) {
            ItemStack itemStack = pContainer.getItem(j);
            if (!itemStack.isEmpty()) {
                ++i;
                inputs.add(itemStack);
            }
        }
        return i == this.recipeItems.size() && (RecipeMatcher.findMatches(inputs, this.recipeItems) != null);
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return result;
    }
    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }
    @Override
    public ItemStack getResultItem() {
        return result;
    }
    @Override
    public ResourceLocation getId() {
        return id;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }
    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<WorkStationShapelessRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "work_station_shapeless";
    }

    public static class Serializer implements RecipeSerializer<WorkStationShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Eunithice.MODID, "work_station_shapeless");

        @Override
        public WorkStationShapelessRecipe fromJson(ResourceLocation id, JsonObject json) {
            String s = GsonHelper.getAsString(json, "group", "");
            NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for Workstation shapeless recipe");
            } else if (nonnulllist.size() > 6) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is 6");
            } else {
                ItemStack itemStack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json,"result"));
                return new WorkStationShapelessRecipe(id,s,itemStack,nonnulllist);
            }
        }

        private static NonNullList<Ingredient> itemsFromJson(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }
            return nonnulllist;
        }

        @Nullable
        @Override
        public WorkStationShapelessRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            String s = buf.readUtf();
            int i = buf.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < nonnulllist.size(); ++j) {
                nonnulllist.set(j, Ingredient.fromNetwork(buf));
            }

            ItemStack itemStack = buf.readItem();
            return new WorkStationShapelessRecipe(id,s,itemStack,nonnulllist);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, WorkStationShapelessRecipe recipe) {
            buf.writeUtf(recipe.group);
            buf.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItem(recipe.getResultItem());
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
