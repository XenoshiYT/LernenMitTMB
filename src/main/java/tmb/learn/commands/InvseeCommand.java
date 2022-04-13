package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[0]);
                if(t != null || t.isOnline()){
                    Inventory inventory = t.getInventory();
                    p.openInventory(inventory);
                }else{
                    p.sendMessage("§cDer Spieler ist nicht online");
                }
            }else{
                p.sendMessage("§7Benutze den Command gefolgt: /invsee <name>");
            }
        }

        return false;
    }
}
