package dev.asifislam.bedwars.commands;

import dev.asifislam.bedwars.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute that command");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("wand")) {
            player.getInventory().addItem(ItemManager.wand);
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("heal")) {
            player.setHealth(20.0);
            return true;
        }
        return true;
    }
}
