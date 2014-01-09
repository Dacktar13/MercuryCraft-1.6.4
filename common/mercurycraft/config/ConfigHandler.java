package mercurycraft.config;

import java.io.File;

import mercurycraft.blocks.BlockInfo;
import mercurycraft.fluid.FluidInfo;
import mercurycraft.items.ItemInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler extends Configuration {
	public static MercuryCraftConfiguration config;

	public static boolean canMercuryBurn;
	public static double mercuryWellScalar;
	

	public static void init(File file) {
		config = new MercuryCraftConfiguration(file);

		config.load();

		// Set Block ID's
		BlockInfo.BATTERY_BOX_ID = config.getBlock(BlockInfo.BATTERY_BOX_KEY,
				BlockInfo.BATTERY_BOX_DEFAULT).getInt();
		BlockInfo.MERCURY_ORE_ID = config.getBlock(BlockInfo.MERCURY_ORE_KEY,
				BlockInfo.MERCURY_ORE_DEFAULT).getInt();
		BlockInfo.MERCURY_ENGINE_ID = config.getBlock(
				BlockInfo.MERCURY_ENGINE_KEY, BlockInfo.MERCURY_ENGINE_DEFAULT)
				.getInt();
		BlockInfo.BOMB_ID = config.getBlock(BlockInfo.BOMB_KEY,
				BlockInfo.BOMB_DEFAULT).getInt();

		// Set Item ID's
		ItemInfo.MERCURY_INGOT_ID = config.getItem(ItemInfo.MERCURY_INGOT_KEY,
				ItemInfo.MERCURY_INGOT_DEFAULT).getInt() - 256;
		ItemInfo.MERCURY_WAND_ID = config.getItem(ItemInfo.MERCURY_WAND_KEY,
				ItemInfo.MERCURY_WAND_DEFAULT).getInt() - 256;
		ItemInfo.MERCURY_STICK_ID = config.getItem(ItemInfo.MERCURY_STICK_KEY,
				ItemInfo.MERCURY_STICK_DEFAULT).getInt() - 256;
		ItemInfo.CARD_ID = config.getItem(ItemInfo.CARD_KEY,
				ItemInfo.CARD_DEFAULT).getInt() - 256;
		// ItemInfo.MERCURY_PIPE_ID = config.getItem(ItemInfo.MERCURY_PIPE_KEY,
		// ItemInfo.MERCURY_PIPE_DEFAULT).getInt() - 256;

		config.save();
	}

	public static void fluidInit(File file) {
		config = new MercuryCraftConfiguration(file);

		config.load();

		FluidInfo.MERCURY_FLUID_ID = config.getBlock(
				FluidInfo.MERCURY_FLUID_KEY, FluidInfo.MERCURY_FLUID_DEFAULT)
				.getInt();
		FluidInfo.MERCURY_BUCKET_ID = config.getItem(
				FluidInfo.MERCURY_BUCKET_KEY, FluidInfo.MERCURY_BUCKET_DEFAULT)
				.getInt() - 256;
		FluidInfo.BIOME_MERCURY_DESERT_ID = config.get("biomes",
				FluidInfo.BIOME_MERCURY_DESERT_KEY,
				FluidInfo.BIOME_MERCURY_DESERT_DEFAULT).getInt();
		FluidInfo.BIOME_MERCURY_OCEAN_ID = config.get("biomes",
				FluidInfo.BIOME_MERCURY_OCEAN_KEY,
				FluidInfo.BIOME_MERCURY_OCEAN_DEFAULT).getInt();

		canMercuryBurn = config.get(Configuration.CATEGORY_GENERAL, "burnMercury",
				true, "Can mercury burn?").getBoolean(true);
		mercuryWellScalar = config.get(Configuration.CATEGORY_GENERAL,
				"mercuryWellGenerationRate", 1.0,
				"Probability of mercury well generation").getDouble(1.0);

		config.save();
	}
}
