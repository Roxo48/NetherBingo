package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.tasks.CheckInventoryForItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamePlayerData {

//this is Island in spiritwars
private final GamerManager gameManager;

    private Player player;
    private ArrayList<Player> players = new ArrayList<>();
    private Map<PlayerAchevemtn,Boolean> playerAchievementBooleanMap = new HashMap<PlayerAchevemtn,Boolean>();

    public GamePlayerData(Player player, GamerManager gameManager){
        this.player = player;
        for(Player player1 : players){
            if(player == player1){break;}

        }

        this.gameManager = gameManager;
    }



    public boolean isItemAchieved(Player player, PlayerAchevemtn material){
        //for (Map.Entry<String, Integer> me :
            //    hm.entrySet()) {
                try {
                    if (playerAchievementBooleanMap.get(material)) {//TODO probbaly majke it returen treoo if it is the boolean treee.
                        return true;

                    }
                }catch (Exception e){return false;}

        return false;
    }
    public boolean setItemAchieved(Player player, PlayerAchevemtn material){

                    playerAchievementBooleanMap.put(material,true);




        return false;
    }
    public Player getPlayer(){
        return player;
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public Map<PlayerAchevemtn,Boolean> getPlayerAchievementBooleanMap(){return  playerAchievementBooleanMap;}

}
