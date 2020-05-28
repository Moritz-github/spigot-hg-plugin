package com.imdrops.xhg.playerdata;

import com.imdrops.xhg.kits.Kit;

import java.util.UUID;

public class PlayerData {
    private UUID uuid;
    private Kit kit;

    PlayerData(UUID uuid){
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setKit(Kit kit){
        this.kit = kit;
    }

    public Kit getKit(){
        return this.kit;
    }
}
