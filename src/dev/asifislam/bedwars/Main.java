package dev.asifislam.bedwars;

import dev.asifislam.bedwars.commands.MyCommands;
import dev.asifislam.bedwars.events.MyEvents;
import dev.asifislam.bedwars.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyEvents(), this);
        MyCommands commands = new MyCommands();

        ItemManager.init();
        getCommand("wand").setExecutor(commands);
        getCommand("heal").setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin is enabled [TUTORIAL]");
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin is disabled [TUTORIAL]");
    }
}
