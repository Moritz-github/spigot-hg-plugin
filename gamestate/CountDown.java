package com.imdrops.xhg.gamestate;

import com.imdrops.xhg.XHG;
import org.bukkit.Bukkit;

public class CountDown {
    private int countdownRemaining;
    private int countdown;
    private XHG plugin;
    private String messageFinnished;

    public CountDown(XHG plugin, int time, String msgTick, String msgFinnished){
        this.plugin = plugin;
        final String message = msgTick;
        this.messageFinnished = msgFinnished;
        countdownRemaining = time;
        countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if(countdownRemaining > 0){
                    Bukkit.broadcastMessage(message + countdownRemaining);
                    countdownRemaining--;
                }else{
                    Finish();
                }
            }
        }, 0L, 20L);
    }

    public void Finish(){
        Bukkit.getScheduler().cancelTask(countdown);
        Bukkit.broadcastMessage(messageFinnished);
        plugin.gameStateManager.nextGamestate();
    }
}
