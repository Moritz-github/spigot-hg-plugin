package com.imdrops.xhg.gamestate;

import com.imdrops.xhg.XHG;
import com.imdrops.xhg.chat.ChatMessageWithPausePeriod;
import org.bukkit.ChatColor;

public class GameStateManager {
    private XHG plugin;
    private GameState gameState;
    private ChatMessageWithPausePeriod chatMessageWithPausePeriod;

    public GameStateManager(XHG plugin){
        this.plugin = plugin;

        this.gameState = GameState.WAITING;
        this.chatMessageWithPausePeriod = new ChatMessageWithPausePeriod(30000);
    }

    public void startCountdown(){
        if(this.gameState != GameState.COUNTDOWN.previous()){
            System.out.println("Someone or something tried to start the countdown while it is already running");
            return;
        }

        new CountDown(plugin, 10, "Game starts in: " + ChatColor.RED, "The Game has §2started!");

        nextGamestate();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void nextGamestate(){
        this.gameState = this.gameState.next();
        plugin.scoreBoardHandler.updateScoreboard();
    }

    public void onTick(){
        if(this.gameState == GameState.WAITING){
            chatMessageWithPausePeriod.sendBroadcast("§cWaiting for /start");
            return;
        }

        if(this.gameState == GameState.INVINCIBILITY){
            chatMessageWithPausePeriod.sendBroadcast("INVINCIBILITY phase!");
        }
    }
}
