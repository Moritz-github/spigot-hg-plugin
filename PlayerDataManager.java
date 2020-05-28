package com.imdrops.xhg;

import com.imdrops.xhg.kits.Kit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDataManager {
    private HashMap<UUID, PlayerData> allPlayerData = new HashMap<>();

    public void addPlayer(Player p){
        if (isPlayerAdded((p))){
            System.out.println("Error! The Plugin tried to add a player that is already existing");
            return;
        }
        allPlayerData.put(p.getUniqueId(), new PlayerData(p.getUniqueId()));
    }

    public boolean isPlayerAdded(Player p){
        if (allPlayerData.get(p.getUniqueId()) == null){
            return false;
        }
        return true;
    }

    public void registerKit(Player p, Kit k){
        // if a old kit is selected
        if (this.allPlayerData.get(p.getUniqueId()).getKit() != null) {
            this.allPlayerData.get(p.getUniqueId()).getKit().onRemovePick();
        }

        this.allPlayerData.get(p.getUniqueId()).setKit(k);

        k.onPick();
    }

    public Kit getKit(Player p){
        return this.allPlayerData.get(p.getUniqueId()).getKit();
    }
}
