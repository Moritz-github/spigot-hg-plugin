package com.imdrops.xhg.kits;
import org.bukkit.entity.Player;

public class NoKit extends Kit {
    public NoKit(Player p){
        super("NoKit", "This kit does absolutley nothing", p);
    }

    @Override
    public void onPick() {
    }

    @Override
    public void onRemovePick() {
    }

    @Override
    public void onTick() {
    }
}