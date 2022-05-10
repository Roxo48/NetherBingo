package me.roxo.netherbingo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface SetCommands {

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings);

    public String getName();

    public String getAuthor();

    public String getInfo();
}

