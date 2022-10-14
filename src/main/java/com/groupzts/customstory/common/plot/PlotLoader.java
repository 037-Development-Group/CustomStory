package com.groupzts.customstory.common.plot;

import com.google.gson.Gson;
import com.groupzts.customstory.client.event.CommandEventHandler;
import com.groupzts.customstory.common.Trigger;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PlotLoader {
    public static final Plot PLOT = new Plot();
    public static final Gson GSON = new Gson();
    public static final String CONNECT = PLOT.getFileContent("customstory_plot/plot.json");

    public static final Plot FROM_JSON = GSON.fromJson(CONNECT, Plot.class);

    public static void loadPlot() throws IOException {
        Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/" + "customstory_plot"));
    }
    @Nullable
    public static Trigger getTrigger() throws IOException {
        if (FROM_JSON.getTriggers() != null) {
            int length1 = FROM_JSON.getTriggers().toArray(new Trigger[0]).length;
            for (int length = length1; length > 1; length--) {
                Trigger trigger = FROM_JSON.getTriggers().get(length);
                if(trigger.getConditionType(trigger.getCondition()) == Trigger.ConditionType.COMMAND) {
                    CommandEventHandler.canUseCommand = true;
                    return trigger;
                }
            }
        }
        return null;
    }

    @Nullable
    public static ResourceLocation getCustomBackground(String color){
        switch (color) {
            case "black":
                return Plot.BLACK_BACKGROUND_IMAGE;
            case "white":
                return Plot.WHITE_BACKGROUND_IMAGE;
            case "red":
                return Plot.RED_BACKGROUND_IMAGE;
            case "green":
                return Plot.GREEN_BACKGROUND_IMAGE;
            case "blue":
                return Plot.BLUE_BACKGROUND_IMAGE;
            case "yellow":
                return Plot.YELLOW_BACKGROUND_IMAGE;
        }
        return null;
    }
}
