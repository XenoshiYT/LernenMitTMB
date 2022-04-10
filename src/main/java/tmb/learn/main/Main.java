package tmb.learn.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tmb.learn.commands.*;
import tmb.learn.listener.BuildListener;
import tmb.learn.listener.ConnectionListener;
import tmb.learn.listener.DamageListener;
import tmb.learn.listener.DeathListener;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        init(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {

    }

    private void init(PluginManager pluginManager){
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("reload").setExecutor(new RealoadCommand());
        getCommand("r").setExecutor(new RealoadCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("build").setExecutor(new BuildCommand());

        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new ConnectionListener(), this);
        pluginManager.registerEvents(new BuildListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);

        DamageListener.putBlocksInArray();
    }

    public static Main getInstance() {
        return instance;
    }
}
