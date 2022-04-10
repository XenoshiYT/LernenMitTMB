package tmb.learn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import tmb.learn.commands.BuildCommand;

public class BuildListener implements Listener {

    @EventHandler
    public void handleBlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(BuildCommand.buildList.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void handleBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(BuildCommand.buildList.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
