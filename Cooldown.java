package com.imdrops.xhg;

import org.bukkit.entity.Player;

public class Cooldown {
    private double cooldownStart;
    private double cooldownTime;

    private double intervalBetweenChatInfo;
    private double lastChatMessage;

    public Cooldown(int millisBetweenChatInfo){
        intervalBetweenChatInfo = millisBetweenChatInfo;
    }

    public void setCooldown(double seconds){
        this.cooldownTime = seconds * 1000;
        this.cooldownStart = System.currentTimeMillis();
    }

    public boolean isCooldownOver(){
        if (cooldownStart + cooldownTime < System.currentTimeMillis()){
            cooldownTime = 0;
            cooldownStart = 0;
            return true;
        }

        return false;
    }

    public int getCooldownRemaining(){
        return (int) (cooldownTime - (System.currentTimeMillis() - cooldownStart))/ 1000;
    }

    public boolean isCooldownActive(){
        if(cooldownTime == 0){
            return false;
        }
        return true;
    }

    public void printCooldownTime(Player p){
        if(this.isCooldownOver()){
            return;
        }

        if(System.currentTimeMillis() > lastChatMessage + intervalBetweenChatInfo){
            lastChatMessage = System.currentTimeMillis();
            p.sendMessage("§c" + this.getCooldownRemaining() + " §2seconds cooldown left.");
        }
    }

}
