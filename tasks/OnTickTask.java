package com.imdrops.xhg.tasks;

import com.imdrops.xhg.XHG;
import com.imdrops.xhg.kits.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class OnTickTask extends BukkitRunnable {
    private XHG plugin;
    public OnTickTask(XHG plugin){
        this.plugin = plugin;
    }

    @Override
    public void run(){
        // call onTick() for every kit selected
        for (Player p : Bukkit.getOnlinePlayers()){
            if(!plugin.playerDataManager.isPlayerAdded(p)){
                plugin.playerDataManager.addPlayer(p);
                continue;
            }

            if(plugin.playerDataManager.getKit(p) == null){
                continue;
            }

            plugin.playerDataManager.getKit(p).onTick();
        }

        // call onTick() in the gameStateManager
        plugin.gameStateManager.onTick();
    }
}
