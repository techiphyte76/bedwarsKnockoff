package dev.asifislam.tutorial.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.event.ItemEvent;

public class TutorialEvents implements Listener{
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BLUE + "Welcome to the beta!");
    }
    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        event.getEntity().sendMessage("You suck! Go back to creative!");
    }
    @EventHandler
    public static void onBlockBroken(BlockBreakEvent block) {
        Player player = block.getPlayer();
        Material blockType = block.getBlock().getType();
        if (blockType.toString() == "BED_BLOCK") {
            Bukkit.broadcastMessage("Bed Broken");
        }
    }
    @EventHandler
    public void fireballDamage(EntityDamageByEntityEvent e) {
        Player player = (Player) e.getDamager();
        if (e.getDamager() instanceof Fireball && e.getEntity() instanceof Player) {
            Player p = (Player) e.getDamager();
            Player s = (Player) e.getEntity();
            s.damage(0.5);
            s.setVelocity(s.getVelocity().multiply(2));
            p.sendMessage("Fireball");
        }
    }
    @EventHandler
    public void shootFireball(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getItemInHand().getType() == Material.BLAZE_ROD){
        Location loc = player.getLocation();
        Entity fireball = loc.getWorld().spawnEntity(loc.add(loc.getDirection()), EntityType.FIREBALL);
        fireball.setVelocity(loc.getDirection().multiply(0.75));}
    }
}
