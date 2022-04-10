package tmb.learn.commands;

import net.minecraft.server.v1_16_R3.MinecraftKey;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EnchantCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 2){
                if(p.getInventory().getItemInMainHand().getType() != Material.AIR || !p.getInventory().getItemInMainHand().equals(null)){
                    ItemStack itemStack = p.getInventory().getItemInMainHand();
                    Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(args[0]));
                    Integer level = 0;
                    try {
                        level = Integer.parseInt(args[1]);
                    }catch (NumberFormatException e){ p.sendMessage("§c" + args[1] + " §7ist keine Zahl"); return true; }

                    try{
                        itemStack.addUnsafeEnchantment(enchantment, level);
                    }catch (IllegalArgumentException e1) { p.sendMessage("§c" + args[0] + " §7ist kein Enchantment"); return true; }
                }else{
                    p.sendMessage("§7Du hast kein richtiges Item in der Hand");
                }
            }else{
                p.sendMessage("§7Benutze den Command gefolgt: /ench <enchantment> <level>");
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        if(args.length == 0) return arrayList;
        if(args.length == 1) {
            arrayList.add("aqua_affinity");
            arrayList.add("bane_of_arthropods");
            arrayList.add("blast_protection");
            arrayList.add("channeling");
            arrayList.add("binding_curse");
            arrayList.add("vanishing_curse");
            arrayList.add("depth_strider");
            arrayList.add("efficiency");
            arrayList.add("feather_falling");
            arrayList.add("fire_aspect");
            arrayList.add("fire_protection");
            arrayList.add("flame");
            arrayList.add("fortune");
            arrayList.add("frost_walker");
            arrayList.add("impaling");
            arrayList.add("infinity");
            arrayList.add("knockback");
            arrayList.add("looting");
            arrayList.add("loyalty");
            arrayList.add("luck_of_the_sea");
            arrayList.add("lure");
            arrayList.add("mending");
            arrayList.add("multishot");
            arrayList.add("piercing");
            arrayList.add("power");
            arrayList.add("projectile_protection");
            arrayList.add("protection");
            arrayList.add("punch");
            arrayList.add("quick_charge");
            arrayList.add("respiration");
            arrayList.add("riptide");
            arrayList.add("sharpness");
            arrayList.add("silk_touch");
            arrayList.add("smite");
            arrayList.add("soul_speed");
            arrayList.add("sweeping");
            arrayList.add("thorns");
            arrayList.add("unbreaking");
        }

        return arrayList;
    }
}
