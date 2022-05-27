package me.roxo.netherbingo.managers;

import me.roxo.netherbingo.NetherBingo;
import me.roxo.netherbingo.tasks.DoTasks;
import me.roxo.netherbingo.tasks.GameStartingTask;
import me.roxo.netherbingo.tasks.QuickSort;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.*;

public class GamerManager {

    private final NetherBingo plugin;
    private GameState state;
    private Player player;
    private PlayerManager playerManager;
    private GameStartingTask gameStartingTask;
    public List<Player> allPlayersInGame = new ArrayList<>();
    private GUIManager guiManager;
    private DoTasks doTasks;
    private ArrayList<GamePlayerData> gamePlayerData = new ArrayList<>();


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
                    GamePlayerData b = new GamePlayerData(p, this);
                    gamePlayerData.add(b);


                }
                this.gameStartingTask =  new GameStartingTask(this);
                this.gameStartingTask.runTaskTimer(plugin,0,20);

                break;
            case ACTIVE:
                doTasks.Timer();
                Location loc = plugin.getConfig().getLocation("respawn");
                if(this.gameStartingTask != null){this.gameStartingTask.cancel();}
                this.gameStartingTask = null;

                for(Player p : allPlayersInGame) {
                    playerManager.setPlaying(p);
                    p.setInvulnerable(false);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Objects.requireNonNull(plugin.getConfig().getLocation("respawn")));
                }

                    loc.getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
//                loc.add(-4,loc.getY(),4).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
//                loc.add(4,loc.getY(),-4).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
//                loc.add(-4,loc.getY(),-4).getBlock().setType(Material.BLACK_GLAZED_TERRACOTTA);
                doTasks.doTasks();



                break;
            case WON:
                for(Player p : allPlayersInGame) {
                    p.teleport(new Location(Bukkit.getWorlds().get(0), 0,60,0));
                    p.setInvulnerable(true);
                    p.setGameMode(GameMode.ADVENTURE);
                }

                Player player = null;
                Map<Player, Integer> playerIntegerMap = new HashMap<>();
                for(GamePlayerData playerData : gamePlayerData){
                    int count = 0;
                    for(PlayerAchevemtn element : PlayerAchevemtn.values()){
                        if(playerData.isItemAchieved(playerData.getPlayer(), element)) {
                            count++;
                         }
                        }
                        playerIntegerMap.put(playerData.getPlayer(), count);
                    }

                ArrayList<Integer> quick = (ArrayList<Integer>) playerIntegerMap.values();
                int[] a = new int[quick.size()];
                for(int i = 0; i < quick.size(); i++){
                    a[i] = quick.get(i);
                }

                QuickSort quickSort = new QuickSort();
                quickSort.quickSort(a, 0, a.length);
                for(Map.Entry<Player, Integer> me : playerIntegerMap.entrySet()){
                    if(me.getValue() == a[a.length-1]){
                        player = me.getKey();
                    }
                }
                try{
                    Bukkit.broadcastMessage( ChatColor.LIGHT_PURPLE + "Player... " + player.getName() + " Won!!!" + " Thanks for Playing!!");

                }catch (Exception e){
                    Bukkit.broadcastMessage( ChatColor.LIGHT_PURPLE + "THIS IS AN ERROR. IDK WHAT THE ERROR IS " + "this is the error " + e.getLocalizedMessage());
                    e.printStackTrace();
                }
                setState(GameState.RESET);


                break;
            case RESET:
               for(Player player1 : allPlayersInGame){
                   player1.kickPlayer("BYE PLAY AGAIN... make by roxo");
               }
               allPlayersInGame.clear();
               Bukkit.getServer().reload();
                //honestly idk what would go here maybe world restet or nther restet.

                break;




        }


    }
    public ArrayList<GamePlayerData> getGamePlayerData(){
        return gamePlayerData;
    }
    public World getWorld(){return Bukkit.getServer().getWorlds().get(1);}
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
