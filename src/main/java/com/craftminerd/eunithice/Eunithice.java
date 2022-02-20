package com.craftminerd.eunithice;

import com.craftminerd.eunithice.block.EunithiceBlocks;
import com.craftminerd.eunithice.item.EunithiceItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Eunithice.MODID)
public class Eunithice
{
    public static final java.lang.String MODID = "eunithice";

    public static final CreativeModeTab EUNITHICE_ITEMS = new CreativeModeTab(MODID) { // itemGroup.eunithice
        @Override
        public ItemStack makeIcon() {
            return EunithiceItems.EXTRACTION_CORE.get().getDefaultInstance();
        }
    };

    public Eunithice() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        EunithiceItems.register(eventBus);
        EunithiceBlocks.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

}
