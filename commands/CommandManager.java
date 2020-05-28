package com.imdrops.xhg.commands;

        import com.imdrops.xhg.kits.Kit;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import com.imdrops.xhg.XHG;

public class CommandManager implements CommandExecutor {
    private XHG plugin;
    public CommandManager(XHG plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        // /kit
        if(command.getName().equalsIgnoreCase("kit")){
            if(args.length == 1){

                Kit kitPicked = plugin.kitManager.getKitFromString(args[0]);

                if(kitPicked == null){
                    sender.sendMessage("§2Kit not found!");
                    return true;
                }

                plugin.playerDataManager.registerKit((Player) sender, kitPicked);
                sender.sendMessage("§2Picked kit §c" + kitPicked.getName());

                return true;
            }

            sender.sendMessage("§2The following kits are available:");
            for (Kit k : plugin.kitManager.getKits()){
                sender.sendMessage("§a" + k.getName());
            }
            sender.sendMessage("§2You can choose a kit by typing: §c/kit [kit]");

            return true;
        }

        return true;
    }
}
