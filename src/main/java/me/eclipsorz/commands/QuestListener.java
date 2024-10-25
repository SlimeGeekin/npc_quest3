package me.eclipsorz.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class QuestListener implements Listener {


    @EventHandler
    public void onPlayerInteractWithNPC(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();
            if ("Quest NPC".equals(villager.getCustomName())) {
                Player player = event.getPlayer();

                int dirtCount = 0;
                for (ItemStack item : player.getInventory().getContents()) {
                    if (item != null && item.getType() == Material.DIRT) {
                        dirtCount += item.getAmount();
                    }
                }

                if (dirtCount >= 24) {
                    player.sendMessage("Quest complete! You have collected 24 dirt blocks.");

                    // Reward the player with 5 diamonds
                    ItemStack diamondReward = new ItemStack(Material.DIAMOND, 5);
                    player.getInventory().addItem(diamondReward);

                    player.sendMessage("You have been rewarded with 5 diamonds!");
                } else {
                    player.sendMessage("Collect 24 dirt blocks to complete the quest.");
                }
            }
        }
    }
}
