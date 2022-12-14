/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.client.event;

import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Fired on the client when a chat message is received.<br>
 * If this event is cancelled, the message is not displayed in the chat message window.<br>
 * Fired on {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}.
 */
@Cancelable
public class ClientChatReceivedEvent extends Event
{
    private ITextComponent message;
    private final ChatType type;
    @Nullable
    private final UUID senderUUID;

    public ClientChatReceivedEvent(ChatType type, ITextComponent message, @Nullable UUID senderUUID)
    {
        this.type = type;
        this.message = message;
        this.senderUUID = senderUUID;
    }

    public ITextComponent getMessage()
    {
        return message;
    }

    public void setMessage(ITextComponent message)
    {
        this.message = message;
    }

    public ChatType getType()
    {
        return type;
    }

    /**
     * The UUID of the player or entity that sent this message, or null if not known.
     * This will be equal to {@link net.minecraft.util.Util#DUMMY_UUID} for system messages.
     */
    @Nullable
    public UUID getSenderUUID()
    {
        return senderUUID;
    }
}
