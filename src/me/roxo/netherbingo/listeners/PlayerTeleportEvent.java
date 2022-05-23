package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerTeleportEvent implements Listener {

    final private GamerManager gamerManager;

    public PlayerTeleportEvent(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }

    @EventHandler
    public void onTeleport(PlayerToggleSneakEvent e){
        Player player = e.getPlayer();

        if(player.getLocation().getBlock().getType() == Material.BLACK_GLAZED_TERRACOTTA && player.isSneaking()){
            double randX = Math.random() * 6000;
            double randZ = Math.random() * 6000;
            Location loc = new Location(gamerManager.getWorld(), randX, 60 , randZ);
            loc.getBlock().setType(Material.OBSIDIAN);
            loc.add(1,60,1).getBlock().setType(Material.PURPLE_GLAZED_TERRACOTTA);
            loc.add(1,60,-1).getBlock().setType(Material.OBSIDIAN);
            loc.add(-1,60,1).getBlock().setType(Material.OBSIDIAN);
            loc.add(-1,60,-1).getBlock().setType(Material.OBSIDIAN);
            loc.add(1,60,2).getBlock().setType(Material.OBSIDIAN);
            loc.add(1,60,-2).getBlock().setType(Material.OBSIDIAN);
            loc.add(-1,60,2).getBlock().setType(Material.OBSIDIAN);
            loc.add(-1,60,-2).getBlock().setType(Material.OBSIDIAN);
            player.teleport(loc);


        }
        if(player.getLocation().getBlock().getType() == Material.PURPLE_GLAZED_TERRACOTTA && player.isSneaking()){
            Location loc = gamerManager.getPlugin().getConfig().getLocation("respawn");
            player.teleport(loc);

        }

    }

}
