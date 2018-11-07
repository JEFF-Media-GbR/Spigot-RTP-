package de.jeffclan.JeffRTPPlus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

	RTPPlusPlugin plugin;
	
	public CommandExecutor(RTPPlusPlugin plugin) {
		this.plugin=plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		
		Player playerCandidate;
		
		if(!command.getName().equalsIgnoreCase("rtp")) {
			plugin.getLogger().warning("The CommandExecutor has been assigned to a command it cannot handle.");
			return false;
		}
		
		if(!(sender instanceof Player)) {
			if(args != null && args.length>0 && plugin.getServer().getPlayer(args[0]) != null) {
				sender.sendMessage("Not yet integrated.");
				return true;
			}
		}
		
		return false;
	}

}
