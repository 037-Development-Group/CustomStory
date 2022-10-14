package com.groupzts.customstory.client.gui;

import com.groupzts.customstory.client.event.CommandEventHandler;
import com.groupzts.customstory.common.plot.Plot;
import com.groupzts.customstory.common.plot.PlotLoader;
import com.groupzts.customstory.common.text.MainText;
import com.groupzts.customstory.common.text.SecondaryText;
import com.groupzts.customstory.utils.Reference;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class DialogueGui extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private MatrixStack matrixStack;
    public static boolean canBind = false;

    public DialogueGui(MatrixStack matrixStack) {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public static void setCanBind(boolean canBind) {
        DialogueGui.canBind = canBind;
    }

    public static Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    public void render() throws IOException {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        ResourceLocation BG = PlotLoader.getCustomBackground(PlotLoader.FROM_JSON.customColorBackground);
            if (BG != PlotLoader.getCustomBackground(PlotLoader.FROM_JSON.customColorBackground) || BG == null) {
                return;
            }
            if (canBind && PlotLoader.getTrigger() != null) {
                MainText mainText = PlotLoader.getTrigger().mainText;
                SecondaryText secondaryText = PlotLoader.getTrigger().secondaryText;
                ITextComponent mainTextComp = new StringTextComponent(mainText.text()).setStyle(Style.EMPTY.setColor(Color.fromInt(mainText.color())).setBold(mainText.isBold()).setItalic(mainText.isItalic()).setUnderlined(mainText.isUnderline()));
                ITextComponent secondaryTextComp = new StringTextComponent(secondaryText.text()).setStyle(Style.EMPTY.setColor(Color.fromInt(secondaryText.color())).setBold(secondaryText.isBold()).setItalic(secondaryText.isItalic()).setUnderlined(secondaryText.isUnderline()));

                DialogueGui.getMinecraft().getTextureManager().bindTexture(BG);
                blit(matrixStack, width / 2 - 16, height / 2 - 64, 0, 0, 32, 32, 32, 32);
                this.minecraft.fontRenderer.drawText(matrixStack, mainTextComp, 20F, 20F, 0);
                this.minecraft.fontRenderer.drawText(matrixStack, secondaryTextComp, 20F, 30F, 0);
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        setCanBind(false);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 5);
        }
    }
}