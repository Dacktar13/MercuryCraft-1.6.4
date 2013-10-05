package mercurycraft;

import mercurycraft.config.ConfigHandler;
import mercurycraft.fluid.Fluids;
import mercurycraft.network.PacketHandler;
import mercurycraft.proxies.CommonProxy;
import mercurycraft.world.BiomeGenMercuryDesert;
import mercurycraft.world.BiomeGenMercuryOcean;
import mercurycraft.world.MercuryPopulate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * MercuryCraft
 * 
 * LiquidMercury
 * 
 * @author Dacktar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = ModInformation.LM_ID, name = ModInformation.LM_NAME, version = ModInformation.VERSION, useMetadata = false, acceptedMinecraftVersions = "[1.6,1.7)", dependencies = "required-after:Forge@[9.10.0.800,)")
@NetworkMod(channels = { ModInformation.LM_CHANNEL }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
public class LiquidMercury {

	public static boolean spawnMercurySprings = true;
	public static BiomeGenMercuryDesert biomeMercuryDesert;
	public static BiomeGenMercuryOcean biomeMercuryOcean;
	private static Fluid mercurycraftFluidMercury;
	public static Fluid fluidMercury;
	public static Block blockMercuryLiquid;
	public static Item bucketMercury;
	public static boolean canMercuryBurn;
	public static double mercuryWellScalar;

	@Instance(ModInformation.LM_ID)
	public static LiquidMercury instance;

	@SidedProxy(clientSide = "mercurycraft.proxies.ClientProxy", serverSide = "mercurycraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ConfigHandler.fluidInit(event.getSuggestedConfigurationFile());

		Fluids.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		Fluids.addNames();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		if (MercuryCraft.modifyWorld) {
			MinecraftForge.EVENT_BUS.register(MercuryPopulate.INSTANCE);
			MinecraftForge.TERRAIN_GEN_BUS
					.register(new mercurycraft.world.BiomeInitializer());
		}
	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.textureType == 0) {
			mercurycraftFluidMercury.setIcons(
					blockMercuryLiquid.getBlockTextureFromSide(1),
					blockMercuryLiquid.getBlockTextureFromSide(2));
		}
	}

	@EventHandler
	public void processIMCRequests(FMLInterModComms.IMCEvent event) {
		mercurycraft.utils.InterModComms.processIMC(event);
	}
}