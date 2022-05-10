package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.NetherBingo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Optional;

public class GamerManager {

    private final NetherBingo plugin;
    private GameState state;
    private Player player;

    public GamerManager(NetherBingo plugin) {
        this.plugin = plugin;

    }

    public  void setState(GameState state){
        this.state = state;

        switch (state){
            case LOBBY:


                break;
            case ACTIVE:


                break;
            case WON:


                break;
            case RESET:

                break;




        }


    }

    public ArrayList<Player> getPlayer(){
        ArrayList<Player> playerArryaList = new ArrayList<Player>(Bukkit.getServer().getOnlinePlayers());

        return playerArryaList;
    }








}
