package com.mcutil.commands;

import com.mcutil.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    private final List<Command> localRegisteredCommands = new ArrayList<>();

    public boolean execute(String cmd) {
        return getCommand(cmd.split(" ")[0]).
                execute(new ArrayHelper<>(Arrays.
                        copyOfRange(cmd.
                                split(" "), 1, cmd.
                                length())));
    }

    public Command getCommand(String name) {
        return this.getLocalRegisteredCommands().stream()
                .filter(command -> command.getName()
                        .equalsIgnoreCase(name) || Arrays
                        .asList(command.getAliases())
                        .contains(name))
                .findFirst()
                .orElse(null);
    }

    public List<Command> getLocalRegisteredCommands() {
        return localRegisteredCommands;
    }
}
