package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.NetherBingo;
import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.ItemsData;
import me.roxo.netherbingo.tasks.PlayerRespawnTask;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitTask;

public class OnDeath implements Listener {

    private final NetherBingo plugin;

    public OnDeath(NetherBingo plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(plugin.getGameManager().getState() != GameState.ACTIVE){e.setCancelled(true);return;}
        if(!(e.getEntity() instanceof Player)) {
            if(e.getEntity() instanceof Villager){
                e.setCancelled(true);
            }
            return;
        }
        Player player =(Player) e.getEntity();
        if( player.getGameMode() != GameMode.SURVIVAL){
            e.setCancelled(true);
            return;
        }


        if(e.getFinalDamage() >=player.getHealth()){
            e.setCancelled(true);
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            player.setGameMode(GameMode.SPECTATOR);


                player.sendTitle("You Died", "Respawning in 5...", 20, 20, 20);
                BukkitTask task = Bukkit.getServer().getScheduler().runTaskTimer(plugin,new PlayerRespawnTask(player, plugin.getGameManager()),0, 20);
                Bukkit.getServer().getScheduler().runTaskLater(plugin, task::cancel,20*6);




        }

    }
}
