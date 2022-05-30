package me.roxo.netherbingo.commands;

import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetTimerCommand implements CommandExecutor {

    private final GamerManager gamerManager;

    public GetTimerCommand(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;
            //if(player.hasPermission("spiritwars.generatorspawn")) {
            Location location = player.getLocation();
            if (!commandSender.isOp()) return true;
           int done = gamerManager.getDoTasks().getDone();
           int finalDone = done - 60;
            player.sendMessage("You have " + finalDone + " Minutes Left");


            // }else{player.sendMessage("you dont have perms");}


            return true;
        }
        return false;
    }
}
