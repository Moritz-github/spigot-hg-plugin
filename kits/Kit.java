package com.imdrops.xhg.kits;
import com.imdrops.xhg.XHG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class Kit {
    private String name;
    private String description;
    protected Player p;
    private double cooldownMillisRemaining;

    public Kit(String name, String description, Player p){
        this.name = name;
        this.description = description;
        this.p = p;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription() { return this.description; }


    public abstract void onPick();
    public abstract void onRemovePick();
    public abstract void onTick();
}
