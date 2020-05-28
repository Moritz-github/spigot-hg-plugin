package com.imdrops.xhg.chat;

import com.imdrops.xhg.XHG;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommandStart implements CommandExecutor {
    XHG plugin;
    public ChatCommandStart(XHG plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        // /start
        if(command.getName().equalsIgnoreCase("start")){
            p.sendMessage(ChatColor.GREEN + "Starting Game");

            plugin.gameStateManager.startCountdown();
            return true;
        }

        return true;
    }
}
