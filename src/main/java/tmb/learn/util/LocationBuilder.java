package tmb.learn.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import tmb.learn.main.Main;

import java.io.File;
import java.io.IOException;

public class LocationBuilder {

    private Location location;
    private String root;
    private File file;
    private YamlConfiguration cfg;

    public LocationBuilder(String name, Location location, String root){
        this.location = location;
        this.root = root;
        this.file = new File("plugins/learning/locations", name + ".yml");
        this.cfg = YamlConfiguration.loadConfiguration(file);
    }

    public LocationBuilder(String name, String root){
        this(name, null, root);
    }

    public void saveLocation(){
        cfg.set(root + ".World", location.getWorld().getName());
        cfg.set(root + ".X", location.getX());
        cfg.set(root + ".Y", location.getY());
        cfg.set(root + ".Z", location.getZ());
        cfg.set(root + ".Yaw", location.getYaw());
        cfg.set(root + ".Pitch", location.getPitch());
        saveFile();
    }

    public Location loadLocation(){
        if(cfg.contains(root)) {
            World world = Bukkit.getWorld(cfg.getString(root + ".World"));
            double x = cfg.getDouble(root + ".X");
            double y = cfg.getDouble(root + ".Y");
            double z = cfg.getDouble(root + ".Z");
            float yaw = (float) cfg.getDouble(root + ".Yaw");
            float pitch = (float) cfg.getDouble(root + ".Pitch");
            return new Location(world, x, y, z, yaw, pitch);
        }else{
            return null;
        }
    }

    private void saveFile(){
        try { cfg.save(file); } catch (IOException e) { e.printStackTrace(); }
    }

}
