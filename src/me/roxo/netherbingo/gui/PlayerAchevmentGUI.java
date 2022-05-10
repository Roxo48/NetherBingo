package me.roxo.netherbingo.gui;

import me.roxo.netherbingo.managers.GamerManager;
import me.roxo.netherbingo.managers.ItemsToGet;
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

        for(ItemsToGet itemsToGet : this.gameManager.getGameWorld().getIslands()){
            ItemBuilder itemBuilder = new ItemBuilder(new ItemBuilder(element.getElement().material())
                    .setName(element.getElement().formattedName())
                    .addLoreLine(element.ismMember(player) ? "Selected" : "Not Selected")
                    .addLoreLine(element.getPlayers().size() + "/" + this.gameManager.getGameWorld().getMaxTeamSize() + " Players")
                    .toItemStack());
            if(element.ismMember(player)){
                itemBuilder.addEnchant(Enchantment.CHANNELING, 1).hideEnchantment();

            }
            inventory.addItem(itemBuilder.toItemStack());

        }
        inventory.addItem(new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "EXIT").toItemStack());
    }




    @Override
    public Inventory getInventory() {
        return inventry;
    }

    @Override
    public String getName() {
        return "Achievement Board";
    }

    @Override
    public GUI handleClick(Player player, ItemStack itemStack, InventoryView view) {
        TeamElement clickedColor = null;

        String itemName = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
        for(TeamElement element : TeamElement.values()){
            if(itemName.equalsIgnoreCase(element.formattedName())) {
                clickedColor = element;
                break;
            }
        }

        Optional<Island> optional = gameManager.getGameWorld().getIslands().stream().filter(island -> island.ismMember(player)).findFirst();
        optional.ifPresent(island -> {
            island.removeMember(player);


        });


        TeamElement finalClickedColor = clickedColor;
        Optional<Island> optionalIsland = gameManager.getGameWorld().getIslands().stream().filter(island -> island.getElement() == finalClickedColor).findFirst();
        if (optionalIsland.isPresent()) {
            Island island = optionalIsland.get();
            if(island.getPlayers().size() != gameManager.getGameWorld().getMaxTeamSize()){
                island.addMember(player);
                gameManager.getPlayerManager().giveTeamArmor(player,island);
            }else{
                player.sendMessage("That Team is full.");

            }

            island.addMember(player);




        }

        return null;
    }


    @Override
    public boolean isInventory(InventoryView view) {
        return view.getTitle().equals(getName());
    }
}
