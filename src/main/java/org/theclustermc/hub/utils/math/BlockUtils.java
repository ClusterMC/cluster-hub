package org.theclustermc.hub.utils.math;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {

	public static Location[] setBlocksGetLocations(Player player){
		LocationIterator iter = new LocationIterator(player.getWorld(), player.getLocation().toVector(),
				player.getLocation().clone().getDirection().setY(0), 0, 4);
		List<Location> locations = new ArrayList<>();
		iter.next();
		while(iter.hasNext()){
			Location loc = iter.next();
			locations.add(loc);
			/*player.sendBlockChange(loc, Material.AIR, (byte) 0);
			locations.add(loc.clone().subtract(0,1,0));*/
			player.sendBlockChange(loc.clone().subtract(0,1,0), Material.ENDER_PORTAL, (byte) 0);
		}
		return locations.toArray(new Location[locations.size()]);
	}
}
