package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvP implements Listener {
    private final GamerManager gamerManager;


    public PvP(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
       if(!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof Player )){
           return;
       }

       if(!(gamerManager.getDoTasks().getPvPBoolean())){
            e.setCancelled(true);
            return;
       }




   }
}
