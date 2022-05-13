package me.roxo.netherbingo.managers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

public class PlayerManager implements Listener {


    private UUID uuid;

    private boolean ingame;

    private int coinsearned;

    private boolean isdead;//TODO this mean the player has deid three times

    private boolean hasAllAchements;

    private  final GamerManager gameManager;

    //TODO also what ever player mangaer like invantory and guis that stuff.

    public PlayerManager(GamerManager gameManager){
        this.uuid = uuid;
        this.ingame = ingame;
        this.coinsearned = coinsearned;
        this.isdead = isdead;



        this.gameManager = gameManager;
    }




    public void setPlaying(Player playing){
        playing.getInventory().clear();
        playing.setGameMode(GameMode.SURVIVAL);
        //this is where you put the gui amke



    }





    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isIngame() {
        return ingame;
    }

    public void setIngame(boolean ingame) {
        this.ingame = ingame;
    }

    public int getCoinsearned() {
        return coinsearned;
    }

    public void setCoinsearned(int coinsearned) {
        this.coinsearned = coinsearned;
    }

    public boolean isIsdead() {
        return isdead;
    }

    public void setIsdead(boolean isdead) {
        this.isdead = isdead;
    }
}
