package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DoTasks  {

    private int counter;
   private final GamerManager gamerManager;
    private boolean some = false;
    private int done;

   public DoTasks(GamerManager gamerManager){
        this.counter = 0;
       this.gamerManager = gamerManager;
       this.done =  0;
   }


   public void doTasks(){
       //20L = 1 Second
       //have one hour
       long b = 20 * 60 * 15;

       new BukkitRunnable() {
           @Override
           public void run() {
               Bukkit.getServer().broadcastMessage("Remember shift on the terracotta to be teleported");
               if(counter % 2 == 0) {
                   for (Player player : gamerManager.getPlayer()) {

                       player.sendTitle("Pvp and Keep Inventory is Enabled ", "...", 20, 20, 20);

                   }
                   Bukkit.getServer().getWorlds().get(1).setGameRule(GameRule.KEEP_INVENTORY, true);
                   some = true;
                   Bukkit.getServer().getWorlds().get(1).setGameRule(GameRule.KEEP_INVENTORY, true);
                   counter++;
               }else if(counter % 2 != 0) {
                   for (Player player : gamerManager.getPlayer()) {
                       player.setInvulnerable(false);
                       player.sendTitle("Pvp and Keep Inventory is Disabled ", "...", 20, 20, 20);

                   }

                   Bukkit.getServer().getWorlds().get(1).setGameRule(GameRule.KEEP_INVENTORY, false);
                   some = false;
                   Bukkit.getServer().getWorlds().get(1).setGameRule(GameRule.KEEP_INVENTORY, false);
                   counter++;
               }

           }


       }.runTaskTimer(gamerManager.getPlugin(), 0L, b);


   }
   public void Timer(){
       long b = 20 * 60 * 30;

       new BukkitRunnable() {
           @Override
           public void run() {
               System.out.println("this is a timer of the timer time timer timer");
               done++;
               if(done == 2){
                gamerManager.setState(GameState.WON);
               }

           }


       }.runTaskTimer(gamerManager.getPlugin(), 0L, b);




   }



   public boolean getPvPBoolean(){
       return some;
   }


}
