package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.tasks.CheckInventoryForItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GamePlayerData {

//this is Island in spiritwars
private final GamerManager gameManager;
    private  PlayerAchevemtn playerAchevemtn;
    private Player player;
    private Map<PlayerAchevemtn,Boolean> playerAchievementBooleanMap = new HashMap<PlayerAchevemtn,Boolean>();

    public GamePlayerData(Player player, PlayerAchevemtn playerAchevemtn, GamerManager gameManager){
        this.player = player;
        this.playerAchevemtn = playerAchevemtn;
        this.gameManager = gameManager;
    }

    public PlayerAchevemtn getPlayerAchevemtn() {
        return playerAchevemtn;
    }

    public boolean isItemAchieved(Player player, Material material){
        //for (Map.Entry<String, Integer> me :
            //    hm.entrySet()) {
            for(Map.Entry<PlayerAchevemtn,Boolean> me : playerAchievementBooleanMap.entrySet()){
                if(material == me.getKey().material(player)){
                    return true;
                }
            }
        return false;
    }
    public boolean setItemAchieved(Player player, Material material){
            for(PlayerAchevemtn element : PlayerAchevemtn.values()){
                if(material == element.material(player.getPlayer())) {
                    playerAchievementBooleanMap.put(element,true);

                }
            }


        return false;
    }
    public Player getPlayer(){
        return player;
    }
}
