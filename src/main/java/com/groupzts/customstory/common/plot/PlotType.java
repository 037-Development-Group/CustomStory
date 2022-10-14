package com.groupzts.customstory.common.plot;

/**
 * @author LEFT_Flamelight
 * &#064;DIALOGUE It is a simple dialogue in the form of general subtitles, supporting i18n and custom style
 * &#064;SCENE Functions equivalent to the transition pictures
 */
public enum PlotType {
    DIALOGUE,
    SCENE;
    public static final PlotType[] VALUE = {DIALOGUE, SCENE};
    public boolean isDialogue(){
        return this == DIALOGUE;
    }
    public boolean isScene(){
        return this == SCENE;
    }
}
