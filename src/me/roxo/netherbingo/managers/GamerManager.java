package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.NetherBingo;
import me.roxo.netherbingo.tasks.GameStartingTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GamerManager {

    private final NetherBingo plugin;
    private GameState state;
    private Player player;
    private PlayerManager playerManager;
    private GameStartingTask gameStartingTask;
    public List<Player> allPlayersInGame = new ArrayList<>();
    private GUIManager guiManager;


    public GamerManager(NetherBingo plugin) {
        this.plugin = plugin;
        this.guiManager = new GUIManager();
        this.playerManager = new PlayerManager(this);

    }

    public  void setState(GameState state){
        this.state = state;

        switch (state){
            case STARTING:
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(new Location(Bukkit.getWorlds().get(0), 0,60,0));
                    allPlayersInGame.add(p);


                }
                this.gameStartingTask =  new GameStartingTask(this);
                this.gameStartingTask.runTaskTimer(plugin,0,20);

                break;
            case ACTIVE:
                if(this.gameStartingTask != null){this.gameStartingTask.cancel();}
                this.gameStartingTask = null;

                for(Player p : allPlayersInGame) {
                    playerManager.setPlaying(p);
                    p.teleport(Objects.requireNonNull(plugin.getConfig().getLocation("respawn")));
                }



                break;
            case WON:


                break;
            case RESET:

                break;




        }


    }
    public NetherBingo getPlugin(){
        return plugin;
    }
    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public ArrayList<Player> getPlayer(){
        ArrayList<Player> playerArryaList = new ArrayList<Player>(Bukkit.getServer().getOnlinePlayers());

        return playerArryaList;
    }
    public GameState getState(){
        return state;
    }
    public GUIManager getGuiManager() {
        return guiManager;
    }


    public PlayerAchevemtn[] getItems() {
        return PlayerAchevemtn.values();
    }
}
