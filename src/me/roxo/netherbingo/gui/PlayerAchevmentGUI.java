package me.roxo.netherbingo.gui;

import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.ItemBuilder;
import me.roxo.netherbingo.managers.ItemsData;
import me.roxo.netherbingo.managers.PlayerAchevemtn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class PlayerAchevmentGUI implements GUI{

    private Inventory inventory;

    private final GamerManager gameManager;

    public PlayerAchevmentGUI( Player player, GamerManager gameManager) {
        this.gameManager = gameManager;

        inventory = Bukkit.createInventory(null, 36, "Achievement Board");

        for(PlayerAchevemtn itemsToGet : this.gameManager.getItems()){
            ItemBuilder itemBuilder = new ItemBuilder(new ItemBuilder(itemsToGet.material(player))
                    .setName(itemsToGet.formattedName())
                    .addLoreLine(itemsToGet.isItemAchieved(player) ? "Yes" : "No")//TODO isItemAchevied need work
                    .toItemStack());
            if(itemsToGet.isItemAchieved(player)){
                itemBuilder.addEnchant(Enchantment.CHANNELING, 1).hideEnchantment();

            }
            inventory.addItem(itemBuilder.toItemStack());

        }
        inventory.addItem(new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "EXIT").toItemStack());
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