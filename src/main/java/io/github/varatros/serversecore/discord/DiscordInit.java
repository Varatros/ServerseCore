package io.github.varatros.serversecore.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class DiscordInit {
    public static DiscordApi init(String token) {
        return new DiscordApiBuilder().setToken(token).login().join();
    }
}
