package me.roxo.netherbingo.gui;

import me.roxo.netherbingo.managers.GamePlayerData;
import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.ItemBuilder;
import me.roxo.netherbingo.managers.PlayerAchevemtn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class PlayerAchevmentGUI implements GUI{

    private Inventory inventory;

    private final GamerManager gameManager;

    public PlayerAchevmentGUI( Player player, GamerManager gameManager) {
        this.gameManager = gameManager;

        inventory = Bukkit.createInventory(null, 36, "Achievement Board");
        //TODO in here find if the player is in the gamermager.getGamerplayerBata and then get the player. 
        for(PlayerAchevemtn itemsToGet : this.gameManager.getItems()){
            GamePlayerData a = null;
            for(GamePlayerData gamePlayerData : gameManager.getGamePlayerData()) {
                if (gamePlayerData.getPlayer().getUniqueId() == player.getUniqueId()) {//TODO this might be a problem
                    a = gamePlayerData;
                }
            }

            if(a == null){
                System.out.println("this is null 35 player achievement");
                return;
            }
            System.out.println(a.isItemAchieved(player, itemsToGet) + "item = " + itemsToGet.name());
            ItemBuilder itemBuilder = new ItemBuilder(new ItemBuilder(itemsToGet.material(player))
                    .setName(itemsToGet.formattedName())

                    .addLoreLine(a.isItemAchieved(player, itemsToGet) ? "Yes" : "No")//TODO isItemAchevied need work
                    .toItemStack());
            if(a.isItemAchieved(player, itemsToGet)){
                itemBuilder.addEnchant(Enchantment.CHANNELING, 1).hideEnchantment();

            }
            inventory.addItem(itemBuilder.toItemStack());

        }
        inventory.setItem(32, new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "EXIT").toItemStack());
    }




    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String getName() {
        return "Achievement Board";
    }

    @Override
    public GUI handleClick(Player player, ItemStack itemStack, InventoryView view) {
        PlayerAchevemtn clickedColor = null;

        String itemName = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
        for(PlayerAchevemtn element : PlayerAchevemtn.values()){
            if(itemName.equalsIgnoreCase(element.formattedName())) {
                clickedColor = element;
                break;
            }
        }



        PlayerAchevemtn finalClickedColor = clickedColor;
        /*
        Optional<ItemsData> optionalIsland = gameManager.getGameWorld().getIslands().stream().filter(island -> island.getElement() == finalClickedColor).findFirst();
        if (optionalIsland.isPresent()) {
            ItemsData island = optionalIsland.get();
            if(island.getPlayers().size() != gameManager.getGameWorld().getMaxTeamSize()){
                island.addMember(player);
                //gameManager.getPlayerManager().giveTeamArmor(player,island);
            }else{
                player.sendMessage("That Team is full.");

            }

            island.addMember(player);




        }
        */

        return null;
    }


    @Override
    public boolean isInventory(InventoryView view) {
        return view.getTitle().equals(getName());
    }
}
