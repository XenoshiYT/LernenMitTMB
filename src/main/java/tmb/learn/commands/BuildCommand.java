package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tmb.learn.util.LocationBuilder;

import java.util.ArrayList;

public class BuildCommand implements CommandExecutor {

    public static ArrayList<Player> buildList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(buildList.contains(p)){
                    buildList.remove(p);
                    p.sendMessage("§7Du kannst nicht mehr bauen");
                }else{
                    buildList.add(p);
                    p.sendMessage("§7Du kannst nun bauen");
                }
            }else if(args.length == 1){
                Player t = Bukkit.getPlayerExact(args[0]);
                if(t.isOnline() || t != null){
                    if(buildList.contains(t)){
                        buildList.remove(t);
                        p.sendMessage("§6" + t.getName() + " §7kann nicht mehr bauen");
                        t.sendMessage("§7Du kannst nicht mehr bauen");
                    }else{
                        buildList.add(t);
                        p.sendMessage("§6" + t.getName() + " §7kann nun bauen");
                        t.sendMessage("§7Du kannst nun bauen");
                    }
                }
            }
        }

        return false;
    }
}
