package io.github.varatros.serversecore.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CommandSpyHandler {

    private static final Set<UUID> isSpying = new HashSet<>();
    public Set<UUID> getSpying() {
        return isSpying;
    }

    public Boolean toggleIsSpying(UUID playerUUID) {
        if (isSpying.contains(playerUUID)) {
            isSpying.remove(playerUUID);
            return false;
        }
        else {
            isSpying.add(playerUUID);
            return true;
        }
    }


}
