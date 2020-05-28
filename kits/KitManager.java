package com.imdrops.xhg.kits;

import com.imdrops.xhg.XHG;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class KitManager {
    private ArrayList<Class> kits;
    private XHG plugin;

    public KitManager(XHG plugin){
        this.plugin = plugin;

        kits = new ArrayList<Class>();
        kits.add(NoKit.class);
        kits.add(Runner.class);
        kits.add(Sneaky.class);
    }

    public Class getKitClassFromString(String kitString){
        for (Class kitClass : this.kits){
            if (kitClass.getSimpleName().equalsIgnoreCase(kitString)){
                return kitClass;
            }
        }
        return null;
    }

    public void listAllKits(Player p){
        for (Class c : plugin.kitManager.getKits()){
            try {
                Constructor<Kit> kitConstructor = c.getConstructor(Player.class);
                Kit k = kitConstructor.newInstance(p);

                TextComponent message = new TextComponent("§a" + k.getName());
                message.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit " + k.getName()));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b" + k.getDescription()).create() ));
                p.spigot().sendMessage(message);
            } catch (Exception e) {
                p.sendMessage("§4Error on kit " + c.getSimpleName());
            }
        }
    }

    public ArrayList<Class> getKits(){
        return this.kits;
    }


}
