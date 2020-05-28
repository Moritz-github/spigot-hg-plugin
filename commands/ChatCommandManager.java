package com.imdrops.xhg.commands;

        import com.imdrops.xhg.kits.Kit;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import com.imdrops.xhg.XHG;

        import java.lang.reflect.Constructor;

public class ChatCommandManager implements CommandExecutor {
    private XHG plugin;
    public ChatCommandManager(XHG plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        // /kit
        if(command.getName().equalsIgnoreCase("kit")){
            if(args.length == 1){

                Class kitClassPicked = plugin.kitManager.getKitClassFromString(args[0]);

                Player p = (Player) sender;

                if(kitClassPicked == null){
                    sender.sendMessage("§2Kit not found!");
                    return true;
                }
                try{
                    Constructor<Kit> kitConstructor = kitClassPicked.getConstructor(Player.class);
                    Kit kitInstantiated = kitConstructor.newInstance(p);
                    plugin.playerDataManager.registerKit(p, kitInstantiated);
                } catch (Exception e){
                    sender.sendMessage("§2There was an error!");
                    System.out.println(e.getMessage());
                }

                sender.sendMessage("§2Picked kit §c" + plugin.playerDataManager.getKit(p).getName());

                return true;
            }

            sender.sendMessage("§2The following kits are available:");
            for (Class c : plugin.kitManager.getKits()){
                sender.sendMessage("§a" + c.getSimpleName());
            }
            sender.sendMessage("§2You can choose a kit by typing: §c/kit [kit]");

            return true;
        }

        return true;
    }
}
