package tmb.learn.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tmb.learn.commands.HealCommand;
import tmb.learn.listener.DamageListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        init(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {

    }

    private void init(PluginManager pluginManager){
        getCommand("heal").setExecutor(new HealCommand());

        pluginManager.registerEvents(new DamageListener(), this);
    }
}
