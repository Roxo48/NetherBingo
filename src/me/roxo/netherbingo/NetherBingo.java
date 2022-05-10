package me.roxo.netherbingo;

import me.roxo.netherbingo.commands.OpenGui;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherBingo extends JavaPlugin {

    @Override
    public void onEnable(){
        getCommand("OpenBingoBoard").setExecutor(new OpenGui(this));


    }
    @Override
    public void onDisable(){



    }


}
