package io.github.varatros.serversecore.util;

import java.util.HashMap;
import java.util.UUID;

public class CommandSpyHandler {

    private static final HashMap<UUID, Boolean> isSpying = new HashMap<UUID, Boolean>();

    public boolean getSpying(UUID playeruuid) {
        return isSpying.getOrDefault(playeruuid, false);
    }

    public void toggleIsSpying(UUID playeruuid) {
        if (getSpying(playeruuid)) {
            isSpying.remove(playeruuid);
            return;
        }
        isSpying.put(playeruuid, true);
    }


}
