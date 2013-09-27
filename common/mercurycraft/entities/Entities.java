package mercurycraft.entities;

import mercurycraft.MercuryCraft;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

	public static void init() {
		EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, MercuryCraft.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", 1, MercuryCraft.instance, 80, 3, true);
	}
	
}
