package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.*;
import io.github.varatros.serversecore.events.player.PlayerChatEvents;
import io.github.varatros.serversecore.events.player.PlayerConnectionEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ServerseCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //Commands
        Objects.requireNonNull(this.getCommand("commandspy")).setExecutor((new CommandSpyCommand()));
        Objects.requireNonNull(this.getCommand("map")).setExecutor(new MapCommand());
        Objects.requireNonNull(this.getCommand("shrug")).setExecutor(new ShrugCommand());
        Objects.requireNonNull(this.getCommand("twitch")).setExecutor(new TwitchCommand());

        //Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerChatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvents(), this);

        File configFile = new File(this.getDataFolder(), "discord.yml");
        YamlConfiguration configData = YamlConfiguration.loadConfiguration(configFile);
        if (!configFile.exists()) {
            boolean isCreated = configFile.mkdirs();
            configData.set("token", null);
            configData.set("logchannel", null);
            try {
                configData.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
