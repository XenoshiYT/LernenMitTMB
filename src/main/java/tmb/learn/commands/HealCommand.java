package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                p.setHealth(20);
                p.setFoodLevel(20);
                p.setSaturation(20);
                p.sendMessage("§7Du hast dich geheilt");
            }else if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[1]);
                if(t.isOnline() || t == null) {
                    p.sendMessage("§cDer Spieler ist nicht online");
                    return true;
                }
                t.setHealth(20);
                t.setFoodLevel(20);
                t.setSaturation(20);
                p.sendMessage("§7Du hast §6" + t.getName() + " §7geheilt");
            }else{
                sender.sendMessage("§7Benutze den Command /heal <player>");
            }
        }else {
            if(args.length == 0){
                sender.sendMessage("§7Benutze den Command /heal <player>");
            }else if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[1]);
                if(!t.isOnline() || t == null) {
                    sender.sendMessage("§cDer Spieler ist nicht online");
                    return true;
                }
                t.setHealth(20);
                t.setFoodLevel(20);
                t.setSaturation(20);
                sender.sendMessage("§7Du hast §6" + t.getName() + " §7geheilt");
            }else{
                sender.sendMessage("§7Benutze den Command /heal <player>");
            }
        }

        return false;
    }
}
