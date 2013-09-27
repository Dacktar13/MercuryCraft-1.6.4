package mercurycraft.config;

import java.io.File;

import buildcraft.BuildCraftCore;
import buildcraft.core.DefaultProps;

import mercurycraft.blocks.BlockInfo;
import mercurycraft.fluid.FluidInfo;
import mercurycraft.items.ItemInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();

		// Set Block ID's
		BlockInfo.BATTERY_BOX_ID = config.getBlock(BlockInfo.BATTERY_BOX_KEY,
				BlockInfo.BATTERY_BOX_DEFAULT).getInt();
		BlockInfo.MERCURY_ORE_ID = config.getBlock(BlockInfo.MERCURY_ORE_KEY,
				BlockInfo.MERCURY_ORE_DEFAULT).getInt();
		BlockInfo.MERCURY_ENGINE_ID = config.getBlock(
				BlockInfo.MERCURY_ENGINE_KEY, BlockInfo.MERCURY_ENGINE_DEFAULT)
				.getInt();
		BlockInfo.MACHINE_ID = config.getBlock(BlockInfo.MACHINE_KEY,
				BlockInfo.MACHINE_DEFAULT).getInt();
		BlockInfo.BOMB_ID = config.getBlock(BlockInfo.BOMB_KEY,
				BlockInfo.BOMB_DEFAULT).getInt();
		BlockInfo.POISON_ID = config.getBlock(BlockInfo.POISON_KEY,
				BlockInfo.POISON_DEFAULT).getInt();
		BlockInfo.MERCURY_BLOCK_ID = config.getBlock(
				BlockInfo.MERCURY_BLOCK_KEY, BlockInfo.MERCURY_BLOCK_DEFAULT)
				.getInt();

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
		ItemInfo.MERCURY_BUCKET_ID = config.getItem(
				ItemInfo.MERCURY_BUCKET_KEY, ItemInfo.MERCURY_BUCKET_DEFAULT)
				.getInt() - 256;

		FluidInfo.BIOME_MERCURY_DESERT_ID = config.get("biomes",
				FluidInfo.BIOME_MERCURY_DESERT_KEY,
				FluidInfo.BIOME_MERCURY_DESERT_DEFAULT).getInt(
				FluidInfo.BIOME_MERCURY_DESERT_DEFAULT);
		FluidInfo.BIOME_MERCURY_OCEAN_ID = config.get("biomes",
				FluidInfo.BIOME_MERCURY_OCEAN_KEY,
				FluidInfo.BIOME_MERCURY_OCEAN_DEFAULT).getInt(
				FluidInfo.BIOME_MERCURY_OCEAN_DEFAULT);

		int defaultmercuryId = FluidInfo.MERCURY_FLUID_ID;
		if (ConfigHandler.hasKey(Configuration.CATEGORY_BLOCK,
				"mercuryStill.id")) {
			defaultmercuryId = config.get(Configuration.CATEGORY_BLOCK,
					"mercuryStill.id", defaultmercuryId).getInt(
					defaultmercuryId);
			ConfigHandler.getCategory(Configuration.CATEGORY_BLOCK).remove(
					"mercuryStill.id");
		}

		config.save();
	}

}
