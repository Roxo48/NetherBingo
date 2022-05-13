package me.roxo.netherbingo.commands;

import me.roxo.netherbingo.NetherBingo;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetRespawnandSpawnCommand implements CommandExecutor {
    private final NetherBingo plugin;

    public SetRespawnandSpawnCommand(NetherBingo plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;
            //if(player.hasPermission("spiritwars.generatorspawn")) {
            Location location = player.getLocation();
            if (!commandSender.isOp()) return true;
            plugin.getConfig().set("respawn", location);
            player.sendMessage("you have set SetRespawnandSpawnCommand");


            // }else{player.sendMessage("you dont have perms");}


            return true;
        }
        return false;
    }
}
