package me.roxo.netherbingo;

import me.roxo.netherbingo.commands.OpenGui;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherBingo extends JavaPlugin {

    private GamerManager gameManager;

    @Override
    public void onEnable(){
        getCommand("OpenBingoBoard").setExecutor(new OpenGui(this));
        this.gameManager = new GamerManager(this);

    }
    @Override
    public void onDisable(){



    }


}
