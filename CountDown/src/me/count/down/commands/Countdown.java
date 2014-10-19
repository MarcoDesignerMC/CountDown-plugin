package me.count.down.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Countdown implements CommandExecutor{
	public int startCount = 0;

	
	@Override
		public boolean onCommand(CommandSender sender, Command cmd,
				String CommandLabel, String[] args) {
		Player player = (Player) sender;
		if (CommandLabel.equalsIgnoreCase("countdown")) {
			if(args.length == 0){
				if (player.hasPermission("cd.start")){
					player.sendMessage(ChatColor.DARK_RED + "Usage: /countdown <seconds>");
				}else{
					player.sendMessage(ChatColor.DARK_RED + "You don't have permission!");
				}
			}else{
				if(player.hasPermission("cd.start")){
					startCount = Integer.parseInt(args[0]);
					Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " Has started a countdown from " + startCount);
					while(startCount != 0){
						Bukkit.broadcastMessage(ChatColor.GOLD + "" + startCount);
						startCount--;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					while(startCount == 0){
						Bukkit.broadcastMessage(ChatColor.GOLD + "GOOOO!!!");
						sender.sendMessage(ChatColor.AQUA + "Your countdown is finished...");
						break;
					}
				}else{
					player.sendMessage(ChatColor.DARK_RED + "You don't have permission");
				}
			}
		}
		return false;
	}
	}