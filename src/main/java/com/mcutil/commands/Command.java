package com.mcutil.commands;

import com.mcutil.ArrayHelper;

public abstract class Command {

    private final String name, description;
    private final String[] aliases;

    public Command() {
        final CommandTarget commandTarget = this.getClass().getAnnotation(CommandTarget.class);
        this.name = commandTarget.name();
        this.description = commandTarget.description();
        this.aliases = commandTarget.aliases();
    }

    public abstract boolean execute(ArrayHelper<String> arrayHelper);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAliases() {
        return aliases;
    }
}
