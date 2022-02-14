package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.MapCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerseCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("map").setExecutor(new MapCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
