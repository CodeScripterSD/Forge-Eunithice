package com.craftminerd.eunithice.util;

import com.craftminerd.eunithice.Eunithice;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.common.Tags;

public class EunithiceTags {
    public static class Blocks {
        public static final TagKey<Block> MINEABLE_WITH_HAMMER = tag("mineable/hammer");
        public static final TagKey<Block> HAMMERABLE_BLOCKS = tag("hammerable_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Eunithice.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAMMERS = tag("hammers");
        public static final TagKey<Item> STONE_HAMMERS_UP = tag("stone_hammers_up");
        public static final TagKey<Item> IRON_HAMMERS_UP = tag("iron_hammers_up");
        public static final TagKey<Item> DIAMOND_HAMMERS_UP = tag("diamond_hammers_up");
        public static final TagKey<Item> CORES = tag("cores");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Eunithice.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
