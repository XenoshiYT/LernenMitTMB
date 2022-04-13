package tmb.learn.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tmb.learn.main.Main;

import java.util.HashMap;

public class CommandCooldownBuilder {

    private HashMap<Player, String> cooldownMap = new HashMap<>();
    private Player p;
    private String command;

    public CommandCooldownBuilder(Player p, String command){
        this.p = p;
        this.command = command;
    }

    public void putPlayerInHashMap(){
        cooldownMap.put(p, command);
        removePlayerFromHashMap();

        p.sendMessage("test put");
    }

    public void removePlayerFromHashMap(){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                cooldownMap.remove(p, command);
                p.sendMessage("test remove");
            }
        }, 20*5);
    }

    public Boolean isPlayerInHashMap(){
        if(cooldownMap.containsKey(p) && cooldownMap.get(p).contains(command)){
            p.sendMessage("test true");
            return true;
        }else{
            p.sendMessage("test false");
            return false;
        }
    }

}
