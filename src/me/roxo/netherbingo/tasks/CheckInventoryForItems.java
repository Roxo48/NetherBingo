package me.roxo.netherbingo.tasks;

import me.roxo.netherbingo.managers.GamePlayerData;
import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.PlayerAchevemtn;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckInventoryForItems {
    private final GamerManager gamerManager;
    private Player player;

    public CheckInventoryForItems(GamerManager gamerManager, Player player) {
        this.gamerManager = gamerManager;
        this.player = player;
    }

    public void checkInventoryForItems(){
        List<PlayerAchevemtn> playerAchevemtns = new ArrayList<>();
        ItemStack[] a = player.getInventory().getContents();
//        for(int i = 0; i < a.length; i++){
//            if (a[i] == null){
//
//            }
//
//        }
        System.out.println(Arrays.toString(a));
        Bukkit.getServer().getScheduler().runTaskAsynchronously(gamerManager.getPlugin(), new Runnable() {
            @Override
            public void run() {
                System.out.println("byeeeeee");
                //PlayerAchevemtn element : PlayerAchevemtn.values()
                for (PlayerAchevemtn element : PlayerAchevemtn.values()) {
                    for (int i = 0; i < a.length; i++){
                        try {
                            //System.out.println(a[i].getType());
                        }catch (Exception e){}
                       if(a[i] == null){continue;}
                        //System.out.println(a[i].getType() + " " + element.material(player.getPlayer()));
                        if(a[i].getType() == element.material(player.getPlayer())) {
                            //System.out.println("teeheehesesdfsd");
                            for(GamePlayerData gamePlayerData : gamerManager.getGamePlayerData()){
                                if(gamePlayerData.getPlayer().getUniqueId() == player.getUniqueId()) {//TODO this might be a problem
                                    playerAchevemtns.add(element);
                                    gamePlayerData.setItemAchieved(player, element);
                                }
                            }

                        }

                    }
                   // System.out.println("auhgearhiuoiohgarefhioihodzfpoiuhfdsaoihuiohdfsoihdsoihsodihoihsdf");

            }
            }
        });


    }



}
