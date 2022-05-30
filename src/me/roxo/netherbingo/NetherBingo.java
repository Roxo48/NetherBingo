package me.roxo.netherbingo;

import me.roxo.netherbingo.commands.OpenGui;
import me.roxo.netherbingo.commands.SetRespawnandSpawnCommand;
import me.roxo.netherbingo.commands.StartCommand;
import me.roxo.netherbingo.listeners.OnDeath;
import me.roxo.netherbingo.listeners.PlayerItemInteractListener;
import me.roxo.netherbingo.listeners.PlayerTeleportEvent;
import me.roxo.netherbingo.listeners.onJoin;
import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.tasks.PvP;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherBingo extends JavaPlugin {

    private GamerManager gameManager;

    @Override
    public void onEnable(){
        this.gameManager = new GamerManager(this);
        getCommand("board ").setExecutor(new OpenGui(this));
        getCommand("setbingospawn").setExecutor(new SetRespawnandSpawnCommand(this));
        getCommand("startgame").setExecutor(new StartCommand(gameManager));
        getServer().getPluginManager().registerEvents(new PvP(gameManager),this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportEvent(gameManager),this);
        getServer().getPluginManager().registerEvents(new onJoin(gameManager),this);
        getServer().getPluginManager().registerEvents(new PlayerItemInteractListener(gameManager),this);
        getServer().getPluginManager().registerEvents(new OnDeath(this),this);



    }
    @Override
    public void onDisable(){



    }
    public GamerManager getGameManager(){
        return gameManager;
    }


}
