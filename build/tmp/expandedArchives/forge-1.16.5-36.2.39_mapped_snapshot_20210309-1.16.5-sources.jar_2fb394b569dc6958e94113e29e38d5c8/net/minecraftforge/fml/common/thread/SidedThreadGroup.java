/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.fml.common.thread;

import net.minecraftforge.fml.LogicalSide;

import java.util.concurrent.ThreadFactory;

import javax.annotation.Nonnull;

/**
 * A thread group and factory combination which belongs to a {@link LogicalSide}.
 */
public final class SidedThreadGroup extends ThreadGroup implements ThreadFactory
{
    private final LogicalSide side;

    SidedThreadGroup(final LogicalSide side)
    {
        super(side.name());
        this.side = side;
    }

    /**
     * Gets the side this sided thread group belongs to.
     *
     * @return the side
     */
    public LogicalSide getSide()
    {
        return this.side;
    }

    @Override
    public Thread newThread(@Nonnull final Runnable runnable)
    {
        return new Thread(this, runnable);
    }
}
