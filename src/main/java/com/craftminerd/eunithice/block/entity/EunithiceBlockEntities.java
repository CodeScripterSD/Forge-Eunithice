package com.craftminerd.eunithice.block.entity;

import com.craftminerd.eunithice.Eunithice;
import com.craftminerd.eunithice.block.EunithiceBlocks;
import com.craftminerd.eunithice.block.entity.custom.WorkStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EunithiceBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Eunithice.MODID);

    public static final RegistryObject<BlockEntityType<WorkStationBlockEntity>> WORK_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("work_station_block_entity", ()->
                    BlockEntityType.Builder.of(WorkStationBlockEntity::new, EunithiceBlocks.WORK_STATION.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
