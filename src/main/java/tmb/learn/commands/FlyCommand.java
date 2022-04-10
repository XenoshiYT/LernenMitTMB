package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(p.getAllowFlight()){
                    p.setAllowFlight(false);
                    p.sendMessage("§cDu kannst nicht mehr fliegen");
                }else{
                    p.setAllowFlight(true);
                    p.sendMessage("§aDu kannst nun fliegen");
                }
            }else if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[1]);
                if(t.isOnline() || t == null) {
                    p.sendMessage("§cDer Spieler ist nicht online");
                    return true;
                }
                if(t.getAllowFlight()){
                    t.setAllowFlight(false);
                    t.sendMessage("§cDu kannst nicht mehr fliegen");
                    p.sendMessage("§6" + t.getName() + " §7kann nicht mehr fliegen");
                }else{
                    t.setAllowFlight(true);
                    t.sendMessage("§aDu kannst nun fliegen");
                    p.sendMessage("§6" + t.getName() + " §7kann nun fliegen");
                }
            }else{
                sender.sendMessage("§7Benutze den Command /fly <player>");
            }
        }else {
            if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[1]);
                if(t.isOnline() || t == null) {
                    sender.sendMessage("§cDer Spieler ist nicht online");
                    return true;
                }
                if(t.getAllowFlight()){
                    t.setAllowFlight(false);
                    t.sendMessage("§cDu kannst nicht mehr fliegen");
                    sender.sendMessage("§6" + t.getName() + " §7kann nicht mehr fliegen");
                }else{
                    t.setAllowFlight(true);
                    t.sendMessage("§aDu kannst nun fliegen");
                    sender.sendMessage("§6" + t.getName() + " §7kann nun fliegen");
                }
            }else{
                sender.sendMessage("§7Benutze den Command /fly <player>");
            }
        }

        return false;
    }
}
