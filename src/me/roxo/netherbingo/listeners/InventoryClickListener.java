package me.roxo.netherbingo.listeners;

import me.roxo.netherbingo.gui.GUI;
import me.roxo.netherbingo.managers.GameState;
import me.roxo.netherbingo.managers.GamerManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClickListener implements Listener {

    private final GamerManager gameManager;

    public InventoryClickListener(GamerManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(gameManager.getState() == GameState.LOBBY && e.getWhoClicked().getGameMode()!= GameMode.CREATIVE){
            e.setCancelled(true);
        }
        System.out.println("x7");
        if(e.getCurrentItem() == null){
            return;
        }
        String matericalname = e.getCurrentItem().getType().name();

        if(matericalname.contains("LEGGINGS")||matericalname.contains("CHESTPLATE")||matericalname.contains("BOOTS")||matericalname.contains("HELMET")){e.setCancelled(true);}
        System.out.println("x10");
        if(!e.getCurrentItem().hasItemMeta())return;
        System.out.println("x9");
        Player player = (Player) e.getWhoClicked();
        GUI gui = gameManager.getGuiManager().getOpenGUI(player);

        if(gui == null){return;}
        System.out.println("abc");
        e.setCancelled(true);

        GUI newGUI = gui.handleClick(player,e.getCurrentItem(), e.getView() );

        e.getView().close();

        if(newGUI == null){
            gameManager.getGuiManager().setGUI(player,newGUI);
        }



    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){

        Player player = (Player) e.getPlayer();

        gameManager.getGuiManager().clear(player);

    }


}
