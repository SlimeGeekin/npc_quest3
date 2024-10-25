package me.eclipsorz;

import me.eclipsorz.commands.QuestListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;

public class npc_quest3 extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        this.getCommand("npc").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(new QuestListener(), this);
    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();


            // Spawn villager
            Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
            villager.setAI(false);  // Disable movement
            villager.setInvulnerable(true);  // Make invulnerable
            villager.setCustomName("Quest NPC");  // Set custom name
            villager.setCustomNameVisible(true);

            player.sendMessage("Quest NPC spawned!");
            return true;
        }
        return false;
    }
}
