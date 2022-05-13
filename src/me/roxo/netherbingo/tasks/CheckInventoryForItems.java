package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.PlayerAchevemtn;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class CheckInventoryForItems {
    private final GamerManager gamerManager;
    private Player player;

    public CheckInventoryForItems(GamerManager gamerManager,Player player) {
        this.gamerManager = gamerManager;
        this.player = player;
    }

    public void checkInventoryForItems(){

        Bukkit.getServer().getScheduler().runTaskAsynchronously(gamerManager.getPlugin(), new Runnable() {
            @Override
            public void run() {

                for (PlayerAchevemtn element : PlayerAchevemtn.values()) {
                    if (player.getInventory().contains(element.material(player))) {
                        //TODO this check so return or give some a value like boolean if a player has got this item.



                }
            }




            }
        });



    }



}
