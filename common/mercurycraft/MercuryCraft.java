package mercurycraft;

import mercurycraft.blocks.Blocks;
import mercurycraft.config.ConfigHandler;
import mercurycraft.entities.Entities;
import mercurycraft.items.Items;
import mercurycraft.network.PacketHandler;
import mercurycraft.proxies.CommonProxy;
import mercurycraft.world.GenerationHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * MercuryCraft
 * 
 * MercuryCraft
 * 
 * @author Dacktar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, useMetadata = false, acceptedMinecraftVersions = "[1.6,1.7)", dependencies = "required-after:Forge@[9.10.0.800,)")
@NetworkMod(channels = { ModInformation.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class MercuryCraft {

	@Instance(ModInformation.ID)
	public static MercuryCraft instance;

	@SidedProxy(clientSide = "mercurycraft.proxies.ClientProxy", serverSide = "mercurycraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		//Fluids.init();

		proxy.initSounds();
		proxy.initRenderers();

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		Items.addNames();
		Blocks.addNames();
		
		Items.registerRecipes();
		
		Blocks.registerTileEntities();
		
		Entities.init();
		
		new GenerationHandler();
	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {

	}
	
	

}
