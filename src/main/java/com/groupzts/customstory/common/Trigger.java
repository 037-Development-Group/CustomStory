package com.groupzts.customstory.common;

import com.groupzts.customstory.client.event.CommandEventHandler;
import com.groupzts.customstory.common.text.MainText;
import com.groupzts.customstory.common.text.SecondaryText;

import javax.annotation.Nullable;
import java.io.IOException;

@Nullable
public class Trigger {

    private String condition;
    public MainText mainText;
    public SecondaryText secondaryText;
    private String command;

    public ConditionType getConditionType(String condition) throws IOException {
        if(condition.equals("command")){
            return ConditionType.COMMAND;
        }
        else if (condition.equals("kill_a_entity")) {
            return ConditionType.KILL_A_ENTITY;
        }
        else {
            throw new IOException("Condition type mismatch");
        }
    }

    @Nullable
    public String getCommand() {
        if(CommandEventHandler.canUseCommand) {
            return command;
        }
        return null;
    }

    public String getCondition() {
        return condition;
    }

    public enum ConditionType{
        COMMAND,
        KILL_A_ENTITY,
    }
}
