package com.groupzts.customstory.client.event;

import com.groupzts.customstory.common.Trigger;
import com.groupzts.customstory.common.command.CustomCommand;
import com.groupzts.customstory.common.plot.Plot;
import com.groupzts.customstory.common.plot.PlotLoader;
import com.groupzts.customstory.utils.Reference;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;

@Mod.EventBusSubscriber
public class CommandEventHandler {
    public static boolean canUseCommand = false;

    @SubscribeEvent
    public static void onServerStaring(RegisterCommandsEvent event) throws IOException {
            if (PlotLoader.getTrigger() != null) {
                if(canUseCommand) {
                    final String COMMAND = PlotLoader.getTrigger().getCommand();
                    if (COMMAND == null) {
                        return;
                    }
                    CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
                    LiteralCommandNode<CommandSource> cmd = dispatcher.register(
                            Commands.literal(Reference.MOD_ID).then(
                                    Commands.literal(COMMAND)
                                            .requires((commandSource) -> commandSource.hasPermissionLevel(0))
                                            .executes(CustomCommand.instance)
                            )
                    );
                    dispatcher.register(Commands.literal("bs").redirect(cmd));
                }
            }
        }
}