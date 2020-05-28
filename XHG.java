package com.imdrops.xhg;

import com.imdrops.xhg.chat.ChatCommandKit;
import com.imdrops.xhg.chat.ChatCommandStart;
import com.imdrops.xhg.events.WorldChangeEvents;
import com.imdrops.xhg.gamestate.GameStateManager;
import com.imdrops.xhg.kits.KitManager;
import com.imdrops.xhg.playerdata.PlayerDataManager;
import com.imdrops.xhg.scoreboard.ScoreBoardHandler;
import com.imdrops.xhg.tasks.OnTickTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

// toDo: scoreboard
// toDo: check for logout event and remove all effects (z.B. potion, walkingSpeed etc)

public final class XHG extends JavaPlugin {
    public KitManager kitManager;
    public PlayerDataManager playerDataManager;
    public GameStateManager gameStateManager;
    public ScoreBoardHandler scoreBoardHandler;

    @Override
    public void onEnable() {
        this.kitManager = new KitManager(this);
        this.playerDataManager = new PlayerDataManager();
        this.gameStateManager = new GameStateManager(this);
        this.scoreBoardHandler = new ScoreBoardHandler(this);

        BukkitTask onTickTask = new OnTickTask(this).runTaskTimer(this, 1, 1);

        this.getCommand("kit").setExecutor(new ChatCommandKit(this));
        this.getCommand("start").setExecutor(new ChatCommandStart(this));

        WorldChangeEvents worldChangeEvents = new WorldChangeEvents(this);

        Bukkit.broadcastMessage(ChatColor.BLUE + "xHG successfully loaded on Server!");
    }

    @Override
    public void onDisable() {
    }
}