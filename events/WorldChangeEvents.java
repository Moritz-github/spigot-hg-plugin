package com.imdrops.xhg.events;

import com.imdrops.xhg.XHG;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;

public class WorldChangeEvents implements Listener {
    private XHG plugin;

    public WorldChangeEvents(XHG plugin){
        this.plugin = plugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        if(!plugin.gameStateManager.getGameState().canBreakBlocks()){
            event.setCancelled(true);
        }
    }
}
