package com.craftminerd.eunithice.block;

import com.craftminerd.eunithice.Eunithice;
import com.craftminerd.eunithice.block.custom.*;
import com.craftminerd.eunithice.item.EunithiceItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EunithiceBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Eunithice.MODID);

    // WEIRD SHIT THAT I DON'T UNDERSTAND

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return EunithiceItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    // ACTUAL BLOCKS

    public static final RegistryObject<Block> JUMP_IMBUED_ASPHALT = registerBlock("jump_imbued_asphalt",
            () -> new JumpImbuedAsphalt(BlockBehaviour.Properties
                    .of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(0.3f, 20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> SPEED_IMBUED_ASPHALT = registerBlock("speed_imbued_asphalt",
            () -> new SpeedImbuedAsphalt(BlockBehaviour.Properties
                    .of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(0.3f, 20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> SPEED_IMBUED_SAND = registerBlock("speed_imbued_sand",
            () -> new SpeedImbuedSand(1, BlockBehaviour.Properties
                    .of(Material.SAND, MaterialColor.COLOR_BLACK)
                    .strength(0.3f, 15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SAND)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> HONEY_IMBUED_ASPHALT = registerBlock("honey_imbued_asphalt",
            () -> new HoneyImbuedAsphalt(BlockBehaviour.Properties
                    .of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(0.3f, 20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> IRON_PLATE_BLOCK = registerBlock("iron_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.RAW_IRON)
                    .strength(20f, 10f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> DENSE_IRON_PLATE_BLOCK = registerBlock("dense_iron_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.RAW_IRON)
                    .strength(23f,20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> SUPER_DENSE_IRON_PLATE_BLOCK = registerBlock("super_dense_iron_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.RAW_IRON)
                    .strength(23f,50f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> GOLD_PLATE_BLOCK = registerBlock("gold_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.GOLD)
                    .strength(23f, 14f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> DENSE_GOLD_PLATE_BLOCK = registerBlock("dense_gold_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.GOLD)
                    .strength(25f,23f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> SUPER_DENSE_GOLD_PLATE_BLOCK = registerBlock("super_dense_gold_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.GOLD)
                    .strength(25f,55f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);



    public static final RegistryObject<Block> DIAMOND_PLATE_BLOCK = registerBlock("diamond_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.DIAMOND)
                    .strength(25f, 30f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> DENSE_DIAMOND_PLATE_BLOCK = registerBlock("dense_diamond_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.DIAMOND)
                    .strength(30f,50f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> SUPER_DENSE_DIAMOND_PLATE_BLOCK = registerBlock("super_dense_diamond_plate_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.DIAMOND)
                    .strength(30f,80f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);



    public static final RegistryObject<Block> IRON_PLATE_DOOR = registerBlock("iron_plate_door",
            () -> new DoorBlock(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.RAW_IRON)
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);

    public static final RegistryObject<Block> IRON_PLATE_TRAPDOOR = registerBlock("iron_plate_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.RAW_IRON)
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.METAL)),
            Eunithice.EUNITHICE_ITEMS);



    public static final RegistryObject<Block> LEURITE = BLOCKS.register("leurite_crop",
            () -> new LeuriteCrop(BlockBehaviour.Properties
                    .copy(net.minecraft.world.level.block.Blocks.WHEAT)));
}
