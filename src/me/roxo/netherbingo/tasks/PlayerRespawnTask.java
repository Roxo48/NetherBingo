package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.ItemsData;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerRespawnTask implements Runnable{

    private Player player;
    private ItemsData playerislasnd;
    private final GamerManager gameManager;


    public PlayerRespawnTask(Player player, GamerManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;




    }

    private int tick = 0;
    @Override
    public void run() {
        if(tick == 5){
            player.sendTitle( "Respawned", "",20,20,20);
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(gameManager.getPlugin().getConfig().getLocation("respawn"));
            return;

        }
        player.sendTitle("You Died","Respawning in" + (5-tick) + "...", (tick==0?20:0),20,0);
        tick++;



    }
}
