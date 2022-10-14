package com.groupzts.customstory.api.stub;

import com.groupzts.customstory.api.CustomStoryAPI;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class StubCustomStoryAPI implements CustomStoryAPI.ICustomStoryAPI {
    public static final StubCustomStoryAPI INSTANCE = new StubCustomStoryAPI();
    @Override
    public void plotTrigger(ResourceLocation plot) {

    }

    @Override
    public ResourceLocation getPlot() {
        return null;
    }
}
