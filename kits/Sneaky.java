package com.imdrops.xhg.kits;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Sneaky extends Kit{
    public Sneaky(Player p){
        super("Sneaky", "Sneak to turn invisible", p);
    }

    private Cooldown cooldown = new Cooldown();
    private boolean wasSneaking = false;

    @Override
    public void onPick() {
    }

    @Override
    public void onRemovePick() {
    }

    void setInvisible(){
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20*10, 1));
    }

    @Override
    public void onTick() {
        if(p.isSneaking()) {
            if(cooldown.isCooldownOver()){
                setInvisible();
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 1);
                cooldown.setCooldown(60);
            }else{
                cooldown.printCooldownTime(p);
            }
        }
    }
}
