package com.groupzts.customstory.common.text;

import com.groupzts.customstory.api.IText;

public class SecondaryText implements IText {
    private final String text;
    private final int color;
    private final boolean isBold;
    private final boolean isItalic;
    private final boolean isUnderline;

    public SecondaryText(String text, int color, boolean isBold, boolean isItalic, boolean isUnderline) {
        this.text = text;
        this.color = color;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.isUnderline = isUnderline;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public int color() {
        return color;
    }

    @Override
    public boolean isBold() {
        return isBold;
    }

    @Override
    public boolean isItalic() {
        return isItalic;
    }

    @Override
    public boolean isUnderline() {
        return isUnderline;
    }
}
