package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    private final GamerManager gamerManager;

    public onJoin(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(!(e instanceof Player)){
            return;
        }
        if(gamerManager.getState() != GameState.ACTIVE ){
            e.getPlayer().setInvulnerable(true);
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
        }



    }

}
