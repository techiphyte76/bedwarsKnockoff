package dev.asifislam.tutorial;

import dev.asifislam.tutorial.commands.TutorialCommands;
import dev.asifislam.tutorial.events.TutorialEvents;
import dev.asifislam.tutorial.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        TutorialCommands commands = new TutorialCommands();

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
