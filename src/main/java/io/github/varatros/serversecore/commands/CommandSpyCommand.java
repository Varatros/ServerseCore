package io.github.varatros.serversecore.commands;

import io.github.varatros.serversecore.util.CommandSpyHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSpyCommand implements CommandExecutor {

    private final CommandSpyHandler commandSpyHandler = new CommandSpyHandler();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        commandSpyHandler.toggleIsSpying(player.getUniqueId());
        //Test, and make pretty.
        if (commandSpyHandler.getSpying(player.getUniqueId())) {
            player.sendMessage("Command Spy Enabled");
        }
        else {
            player.sendMessage("Command Spy Disabled");
        }
        return false;
    }
}
