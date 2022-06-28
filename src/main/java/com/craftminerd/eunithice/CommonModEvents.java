package com.craftminerd.eunithice;

import com.craftminerd.eunithice.block.EunithiceBlocks;

import com.craftminerd.eunithice.screen.EunithiceMenuTypes;
import com.craftminerd.eunithice.screen.WorkStationScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Eunithice.MODID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(EunithiceBlocks.IRON_PLATE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(EunithiceBlocks.IRON_PLATE_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(EunithiceBlocks.LEURITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(EunithiceBlocks.WORK_STATION.get(), RenderType.translucent());

        MenuScreens.register(EunithiceMenuTypes.UPGRADE_STATION_MENU.get(), WorkStationScreen::new);
    }

}
