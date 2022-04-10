package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RealoadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("lern.reload")) {
            Bukkit.reload();
            sender.sendMessage("§7Server wurde reloadet");
        }

        return false;
    }
}
