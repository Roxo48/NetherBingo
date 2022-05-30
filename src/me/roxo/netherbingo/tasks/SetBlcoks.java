package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;

public class SetBlcoks {




    private final GamerManager gamerManager;

    public SetBlcoks(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }


    public void setBlocks(){

        Location loc = gamerManager.getPlugin().getConfig().getLocation("respawn");

        ArrayList<Location> locations = new ArrayList<>();
        locations.add( new Location(loc.getWorld(), loc.getX() - 6, loc.getY() + 0, loc.getZ() + 0));
        locations.add( new Location(loc.getWorld(), loc.getX() + 6, loc.getY() + 0, loc.getZ() + 0));
        locations.add(  new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 0, loc.getZ() - 6));
        locations.add( new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 0, loc.getZ() + 6));
        new Location(loc.getWorld(), loc.getX() - 6, loc.getY() + 0, loc.getZ() + 0).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
        new Location(loc.getWorld(), loc.getX() + 6, loc.getY() + 0, loc.getZ() + 0).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
        new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 0, loc.getZ() - 6).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
        new Location(loc.getWorld(), loc.getX() + 0, loc.getY() + 0, loc.getZ() + 6).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);


        for(Location location : locations){

            new Location(location.getWorld(), location.getX() + 0, location.getY() + 1, location.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() + 0, location.getY() + 1, location.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() + 0, location.getY() + 1, location.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(location.getWorld(), location.getX() + 1, location.getY() + 1, location.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() + 1, location.getY() + 1, location.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() + 1, location.getY() + 1, location.getZ() - 1).getBlock().setType(Material.AIR);

            new Location(location.getWorld(), location.getX() - 1, location.getY() + 1, location.getZ() + 1).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() - 1, location.getY() + 1, location.getZ() + 0).getBlock().setType(Material.AIR);
            new Location(location.getWorld(), location.getX() - 1, location.getY() + 1, location.getZ() - 1).getBlock().setType(Material.AIR);

        }
    }

}
