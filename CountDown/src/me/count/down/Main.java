package me.count.down;

import java.util.logging.Logger;

import me.count.down.commands.*;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
		
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public static Main plugin;
	
	public int startCount = 0;
		
		
		@Override
		public void onEnable() {
		
			//Comandi
			this.getCommand("countdown").setExecutor(new Countdown());
			this.getCommand("cdvisit").setExecutor(new Visit());
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " has been enabled.");
		}
		
		
		@Override
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " has been disabled.");
		}
	
}
	
	
