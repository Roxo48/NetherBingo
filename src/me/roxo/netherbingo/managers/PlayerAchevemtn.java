package me.roxo.netherbingo.managers;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public enum PlayerAchevemtn {


    DIAMOND_HORSE_ARMOR, WITHER_SKELETON_SKULL, JUKEBOX, RED_NETHER_BRICKS, COAL_BLOCK, ENDER_EYE, PIGLIN_BANNER_PATTERN, MUSIC_DISC_PIGSTEP, GILDED_BLACKSTONE, LODESTONE, RESPAWN_ANCHOR, SOUL_SPEED_3_BOOK, WATER_BUCKET, GOLDEN_APPLE, ANVIL, SOUL_LANTERN, IRON_BLOCK, POLISHED_BASALT, WHITE_BANNER, GHAST_TEAR, ROTTEN_FLESH, SMOKER, NETHERITE_INGOT, LEATHER_HORSE_ARMOR, WARPED_NYLIUM, TRAPPED_CHEST, QUARTZ_BRICKS;





    public String formattedName() {
        String caps = this.toString();

        return String.valueOf(caps.charAt(0)).toUpperCase() + caps.substring(1).toLowerCase();


    }

    public Color getColor() {
        switch (this) {
            case GHAST_TEAR:
                return Color.WHITE;
            case ROTTEN_FLESH:
                return Color.GREEN;
            case GOLDEN_APPLE:
                return Color.YELLOW;
            case DIAMOND_HORSE_ARMOR:
                return Color.BLUE;
            case ENDER_EYE:
                return Color.NAVY;
            case MUSIC_DISC_PIGSTEP:
                return Color.BLACK;
            case NETHERITE_INGOT:
                return Color.BLACK;
            case RESPAWN_ANCHOR:
                return Color.PURPLE;
            case WARPED_NYLIUM:
                return Color.BLUE;
            case QUARTZ_BRICKS:
                return Color.WHITE;
            case PIGLIN_BANNER_PATTERN:
                return Color.PURPLE;
            case GILDED_BLACKSTONE:
                return Color.GRAY;
            case LEATHER_HORSE_ARMOR:
                return Color.WHITE;
            case ANVIL:
                return Color.GRAY;
            case WATER_BUCKET:
                return Color.BLUE;
            case TRAPPED_CHEST:
                return Color.GRAY;
            case SOUL_LANTERN:
                return Color.BLUE;
            case COAL_BLOCK:
                return Color.BLACK;
            case WHITE_BANNER:
                return Color.GREEN;
            case POLISHED_BASALT:
                return Color.NAVY;
            case RED_NETHER_BRICKS:
                return Color.RED;
            case SMOKER:
                return Color.GRAY;
            case IRON_BLOCK:
                return Color.GRAY;
            case WITHER_SKELETON_SKULL:
                return Color.BLACK;
            case JUKEBOX:
                return Color.ORANGE;
            case LODESTONE:
                return Color.GRAY;
            case SOUL_SPEED_3_BOOK:
                return Color.BLUE;
        }
        return Color.BLACK;

    }

    public Material material(Player player) {
        //just make a lot of if staements
        //to see if playe has item in th eplayer maager


        Material teamWoolMatarial = Material.BLACK_WOOL;

        switch (this) {
            case GHAST_TEAR:
                return Material.GHAST_TEAR;
            case ROTTEN_FLESH:
                return Material.ROTTEN_FLESH;
            case GOLDEN_APPLE:
                return Material.GOLDEN_APPLE;
            case DIAMOND_HORSE_ARMOR:
                return Material.DIAMOND_HORSE_ARMOR;
            case ENDER_EYE:
                return Material.ENDER_EYE;
            case MUSIC_DISC_PIGSTEP:
                return Material.MUSIC_DISC_PIGSTEP;
            case NETHERITE_INGOT:
                return Material.NETHERITE_INGOT;
            case RESPAWN_ANCHOR:
                return Material.RESPAWN_ANCHOR;
            case WARPED_NYLIUM:
                return Material.WARPED_NYLIUM;
            case QUARTZ_BRICKS:
                return Material.QUARTZ_BRICKS;
            case PIGLIN_BANNER_PATTERN:
                return Material.PIGLIN_BANNER_PATTERN;
            case GILDED_BLACKSTONE:
                return Material.GILDED_BLACKSTONE;
            case LEATHER_HORSE_ARMOR:
                return Material.LEATHER_HORSE_ARMOR;
            case ANVIL:
                return Material.ANVIL;
            case WATER_BUCKET:
                return Material.WATER_BUCKET;
            case TRAPPED_CHEST:
                return Material.TRAPPED_CHEST;
            case SOUL_LANTERN:
                return Material.SOUL_LANTERN;
            case COAL_BLOCK:
                return Material.COAL_BLOCK;
            case WHITE_BANNER:
                return Material.WHITE_BANNER;
            case POLISHED_BASALT:
                return Material.POLISHED_BASALT;
            case RED_NETHER_BRICKS:
                return Material.RED_NETHER_BRICKS;
            case SMOKER:
                return Material.SMOKER;
            case IRON_BLOCK:
                return Material.IRON_BLOCK;
            case WITHER_SKELETON_SKULL:
                return Material.WITHER_SKELETON_SKULL;
            case JUKEBOX:
                return Material.JUKEBOX;
            case LODESTONE:
                return Material.LODESTONE;
            case SOUL_SPEED_3_BOOK:
                ItemStack a = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta)a.getItemMeta();
                meta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
                a.setItemMeta(meta);
                return a.getType();
        }

        return teamWoolMatarial;
    }

    public boolean isItemAchieved(Player player) {
        //TODO do this
        return false;
    }
}
