package tmb.learn.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("lern.gamemode")){
                if(args.length == 1){
                    if (args[0].equalsIgnoreCase("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage("§7Du bist nun im §eSurvival§7-Mode");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage("§7Du bist nun im §eCreative§7-Mode");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage("§7Du bist nun im §eAdventure§7-Mode");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage("§7Du bist nun im §eSpectator§7-Mode");
                    }else{
                        p.sendMessage("§7Gebe den Command richtig ein: /gm <0, 1, 2, 3>");
                    }
                }else if(args.length == 2){
                    Player t = Bukkit.getPlayerExact(args[1]);
                    if(t.isOnline() || t != null) {
                        if (args[0].equalsIgnoreCase("0")) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage("§7Du bist nun im §eSurvival§7-Mode");
                        } else if (args[0].equalsIgnoreCase("1")) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage("§7Du bist nun im §eCreative§7-Mode");
                        } else if (args[0].equalsIgnoreCase("2")) {
                            t.setGameMode(GameMode.ADVENTURE);
                            t.sendMessage("§7Du bist nun im §eAdventure§7-Mode");
                        } else if (args[0].equalsIgnoreCase("3")) {
                            t.setGameMode(GameMode.SPECTATOR);
                            t.sendMessage("§7Du bist nun im §eSpectator§7-Mode");
                        }else{
                            p.sendMessage("§7Gebe den Command richtig ein: /gm <0, 1, 2, 3>");
                        }
                    }else{
                        p.sendMessage("§cDer Spieler ist nicht online");
                    }
                }else{
                    p.sendMessage("§7Gebe den Command richtig ein: /gm <0, 1, 2, 3>");
                }
            }
        }else {
            if(args.length == 2){
                Player t = Bukkit.getPlayerExact(args[1]);
                if(t.isOnline() || t != null) {
                    if (args[0].equalsIgnoreCase("0")) {
                        t.setGameMode(GameMode.SURVIVAL);
                        t.sendMessage("§7Du bist nun im §eSurvival§7-Mode");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        t.setGameMode(GameMode.CREATIVE);
                        t.sendMessage("§7Du bist nun im §eCreative§7-Mode");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        t.setGameMode(GameMode.ADVENTURE);
                        t.sendMessage("§7Du bist nun im §eAdventure§7-Mode");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        t.setGameMode(GameMode.SPECTATOR);
                        t.sendMessage("§7Du bist nun im §eSpectator§7-Mode");
                    }else{
                        sender.sendMessage("§7Gebe den Command richtig ein: /gm <0, 1, 2, 3>");
                    }
                }else{
                    sender.sendMessage("§cDer Spieler ist nicht online");
                }
            }else{
                sender.sendMessage("§7Gebe den Command richtig ein: /gm <0, 1, 2, 3>");
            }
        }

        return false;
    }
}
