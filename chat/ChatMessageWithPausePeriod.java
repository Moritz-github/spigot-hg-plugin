package com.imdrops.xhg.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatMessageWithPausePeriod {
    private double intervalBetweenChatMessages;
    private double lastChatMessage;

    public ChatMessageWithPausePeriod(int millisBetweenChatInfo){
        intervalBetweenChatMessages = millisBetweenChatInfo;
    }

    public void sendMessage(String message, Player p){
        if(System.currentTimeMillis() > lastChatMessage + intervalBetweenChatMessages){
            lastChatMessage = System.currentTimeMillis();
            p.sendMessage(message);
        }
    }

    public void setIntervalBetweenChatMessages(int millis){
        this.intervalBetweenChatMessages = millis;
    }

    public void sendBroadcast(String message){
        if(System.currentTimeMillis() > lastChatMessage + intervalBetweenChatMessages){
            lastChatMessage = System.currentTimeMillis();
            Bukkit.broadcastMessage(message);
        }
    }
}
