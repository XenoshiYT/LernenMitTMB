package tmb.learn.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SignCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length >= 1){
                if(p.getInventory().getItemInMainHand().getType() != Material.AIR || !p.getInventory().getItemInMainHand().equals(null)){
                    SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
                    String odate = date.format(new Date());
                    ItemStack itemStack = p.getInventory().getItemInMainHand();
                    String name = null;
                    for(int i = 0; i < args.length; i++){
                        name = name + args[i] + " ";
                    }

                    itemStack.getItemMeta().setLore(Arrays.asList("", name.replace("&", "§"), "§7-------------------------------------------", "§7Signiert von §e§l" + p.getName() + " §7am §a§l" + odate));
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
