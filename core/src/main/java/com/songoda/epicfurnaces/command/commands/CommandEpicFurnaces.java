package com.songoda.epicfurnaces.command.commands;

import com.songoda.arconix.api.methods.formatting.TextComponent;
import com.songoda.epicfurnaces.EpicFurnaces;
import com.songoda.epicfurnaces.command.AbstractCommand;
import org.bukkit.command.CommandSender;

public class CommandEpicFurnaces extends AbstractCommand {
    private final EpicFurnaces instance;

    public CommandEpicFurnaces(EpicFurnaces instance) {
        super("EpicFurnaces", null, false);
        this.instance = instance;

    }

    @Override
    protected ReturnType runCommand(CommandSender sender, String... args) {
        sender.sendMessage("");
        sender.sendMessage(TextComponent.formatText(instance.getReferences().getPrefix() + "&7Version " + instance.getDescription().getVersion() + " Created with <3 by &5&l&oBrianna"));

        for (AbstractCommand command : instance.getCommandManager().getCommands()) {
            if (command.getPermissionNode() == null || sender.hasPermission(command.getPermissionNode())) {
                sender.sendMessage(TextComponent.formatText("&8 - &a" + command.getSyntax() + "&7 - " + command.getDescription()));
            }
        }
        sender.sendMessage("");

        return ReturnType.SUCCESS;
    }

    @Override
    public String getDescription() {
        return "Displays this page.";
    }

    @Override
    public String getPermissionNode() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/EpicFurnaces";
    }
}
