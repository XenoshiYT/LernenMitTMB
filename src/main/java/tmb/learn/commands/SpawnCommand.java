package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tmb.learn.util.LocationBuilder;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                LocationBuilder locationBuilder = new LocationBuilder("spawn", "main");
                if(locationBuilder.loadLocation() != null){
                    p.teleport(locationBuilder.loadLocation());
                }else{
                    p.sendMessage("§8[§4§lERROR§8] §cDer Spawn wurde noch nicht gesetzt!");
                }
            }else if(args.length == 1){
                if(p.hasPermission("lern.setspawn")){
                    if(args[0].equalsIgnoreCase("set")){
                        new LocationBuilder("spawn", p.getLocation(), "main");
                        p.sendMessage("§7Du hast den §6Spawn §7gesetzt");
                    }
                }
            }
        }

        return false;
    }
}
