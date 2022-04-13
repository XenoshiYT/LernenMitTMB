package tmb.learn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tmb.learn.util.CommandCooldownBuilder;

public class HilfeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player)sender;

            CommandCooldownBuilder cooldownBuilder = new CommandCooldownBuilder(p, "hilfe");
            if(!cooldownBuilder.isPlayerInHashMap()){
                cooldownBuilder.putPlayerInHashMap();
                sender.sendMessage("§7----------» §e§lTMB Hilfe §7«----------");
                sender.sendMessage("");
                sender.sendMessage("§8- §b/build §8| §7§oSetze deinen Baumodus um");
                sender.sendMessage("§8- §b/rl §8| §7§oReloade den Server");
                sender.sendMessage("§8- §b/gm §8| §7§oSetze deinen Gamemode um");
                sender.sendMessage("§8- §b/fly §8| §7§oSetze deinen Flugmodus");
                sender.sendMessage("§8- §b/spawn §8| §7§oTeleportiere dich zum Spawn");
                sender.sendMessage("§8- §b/spawn set §8| §7§oSetze den Spawn");
                sender.sendMessage("§8- §b/ench §8| §7§oEnchante deine Items");
                sender.sendMessage("§8- §b/heal §8| §7§oHeile dich oder andere Spieler");
                sender.sendMessage("");
                sender.sendMessage("§7----------» §e§lTMB Hilfe §7«----------");
            }else{
                p.sendMessage("§cDu musst noch warten bis zum nächsten mal");
            }
        }

        return false;
    }
}
