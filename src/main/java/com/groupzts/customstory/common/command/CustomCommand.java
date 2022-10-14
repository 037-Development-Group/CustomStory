package com.groupzts.customstory.common.command;

import com.groupzts.customstory.client.gui.DialogueGui;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;

public class CustomCommand implements Command<CommandSource> {
    public static CustomCommand instance = new CustomCommand();

    @Override
    public int run(CommandContext<CommandSource> context) {
        DialogueGui.setCanBind(true);
        return 0;
    }
}