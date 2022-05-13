package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.gui.PlayerAchevmentGUI;
import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerItemInteractListener implements Listener {
    private final GamerManager gamerManager;

    public PlayerItemInteractListener(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }

    @EventHandler
    public void ontinterctwithitem(PlayerInteractEvent e){
        System.out.println("x4");
        if(!e.hasItem()){return;}
        System.out.println("x1");
        //   if(!gameManager.getSetupWizardManager().isInWizard(e.getPlayer()))return;
        System.out.println("x2");
        //if(!e.getItem().hasItemMeta()){return;}
        System.out.println("x5");

        Player player = e.getPlayer();

        //e.setCancelled(true);

        String itemName = e.getItem().getItemMeta().getDisplayName();
        itemName = ChatColor.stripColor(itemName);

        if(/*itemName.toLowerCase().contains("select team")&&*/ gamerManager.getState()== GameState.LOBBY || gamerManager.getState()==GameState.STARTING){
            PlayerAchevmentGUI gui = new PlayerAchevmentGUI(player, gamerManager);
            gamerManager.getGuiManager().setGUI(player,gui);
            e.setCancelled(true);
        }


    }
}
