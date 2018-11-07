package de.jeffclan.JeffRTPPlus;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class RTPPlusPlugin extends JavaPlugin {
	
	// Lists and stuff
	protected ArrayList<Material> unsafeBlocks;
	protected ArrayList<String> disabledWorlds;
	
	// Settings that can be changed via config
	protected int cooldownDelay;
	protected boolean spawnBlockMustBeSolid;
	protected int minx, maxx, minz, maxz;
	
	// Debug mode
	protected boolean debug = true;
	
	public void createConfig() {
		saveDefaultConfig();
		
		getConfig().addDefault("cooldown-delay", 30);
		getConfig().addDefault("spawn-block-must-be-solid", true);
		getConfig().addDefault("min-x", -50000);
		getConfig().addDefault("max-x", 50000);
		getConfig().addDefault("min-z", -50000);
		getConfig().addDefault("max-z", 50000);
		
		cooldownDelay = getConfig().getInt("cooldown-delay");
		disabledWorlds = (ArrayList<String>) getConfig().getStringList("disabled-worlds");
		minx = getConfig().getInt("min-x");
		maxx = getConfig().getInt("max-x");
		minz = getConfig().getInt("min-z");
		maxz = getConfig().getInt("max-z");
		
		ArrayList<String> unsafeBlockNames = (ArrayList<String>) getConfig().getStringList("unsafe-blocks");
		for(String materialName : unsafeBlockNames.toArray(new String[unsafeBlockNames.size()])) {
			Material candidate = Material.matchMaterial(materialName);
			if(candidate == null || candidate == Material.AIR) {
				getLogger().warning(String.format("%s is not a valid material name, ignoring...", materialName));
				continue;
			}
			unsafeBlocks.add(candidate);
			if(debug) getLogger().info(String.format("+ %s has been to the list of unsafe blocks.", candidate.name()));
		}
		
		
		
	}
	
	public void onEnable() {
		unsafeBlocks = new ArrayList<Material>();
		
		
	}

}
