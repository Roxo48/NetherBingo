package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.List;

public class GameStartingTask extends BukkitRunnable {

    private GamerManager gameManager;

    public GameStartingTask(GamerManager gameManager) {
        this.gameManager = gameManager;
    }

    private  int timer = 20;
    @Override
    public void run() {
        if (timer <= 0) {
            gameManager.setState(GameState.ACTIVE);


        }

        if (timer <= 5 || timer == 20) {
            List<Player> names = (List<Player>) Bukkit.getServer().getOnlinePlayers();
            for (Player players : names) {
                players.sendMessage(ChatColor.LIGHT_PURPLE + "Game starting in " + timer + " second" + (timer == 1 ? "" : "s") + "...");

            }
        }
        if(timer <= 3){
            List<Player> names = (List<Player>) Bukkit.getServer().getOnlinePlayers();
            for(Player players : names){
                players.playSound(players.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1,1);
                players.sendTitle("", timer+ "", 20,20,20);

            }

        }


        timer--;

    }

}
