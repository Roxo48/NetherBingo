package me.roxo.netherbingo;

import me.roxo.netherbingo.commands.OpenGui;
import me.roxo.netherbingo.commands.SetRespawnandSpawnCommand;
import me.roxo.netherbingo.listeners.OnDeath;
import me.roxo.netherbingo.listeners.PlayerItemInteractListener;
import me.roxo.netherbingo.listeners.onJoin;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherBingo extends JavaPlugin {

    private GamerManager gameManager;

    @Override
    public void onEnable(){
        getCommand("OpenBingoBoard").setExecutor(new OpenGui(this));
        getCommand("SetRespawnandSpawnLocation").setExecutor(new SetRespawnandSpawnCommand(this));
        getServer().getPluginManager().registerEvents(new onJoin(gameManager),this);
        getServer().getPluginManager().registerEvents(new PlayerItemInteractListener(gameManager),this);
        getServer().getPluginManager().registerEvents(new OnDeath(this),this);

        this.gameManager = new GamerManager(this);

    }
    @Override
    public void onDisable(){



    }
    public GamerManager getGameManager(){
        return gameManager;
    }


}
