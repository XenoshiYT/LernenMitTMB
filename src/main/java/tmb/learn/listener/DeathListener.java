package tmb.learn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import tmb.learn.util.LocationBuilder;
import tmb.learn.util.RespawnBuilder;

public class DeathListener implements Listener {

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        RespawnBuilder.respawn(p);
        LocationBuilder locationBuilder = new LocationBuilder("spawn", "main");
        if(locationBuilder.loadLocation() != null){
            p.teleport(locationBuilder.loadLocation());
        }else{
            p.sendMessage("§8[§4§lERROR§8] §cDer Spawn wurde noch nicht gesetzt!");
        }
    }

}
