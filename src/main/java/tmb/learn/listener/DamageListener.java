package tmb.learn.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.ArrayList;

public class DamageListener implements Listener {

    private static ArrayList<EntityType> entityList = new ArrayList<>();

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();

            if(e.getCause().equals(null)) return;

            String damageName = e.getCause().name();
            Double damageAmount = e.getDamage();
            p.sendMessage("§7Du hast §c" + damageAmount + " §7Schaden in Form von §e" + damageName + " §7bekommen");
        }
    }

    @EventHandler
    public void handleEntityDamageByEntity(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(e.getDamager().equals(null) || e.getCause().equals(null)) return;
            Double damageAmount = e.getDamage();

            Entity entity = e.getDamager();

            for(int i = 0; i < entityList.size(); i++){
                if(entity.getType() == entityList.get(i)){
                    p.sendMessage("§7Du hast §c" + damageAmount + " §7Schaden von einem §e" + entityList.get(i).name() + " §7bekommen");
                }
            }
        }
    }

    @EventHandler
    public void handleEntitySpawn(EntitySpawnEvent e){
        putEntitysInArray(e.getEntity().getType());
    }

    public static void putEntitysInArray(EntityType entityType){
        if(!entityList.contains(entityType)) {
            entityList.add(entityType);
        }
    }

}
