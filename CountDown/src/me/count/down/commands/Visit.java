package me.count.down.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Visit implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
		String CommandLabel, String[] args) {
		Player player = (Player) sender;
		if (CommandLabel.equalsIgnoreCase("cdvisit")) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.GOLD
				+ "Visit this link: http://dev.bukkit.org/bukkit-plugins/countdown-basic-ita/polls/do-you-like-this-plugin/");
			}
		}
	return false;
	}
}