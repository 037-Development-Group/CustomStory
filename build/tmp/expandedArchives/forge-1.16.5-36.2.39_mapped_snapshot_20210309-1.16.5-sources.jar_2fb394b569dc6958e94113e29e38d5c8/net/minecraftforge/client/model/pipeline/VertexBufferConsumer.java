/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.client.model.pipeline;

import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.Direction;

/**
 * Assumes VertexFormatElement is present in the BufferBuilder's vertex format.
 */
public class VertexBufferConsumer implements IVertexConsumer
{
    private IVertexBuilder renderer;

    public VertexBufferConsumer() {}

    public VertexBufferConsumer(IVertexBuilder buffer)
    {
        setBuffer(buffer);
    }

    @Override
    public final VertexFormat getVertexFormat()
    {
        return DefaultVertexFormats.BLOCK;
    }

    @Override
    public void put(int e, float... data)
    {
        final float d0 = data.length <= 0 ? 0 : data[0];
        final float d1 = data.length <= 1 ? 0 : data[1];
        final float d2 = data.length <= 2 ? 0 : data[2];
        final float d3 = data.length <= 3 ? 0 : data[3];

        switch (e)
        {
        case 0: // POSITION_3F
            renderer.pos(d0, d1, d2);
            break;
        case 4: // NORMAL_3B
            renderer.normal(d0, d1, d2);
            break;
        case 1: // COLOR_4UB
            renderer.color(d0, d1, d2, d3);
            break;
        case 2: // TEX_2F
            renderer.tex(d0, d1);
            break;
        case 3: // TEX_2SB
            renderer.lightmap((int) (d0 * 0xF0), (int) (d1 * 0xF0));
            break;
        case 5: // PADDING_1B
            break;
        default:
            throw new IllegalArgumentException("Vertex element out of bounds: " + e);
        }
        if(e == 5)
        {
            renderer.endVertex();
        }
    }

    public void setBuffer(IVertexBuilder buffer)
    {
        this.renderer = buffer;
    }

    @Override
    public void setQuadTint(int tint) {}
    @Override
    public void setQuadOrientation(Direction orientation) {}
    @Override
    public void setApplyDiffuseLighting(boolean diffuse) {}
    @Override
    public void setTexture(TextureAtlasSprite texture ) {}
}
