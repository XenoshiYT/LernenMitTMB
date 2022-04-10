package tmb.learn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import tmb.learn.util.LocationBuilder;

public class ConnectionListener implements Listener {

    @EventHandler
    public void handleJoinConnection(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage("§5SERVER" + " §e" + p.getName() + " §7ist beigetreten");
        LocationBuilder locationBuilder = new LocationBuilder("spawn", "main");
        if(locationBuilder.loadLocation() != null){
            p.teleport(locationBuilder.loadLocation());
        }else{
            p.sendMessage("§8[§4§lERROR§8] §cDer Spawn wurde noch nicht gesetzt!");
        }
    }

    @EventHandler
    public void handleQuitConnection(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§5SERVER" + " §e" + p.getName() + " §7hat verlassen");
    }

}
