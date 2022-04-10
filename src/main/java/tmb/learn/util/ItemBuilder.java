package tmb.learn.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material, short subID){
        item = new ItemStack(material, 1, subID);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material material){
        this(material, (short) 0);
    }

    public ItemBuilder setName(String name){
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setAmount(Integer amount){
        item.setAmount(amount);

        return this;
    }

    public ItemBuilder setEnchantment(Enchantment enchantment, Integer level){
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder setColor(Color color){
        LeatherArmorMeta lmeta = (LeatherArmorMeta) meta;
        lmeta.setColor(color);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setUnbreakable(){
        meta.setUnbreakable(true);
        return this;
    }

    public ItemBuilder setOwner(String name){
        SkullMeta smeta = (SkullMeta)meta;
        smeta.setOwner(name);
        return this;
    }

    public ItemBuilder setOwnerURL(String url){
        SkullMeta smeta = (SkullMeta) meta;
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = smeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return this;
    }

    public ItemBuilder setFlag(ItemFlag... flag){
        meta.addItemFlags(flag);
        return this;
    }

    public ItemStack build(){
        item.setItemMeta(meta);
        return item;
    }
}
