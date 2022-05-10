package me.roxo.netherbingo.commands;

import me.roxo.netherbingo.NetherBingo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class OpenGui implements CommandExecutor, SetCommands {
    public OpenGui(NetherBingo netherBingo) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
