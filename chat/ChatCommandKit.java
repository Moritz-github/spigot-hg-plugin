package com.imdrops.xhg.chat;

        import com.imdrops.xhg.kits.Kit;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import com.imdrops.xhg.XHG;

        import java.lang.reflect.Constructor;

public class ChatCommandKit implements CommandExecutor {
    private XHG plugin;
    public ChatCommandKit(XHG plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;

        // /kit
        if(command.getName().equalsIgnoreCase("kit")){
            // if -/kit name- is typed
            if(args.length == 1){
                Class kitClassPicked = plugin.kitManager.getKitClassFromString(args[0]);

                if(kitClassPicked == null){
                    sender.sendMessage("§2Kit not found!");
                    return true;
                }
                //register the kit
                try{
                    Constructor<Kit> kitConstructor = kitClassPicked.getConstructor(Player.class);
                    Kit kitInstantiated = kitConstructor.newInstance(p);
                    plugin.playerDataManager.registerKit(p, kitInstantiated);

                    sender.sendMessage("§2Picked kit §c" + plugin.playerDataManager.getKit(p).getName());
                } catch (Exception e){
                    sender.sendMessage("§2There was an error!");
                    System.out.println(e.getMessage());
                }
                return true;
            }

            // if -/kit- is typed
            sender.sendMessage("The following kits are available:");

            plugin.kitManager.listAllKits(p);

            sender.sendMessage("Hover over Kits in the to see their description and §cclick on them in the chat §rto choose them.");
            sender.sendMessage("Alternatively you can choose a kit by typing: §c/kit [kit]");

            return true;
        }



        return true;
    }


}
