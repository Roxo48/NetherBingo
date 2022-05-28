package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
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

        if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BLACK_GLAZED_TERRACOTTA && player.isSneaking()){
            double randX = Math.random() * 6000;
            double randZ = Math.random() * 6000;
            double rand = (Math.random() * 10);
            if(rand > 6.5){
                randX = -randX;
            } else if(rand < 3.5){
                randZ = -randZ;
            }

            Location loc = new Location(gamerManager.getWorld(), randX, 60 , randZ);
            loc.getBlock().setType(Material.PURPLE_GLAZED_TERRACOTTA);

            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 1, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 1, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 1, loc.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 1, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 1, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 1, loc.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 1, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 1, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 1, loc.getZ() - 1).getBlock().setType(Material.AIR);


            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 2, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 2, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 2, loc.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 2, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 2, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 2, loc.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 2, loc.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 2, loc.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 2, loc.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() - 1, loc.getZ() + 1).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() - 1, loc.getZ() + 0).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() + 0, loc.getY() - 1, loc.getZ() - 1).getBlock().setType(Material.OBSIDIAN);

            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() - 1, loc.getZ() + 1).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() - 1, loc.getZ() + 0).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() + 1, loc.getY() - 1, loc.getZ() - 1).getBlock().setType(Material.OBSIDIAN);

            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() - 1, loc.getZ() + 1).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() - 1, loc.getZ() + 0).getBlock().setType(Material.OBSIDIAN);
            new Location(loc.getWorld(), loc.getX() - 1, loc.getY() - 1, loc.getZ() - 1).getBlock().setType(Material.OBSIDIAN);

            player.teleport(loc);

        }
        if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PURPLE_GLAZED_TERRACOTTA && player.isSneaking()){
            Location loc = gamerManager.getPlugin().getConfig().getLocation("respawn");
            player.teleport(loc);

        }

    }

}
