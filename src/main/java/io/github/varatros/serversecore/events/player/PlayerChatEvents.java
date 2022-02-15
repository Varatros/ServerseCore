package io.github.varatros.serversecore.events.player;

import io.github.varatros.serversecore.util.CommandSpyHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerChatEvents implements Listener {

    private final CommandSpyHandler commandSpyHandler = new CommandSpyHandler();


    @EventHandler
    private void playerCommandEvent(PlayerCommandPreprocessEvent event) {
        for (UUID playerUUID : commandSpyHandler.getSpying()) {
            Player player = Bukkit.getPlayer(playerUUID);
            if (player != null) {
                player.sendMessage(event.getPlayer()+": "+event.getMessage());
            }
        }
    }

}
