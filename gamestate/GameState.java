package com.imdrops.xhg.gamestate;

import com.imdrops.xhg.XHG;

public enum GameState {
    WAITING(false, false), COUNTDOWN(false, false),
    INVINCIBILITY(true, false), RUNNING(true, true),
    DEATHMATCH(true, true), FINISHED(true, true),
    RESTARTING(false, false);

    boolean canBreakBlocks;
    boolean canTakeDamage;

    GameState(boolean canBreakBlocks, boolean canTakeDamage){
        this.canBreakBlocks = canBreakBlocks;
        this.canTakeDamage = canTakeDamage;
    }

    public boolean canBreakBlocks() {
        return canBreakBlocks;
    }

    public boolean canTakeDamage() {
        return canTakeDamage;
    }

    private static GameState[] vals = values();
    public GameState next()
    {
        return vals[(this.ordinal()+1)];
    }
    public GameState previous()
    {
        return vals[(this.ordinal()-1)];
    }
}
