package com.backslide999.library;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;

public interface PlaceHolderExtension {

    public default void registerPlaceHolderAPI(PlaceholderExpansion expansion, BasePlugin plugin){
        try{
            boolean enabled = plugin.fetchConfigBoolean("api.placeholder.enabled");
            if(!enabled){
                plugin.logInfo("Placeholder API disabled");
                return;
            } else{
                plugin.logInfo("Registering Placeholder API");
                if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
                    expansion.register();
                    plugin.logInfo("Placeholder API successfuly registered");
                } else {
                    plugin.logWarning("Could not find PlaceholderAPI. PlacehodlerAPI not registered. Please disable in config.yml");
                    return;
                }
            }
        } catch (Throwable T){
            plugin.logWarning(T.getMessage());
        }
    }
}
