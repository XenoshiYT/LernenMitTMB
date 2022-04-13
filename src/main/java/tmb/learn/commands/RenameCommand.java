package tmb.learn.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length >= 1){
                if(p.getInventory().getItemInMainHand().getType() != Material.AIR || !p.getInventory().getItemInMainHand().equals(null)){
                    ItemStack itemStack = p.getInventory().getItemInMainHand();
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    String name = "";
                    for(int i = 0; i < args.length; i++){
                        name = name + args[i] + " ";
                    }

                    itemMeta.setDisplayName(name.replace("&", "§"));
                    itemStack.setItemMeta(itemMeta);
                }else{
                    p.sendMessage("§7Du hast kein richtiges Item in der Hand");
                }
            }else{
                p.sendMessage("§7Benutze den Command gefolgt: /rename <name>");
            }
        }

        return false;
    }
}
