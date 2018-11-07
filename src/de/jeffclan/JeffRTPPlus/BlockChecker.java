package de.jeffclan.JeffRTPPlus;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockChecker {
	
	private RTPPlusPlugin plugin;
	
	public BlockChecker(RTPPlusPlugin plugin) {
		this.plugin=plugin;
	}
	
	public boolean isValidSpawnLocation(Block block) {
		
		Material material = block.getType();
		
		if(plugin.unsafeBlocks.contains(material)) {
			if(plugin.debug) {
				plugin.getLogger().info(String.format("%s is not a valid spawn, because its type %s is an unsafe block.",block.getLocation().toString(),material.name()));
			}
			return false;
		}
		
		int blockx = block.getLocation().getBlockX();
		int blockz = block.getLocation().getBlockY();
		
		if(blockx > plugin.maxx || blockx < plugin.minx || blockz > plugin.maxz || blockz < plugin.minz) {
			if(plugin.debug) {
				plugin.getLogger().info(String.format("%s is not a valid spawn, because it is outside the defined border.",block.getLocation().toString()));
			}
			return false;
		}
		
		if(plugin.debug) {
			plugin.getLogger().info(String.format("%s is a valid spawn.",block.getLocation().toString()));
		}
		
		return true;
		
	}

}
