package me.roxo.netherbingo.managers;

import org.bukkit.entity.Player;

public class ItemsData {

//this is Island in spiritwars
private final GamerManager gameManager;
    private  PlayerAchevemtn playerAchevemtn;

    public ItemsData(PlayerAchevemtn playerAchevemtn, GamerManager gameManager){

        this.playerAchevemtn = playerAchevemtn;
        this.gameManager = gameManager;
    }

    //public GameMap getGameWorld(){return gameWorld;}

    public PlayerAchevemtn getPlayerAchevemtn() {
        return playerAchevemtn;
    }
    public boolean isItemAchieved(Player player){

        return false;
    }
}
