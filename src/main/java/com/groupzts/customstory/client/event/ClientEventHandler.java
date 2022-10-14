package com.groupzts.customstory.client.event;

import com.groupzts.customstory.client.gui.DialogueGui;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;

public class ClientEventHandler {
    @Mod.EventBusSubscriber(value = Dist.CLIENT)
    public static class HudClientEvent {
        @SubscribeEvent
        public static void onOverlayRender(RenderGameOverlayEvent event) throws IOException {
            if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
                return;
            }
            if (Minecraft.getInstance().player == null) {
                return;
            }
            DialogueGui dialogueGui = new DialogueGui(event.getMatrixStack());
            dialogueGui.render();
        }
    }
}
