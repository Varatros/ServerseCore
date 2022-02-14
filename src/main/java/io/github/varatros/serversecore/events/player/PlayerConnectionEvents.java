package io.github.varatros.serversecore.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectionEvents implements Listener {

    @EventHandler
    private void playerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

}
