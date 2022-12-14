/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.fml.event.lifecycle;

import net.minecraftforge.fml.ModContainer;

import java.util.function.Consumer;

/**
 * This is the first of four commonly called events during mod initialization.
 *
 * Called before {@link FMLClientSetupEvent} or {@link FMLDedicatedServerSetupEvent} during mod startup.
 *
 * Called after {@link net.minecraftforge.event.RegistryEvent.Register} events have been fired.
 *
 * Either register your listener using {@link net.minecraftforge.fml.AutomaticEventSubscriber} and
 * {@link net.minecraftforge.eventbus.api.SubscribeEvent} or
 * {@link net.minecraftforge.eventbus.api.IEventBus#addListener(Consumer)} in your constructor.
 *
 * Most non-specific mod setup will be performed here. Note that this is a parallel dispatched event - you cannot
 * interact with game state in this event.
 *
 * @see net.minecraftforge.fml.DeferredWorkQueue to enqueue work to run on the main game thread after this event has
 * completed dispatch
 */
public class FMLCommonSetupEvent extends ParallelDispatchEvent
{
    public FMLCommonSetupEvent(final ModContainer container)
    {
        super(container);
    }
}
