package me.count.down.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Timer implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		Player player = (Player) sender;
		
		if (CommandLabel.equalsIgnoreCase("timer")){
			
			//HA I PERMESSI
			if(args.length == 0){
				if (player.hasPermission("cd.timer")){
					int countStart = 0;
					Bukkit.broadcastMessage(player.getName() + " has started timer: " + countStart);
					countStart++;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(countStart <= 100){
						Bukkit.broadcastMessage(ChatColor.AQUA + "" + countStart);
					}else if(countStart > 100 && countStart <= 1000){
						Bukkit.broadcastMessage(ChatColor.YELLOW + "" + countStart);
					}else if(countStart > 1000){
						Bukkit.broadcastMessage(ChatColor.RED + "" + countStart);
					}
					
					
				//NON HA I PERMESSI	
				}else{
					player.sendMessage(ChatColor.DARK_RED + player.getDisplayName() + ", you don't have permission!");
				}
		
			}else{
				if(player.hasPermission("cd.timer")){
					player.sendMessage(ChatColor.RED + "The correct usage is: /timer .");
				}else{
					player.sendMessage(ChatColor.RED + player.getDisplayName() + ", you don't have permission!!");
				}
			}
		}
		
		return false;
	}
}
