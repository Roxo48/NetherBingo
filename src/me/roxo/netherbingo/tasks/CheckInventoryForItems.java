package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamePlayerData;
import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.PlayerAchevemtn;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CheckInventoryForItems {
    private final GamerManager gamerManager;
    private Player player;

    public CheckInventoryForItems(GamerManager gamerManager, Player player) {
        this.gamerManager = gamerManager;
        this.player = player;
    }

    public void checkInventoryForItems(){
        List<PlayerAchevemtn> playerAchevemtns = new ArrayList<>();
        Bukkit.getServer().getScheduler().runTaskAsynchronously(gamerManager.getPlugin(), new Runnable() {
            @Override
            public void run() {
                
                for (PlayerAchevemtn element : PlayerAchevemtn.values()) {
                    if(player.getPlayer().getInventory().contains(element.material(player.getPlayer()))) {
                        playerAchevemtns.add(element);
                        GamePlayerData a = new GamePlayerData(player, element, gamerManager);//TODO make this have int he gamger maager
                        a.setItemAchieved(player.getPlayer(), element.material(player.getPlayer()));
                }
            }
            }
        });


    }



}
