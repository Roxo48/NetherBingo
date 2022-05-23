package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.gui.GUI;
import me.roxo.netherbingo.gui.PlayerAchevmentGUI;
import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerItemInteractListener implements Listener {
    private final GamerManager gamerManager;

    public PlayerItemInteractListener(GamerManager gamerManager) {
        this.gamerManager = gamerManager;
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(gamerManager.getState() == GameState.LOBBY && e.getWhoClicked().getGameMode()!= GameMode.CREATIVE){
            e.setCancelled(true);
        }
        System.out.println("x7");
        if(e.getCurrentItem() == null){
            return;
        }
        String matericalname = e.getCurrentItem().getType().name();


        System.out.println("x10");
        if(!e.getCurrentItem().hasItemMeta())return;
        System.out.println("x9");
        Player player = (Player) e.getWhoClicked();
        GUI gui = gamerManager.getGuiManager().getOpenGUI(player);

        if(gui == null){return;}
        System.out.println("abc");
        e.setCancelled(true);

        //GUI newGUI = gui.handleClick(player,e.getCurrentItem(), e.getView() );
        if(e.getCurrentItem().getType() == Material.BARRIER) {
            System.out.println("123789009781230978--809890-12380-9089-213");
            e.getView().close();
        }

        //if(newGUI == null){
       //     gamerManager.getGuiManager().setGUI(player,newGUI);
        //}



    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){

        Player player = (Player) e.getPlayer();

        gamerManager.getGuiManager().clear(player);

    }

}
