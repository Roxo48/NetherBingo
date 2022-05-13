package me.roxo.netherbingo.commands;

import me.roxo.netherbingo.NetherBingo;
import me.roxo.netherbingo.gui.PlayerAchevmentGUI;
import me.roxo.netherbingo.managers.GamePlayerData;
import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.tasks.CheckInventoryForItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenGui implements CommandExecutor, SetCommands {
    private  final NetherBingo plugin;
    public OpenGui(NetherBingo netherBingo) {
        this.plugin = netherBingo;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        if(plugin.getGameManager().getState() != GameState.ACTIVE){
            commandSender.sendMessage("Cant Access Yet");
            return false;
        }
        Player p = (Player) commandSender;

        CheckInventoryForItems a = new CheckInventoryForItems(plugin.getGameManager(), p);
        a.checkInventoryForItems();
        PlayerAchevmentGUI gui = new PlayerAchevmentGUI(p,plugin.getGameManager());
        plugin.getGameManager().getGuiManager().setGUI(p, gui);
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
