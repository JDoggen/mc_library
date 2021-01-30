package com.backslide999.library;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class BasePlugin extends JavaPlugin {

    public Boolean fetchConfigBoolean (final String path){
        return getConfig().getBoolean(path, false);
    }

    public Integer fetchConfigInteger (final String path){
        return getConfig().getInt(path, 0);
    }

    public List<String> fetchConfigStringList(final String path){
        return getConfig().getStringList(path);
    }

    public Object fetchConfigObject (final String path){
        return getConfig().get(path, null);
    }

    public String fetchConfigString (final String path){
        return getConfig().getString(path, "");
    }

    public void sendPlayerDefaultInfo(final CommandSender sender, final String path){
        this.sendPlayerInfo(sender,
                this.fetchConfigString("messages.info." + path)
        );
    }

    public void sendPlayerDefaultWarning(final CommandSender sender, final String path){
        this.sendPlayerWarning(sender,
                this.fetchConfigString("messages.warning." + path)
        );
    }

    public void sendPlayerInfo(CommandSender sender, Iterable<String> messages){
        messages.forEach( message -> this.sendPlayerInfo(sender, message));
    }

    public void sendPlayerInfo(final CommandSender sender, final Object message){
        final String finalMessage =
            new StringBuilder()
                .append(this.fetchConfigString("messages.prefix.info"))
                .append(message.toString())
                .toString();
        sender.sendMessage(finalMessage);
    }

    public void sendPlayerWarning(CommandSender sender, Iterable<String> messages){
        messages.forEach( message -> this.sendPlayerWarning(sender, message));
    }

    public void sendPlayerWarning(final CommandSender sender, final Object message){
        final String finalMessage =
                new StringBuilder()
                        .append(this.fetchConfigString("messages.prefix.warning"))
                        .append(message.toString())
                        .toString();
        sender.sendMessage(finalMessage);
    }

    public void logInfo(Object message){
        this.getLogger().info(message.toString());
    }

    public void logWarning(Object message){
        this.getLogger().warning(message.toString());
    }

}
