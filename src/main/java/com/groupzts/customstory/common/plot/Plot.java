package com.groupzts.customstory.common.plot;

import com.google.gson.annotations.SerializedName;
import com.groupzts.customstory.client.event.CommandEventHandler;
import com.groupzts.customstory.common.Trigger;
import com.groupzts.customstory.utils.Reference;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Plot {
    private String type;
    public String customColorBackground;
    private List<Trigger> triggers;
    protected static final ResourceLocation BLACK_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/black.png");
    protected static final ResourceLocation WHITE_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/white.png");
    protected static final ResourceLocation RED_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/red.png");
    protected static final ResourceLocation GREEN_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/green.png");
    protected static final ResourceLocation BLUE_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/blue.png");
    protected static final ResourceLocation YELLOW_BACKGROUND_IMAGE = new ResourceLocation(Reference.MOD_ID, "textures/customplot/blue.png");

    public String getFileContent(String fileName) {
        String userPath = System.getProperty("user.dir");
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(userPath + "/" + fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<Trigger> getTriggers() {
        return triggers;
    }

    @Override
    public String toString() {
        return type;
    }
}
