package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.NetherBingo;
import me.roxo.netherbingo.tasks.DoTasks;
import me.roxo.netherbingo.tasks.GameStartingTask;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
    private DoTasks doTasks;
    private List<GamePlayerData> gamePlayerData = new ArrayList<>();

    public GamerManager(NetherBingo plugin) {
        this.plugin = plugin;
        this.guiManager = new GUIManager();
        this.playerManager = new PlayerManager(this);
        this.doTasks = new DoTasks(this);
        
    }

    public  void setState(GameState state){
        this.state = state;

        switch (state){
            case STARTING:
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(new Location(Bukkit.getWorlds().get(0), 0,60,0));
                    allPlayersInGame.add(p);
                    p.setInvulnerable(true);
                    p.setGameMode(GameMode.ADVENTURE);
                    gamePlayerData.put(p, new PlayerAchevemtn, this);


                }
                this.gameStartingTask =  new GameStartingTask(this);
                this.gameStartingTask.runTaskTimer(plugin,0,20);

                break;
            case ACTIVE:
                if(this.gameStartingTask != null){this.gameStartingTask.cancel();}
                this.gameStartingTask = null;

                for(Player p : allPlayersInGame) {
                    playerManager.setPlaying(p);
                    p.setInvulnerable(false);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Objects.requireNonNull(plugin.getConfig().getLocation("respawn")));
                }
                doTasks.doTasks();



                break;
            case WON:

                //if the player has the most object then they win!!!


                break;
            case RESET:
                //honestly idk what would go here maybe world restet or nther restet.

                break;




        }


    }
    public ArrayList<GamePlayerData> getGamePlayerData(){
        return gamePlayerData;
    }
    public DoTasks getDoTasks(){return doTasks;}
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
