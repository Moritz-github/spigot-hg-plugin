package com.imdrops.xhg.kits;

import com.imdrops.xhg.chat.ChatMessageWithPausePeriod;
import org.bukkit.entity.Player;

public class Cooldown {
    private double cooldownStart = 0;
    private double cooldownTime = 0;

    private ChatMessageWithPausePeriod chatMessageWithPausePeriod;

    public Cooldown(){
        this.chatMessageWithPausePeriod = new ChatMessageWithPausePeriod(1000);
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

        chatMessageWithPausePeriod.sendMessage("§c" + this.getCooldownRemaining() + " §2seconds cooldown left.", p);
    }

}
