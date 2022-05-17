package me.roxo.netherbingo.commands;

import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;



public class StartCommand implements CommandExecutor, SetCommands {

    private final GamerManager gamerManager;

    public StartCommand(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;
            //if(player.hasPermission("spiritwars.generatorspawn")) {
            Location location = player.getLocation();
            if (!commandSender.isOp()) return true;

            gamerManager.setState(GameState.STARTING);


            // }else{player.sendMessage("you dont have perms");}


            return true;
        }



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
