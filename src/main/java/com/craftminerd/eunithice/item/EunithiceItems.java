package com.craftminerd.eunithice.item;

import com.craftminerd.eunithice.Eunithice;
import com.craftminerd.eunithice.block.EunithiceBlocks;
import com.craftminerd.eunithice.item.custom.cores.BurnCore;
import com.craftminerd.eunithice.item.custom.cores.ExtractionCore;
import com.craftminerd.eunithice.item.custom.cores.NetherCore;
import com.craftminerd.eunithice.item.custom.foods.*;
import com.craftminerd.eunithice.item.custom.tiers.EunithiceArmorMaterials;
import com.craftminerd.eunithice.item.custom.tiers.EunithiceToolTiers;
import com.craftminerd.eunithice.item.custom.tools.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EunithiceItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Eunithice.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    /// Begin Items


    public static final RegistryObject<HandheldEnderChest> HANDHELD_ENDER_CHEST = ITEMS.register("handheld_ender_chest",
            () -> new HandheldEnderChest(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .stacksTo(1)));


    public static final RegistryObject<BedrockHammer> BEDROCK_HAMMER = ITEMS.register("bedrock_hammer",
            () -> new BedrockHammer(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ExtractionCore> EXTRACTION_CORE = ITEMS.register("extraction_core",
            () -> new ExtractionCore(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .defaultDurability(2000)));

    public static final RegistryObject<BurnCore> BURN_CORE = ITEMS.register("burn_core",
            () -> new BurnCore(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .defaultDurability(2000)));

    public static final RegistryObject<NetherCore> NETHER_CORE = ITEMS.register("nether_core",
            () -> new NetherCore(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .defaultDurability(1000)));

    public static final RegistryObject<NetherCore> SUPERHEATED_NETHER_CORE = ITEMS.register("superheated_nether_core",
            () -> new NetherCore(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .defaultDurability(5000)));

    public static final RegistryObject<Item> STONE_SHEET = ITEMS.register("stone_sheet",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<Item> HARDENED_DIAMOND_PLATE = ITEMS.register("hardened_diamond_plate",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<Item> DIAMOND_FRAGMENT = ITEMS.register("diamond_fragment",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    /////////////////////////////////////
    /////////////   TOOLS
    /////////////////////////////////////

    public static final RegistryObject<WoodHammer> WOOD_HAMMER = ITEMS.register("wood_hammer",
            () -> new WoodHammer(0f, -3f, Tiers.WOOD, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)
                    .defaultDurability(50)));

    public static final RegistryObject<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(0f, -3f, Tiers.STONE, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(0f, -3f, Tiers.IRON, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(0f, -3f, Tiers.DIAMOND, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<DiamondHammer> PLATED_DIAMOND_HAMMER = ITEMS.register("plated_diamond_hammer",
            () -> new DiamondHammer(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ShovelItem> PLATED_IRON_SHOVEL = ITEMS.register("plated_iron_shovel",
            () -> new ShovelItem(EunithiceToolTiers.PLATED_IRON, 1.5f, -3.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<PickaxeItem> PLATED_IRON_PICKAXE = ITEMS.register("plated_iron_pickaxe",
            () -> new PickaxeItem(EunithiceToolTiers.PLATED_IRON, 1, -2.8f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<AxeItem> PLATED_IRON_AXE = ITEMS.register("plated_iron_axe",
            () -> new AxeItem(EunithiceToolTiers.PLATED_IRON, 6.0f, -3.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HoeItem> PLATED_IRON_HOE = ITEMS.register("plated_iron_hoe",
            () -> new HoeItem(EunithiceToolTiers.PLATED_IRON, -3, 0.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<SwordItem> PLATED_IRON_SWORD = ITEMS.register("plated_iron_sword",
            () -> new SwordItem(EunithiceToolTiers.PLATED_IRON, 3, -2.4f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));



    public static final RegistryObject<ShovelItem> PLATED_GOLD_SHOVEL = ITEMS.register("plated_gold_shovel",
            () -> new ShovelItem(EunithiceToolTiers.PLATED_GOLD, 1.5f, -3.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<PickaxeItem> PLATED_GOLD_PICKAXE = ITEMS.register("plated_gold_pickaxe",
            () -> new PickaxeItem(EunithiceToolTiers.PLATED_GOLD, 1, -2.8f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<AxeItem> PLATED_GOLD_AXE = ITEMS.register("plated_gold_axe",
            () -> new AxeItem(EunithiceToolTiers.PLATED_GOLD, 6.0f, -3.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HoeItem> PLATED_GOLD_HOE = ITEMS.register("plated_gold_hoe",
            () -> new HoeItem(EunithiceToolTiers.PLATED_GOLD, -3, 0.0f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<SwordItem> PLATED_GOLD_SWORD = ITEMS.register("plated_gold_sword",
            () -> new SwordItem(EunithiceToolTiers.PLATED_GOLD, 3, -2.4f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ShovelItem> FRAGMENTED_SHOVEL = ITEMS.register("fragmented_shovel",
            () -> new ShovelItem(EunithiceToolTiers.DIAMOND_FRAGMENT, 1.5f, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<PickaxeItem> FRAGMENTED_PICKAXE = ITEMS.register("fragmented_pickaxe",
            () -> new PickaxeItem(EunithiceToolTiers.DIAMOND_FRAGMENT, 1, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<AxeItem> FRAGMENTED_AXE = ITEMS.register("fragmented_axe",
            () -> new AxeItem(EunithiceToolTiers.DIAMOND_FRAGMENT, 6.2f, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HoeItem> FRAGMENTED_HOE = ITEMS.register("fragmented_hoe",
            () -> new HoeItem(EunithiceToolTiers.DIAMOND_FRAGMENT, -3, 0.2f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<SwordItem> FRAGMENTED_SWORD = ITEMS.register("fragmented_sword",
            () -> new SwordItem(EunithiceToolTiers.DIAMOND_FRAGMENT, 3, -2f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ShovelItem> PLATED_DIAMOND_SHOVEL = ITEMS.register("plated_diamond_shovel",
            () -> new ShovelItem(EunithiceToolTiers.PLATED_DIAMOND, 1.5f, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<PickaxeItem> PLATED_DIAMOND_PICKAXE = ITEMS.register("plated_diamond_pickaxe",
            () -> new PickaxeItem(EunithiceToolTiers.PLATED_DIAMOND, 1, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<AxeItem> PLATED_DIAMOND_AXE = ITEMS.register("plated_diamond_axe",
            () -> new AxeItem(EunithiceToolTiers.PLATED_DIAMOND, 6.2f, -2.6f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<HoeItem> PLATED_DIAMOND_HOE = ITEMS.register("plated_diamond_hoe",
            () -> new HoeItem(EunithiceToolTiers.PLATED_DIAMOND, -3, 0.2f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<SwordItem> PLATED_DIAMOND_SWORD = ITEMS.register("plated_diamond_sword",
            () -> new SwordItem(EunithiceToolTiers.PLATED_DIAMOND, 3, -2f, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    ///////////////////////////////////////////////////////
    ////////////// Armor
    ///////////////////////////////////////////////////////

    public static final RegistryObject<ArmorItem> PLATED_IRON_HELMET = ITEMS.register("plated_iron_helmet",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_IRON, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_IRON_CHESTPLATE = ITEMS.register("plated_iron_chestplate",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_IRON, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_IRON_LEGGINGS = ITEMS.register("plated_iron_leggings",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_IRON, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_IRON_BOOTS = ITEMS.register("plated_iron_boots",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_IRON, EquipmentSlot.FEET, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));



    public static final RegistryObject<ArmorItem> PLATED_GOLD_HELMET = ITEMS.register("plated_gold_helmet",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_GOLD, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_GOLD_CHESTPLATE = ITEMS.register("plated_gold_chestplate",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_GOLD, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_GOLD_LEGGINGS = ITEMS.register("plated_gold_leggings",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_GOLD, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_GOLD_BOOTS = ITEMS.register("plated_gold_boots",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_GOLD, EquipmentSlot.FEET, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));



    public static final RegistryObject<ArmorItem> FRAGMENTED_HELMET = ITEMS.register("fragmented_helmet",
            () -> new ArmorItem(EunithiceArmorMaterials.DIAMOND_FRAGMENT, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> FRAGMENTED_CHESTPLATE = ITEMS.register("fragmented_chestplate",
            () -> new ArmorItem(EunithiceArmorMaterials.DIAMOND_FRAGMENT, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> FRAGMENTED_LEGGINGS = ITEMS.register("fragmented_leggings",
            () -> new ArmorItem(EunithiceArmorMaterials.DIAMOND_FRAGMENT, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> FRAGMENTED_BOOTS = ITEMS.register("fragmented_boots",
            () -> new ArmorItem(EunithiceArmorMaterials.DIAMOND_FRAGMENT, EquipmentSlot.FEET, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));



    public static final RegistryObject<ArmorItem> PLATED_DIAMOND_HELMET = ITEMS.register("plated_diamond_helmet",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_DIAMOND, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_DIAMOND_CHESTPLATE = ITEMS.register("plated_diamond_chestplate",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_DIAMOND, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_DIAMOND_LEGGINGS = ITEMS.register("plated_diamond_leggings",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_DIAMOND, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<ArmorItem> PLATED_DIAMOND_BOOTS = ITEMS.register("plated_diamond_boots",
            () -> new ArmorItem(EunithiceArmorMaterials.PLATED_DIAMOND, EquipmentSlot.FEET, new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));


    ///////////////////////////////////////////////////////
    ////////////// Foods
    ///////////////////////////////////////////////////////

    public static final RegistryObject<Item> LEURITE_BREAD = ITEMS.register("leurite_bread",
            () -> new Item(new Item.Properties()
                    .food(EunithiceFoods.LEURITE_BREAD)
                    .rarity(Rarity.UNCOMMON)
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<MeatballSoup> MEATBALL_SOUP = ITEMS.register("meatball_soup",
            () -> new MeatballSoup(new Item.Properties()
                    .food(EunithiceFoods.MEATBALL_SOUP)
                    .rarity(Rarity.RARE)
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<VegetableSalad> VEGETABLE_SALAD = ITEMS.register("vegetable_salad",
            () -> new VegetableSalad(new Item.Properties()
                    .food(EunithiceFoods.VEGETABLE_SALAD)
                    .rarity(Rarity.RARE)
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<FruitDish> FRUIT_DISH = ITEMS.register("fruit_dish",
            () -> new FruitDish(new Item.Properties()
                    .food(EunithiceFoods.FRUIT_DISH)
                    .rarity(Rarity.RARE)
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<RevivalSandwich> REVIVAL_SANDWICH = ITEMS.register("revival_sandwich",
            () -> new RevivalSandwich(new Item.Properties()
                    .food(EunithiceFoods.REVIVAL_SANDWICH)
                    .rarity(Rarity.EPIC)
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<Item> LEURITE_GRAINS = ITEMS.register("leurite_grains",
            () -> new Item(new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

    public static final RegistryObject<BlockItem> LEURITE_SEEDS = ITEMS.register("leurite_seeds",
            () -> new BlockItem(EunithiceBlocks.LEURITE.get(), new Item.Properties()
                    .tab(Eunithice.EUNITHICE_ITEMS)));

}
