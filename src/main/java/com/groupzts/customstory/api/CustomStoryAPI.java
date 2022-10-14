package com.groupzts.customstory.api;

import com.groupzts.customstory.api.stub.StubCustomStoryAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Lazy;
import org.apache.logging.log4j.LogManager;

public class CustomStoryAPI {
    public static volatile ICustomStoryAPI instance = StubCustomStoryAPI.INSTANCE;
    private static final Lazy<ICustomStoryAPI> LAZY_INSTANCE = Lazy.concurrentOf(() -> {
        try {
            ICustomStoryAPI ret = (ICustomStoryAPI) Class.forName("com.groupzts.customstory.common.base.CustomStoryAPIImpl").newInstance();
            instance = ret;
            return ret;
        } catch (ReflectiveOperationException e) {
            LogManager.getLogger().warn("Unable to find CustomStoryAPIImpl, using a dummy");
            return StubCustomStoryAPI.INSTANCE;
        }
    });
    public interface ICustomStoryAPI{
        void plotTrigger(ResourceLocation plot);
        ResourceLocation getPlot();
    }
}
