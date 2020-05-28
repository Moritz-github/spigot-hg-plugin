package com.imdrops.xhg.kits;
import org.bukkit.entity.Player;

public class Runner extends Kit {
    public Runner(Player p){
        super("Runner", "Run faster", p);
    }

    @Override
    public void onPick() {
        p.setWalkSpeed(0.5F);
    }

    @Override
    public void onRemovePick() {
        p.setWalkSpeed(0.2F);
    }

    @Override
    public void onTick() {

    }
}
