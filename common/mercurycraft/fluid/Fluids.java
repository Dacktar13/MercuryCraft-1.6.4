package mercurycraft.fluid;

import mercurycraft.world.BiomeGenMercuryDesert;
import mercurycraft.world.BiomeGenMercuryOcean;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {

	public static boolean spawnMercurySprings = true;
	public static Fluid fluidMercury;
	public static BiomeGenMercuryDesert biomeMercuryDesert;
	public static BiomeGenMercuryOcean biomeMercuryOcean;
	public static boolean canMercuryBurn;

	public static void init() {
		fluidMercury = new fluidMercury(FluidInfo.MERCURY_FLUID_ID);

		canMercuryBurn = ?.get(Configuration.CATEGORY_GENERAL,
				"burnmercury", true, "Can mercury burn?").getBoolean(true);
		
		
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		if (blockMercury != null && bucketmercuryId > 0) {
			bucketmercury = new ItemBucketBuildcraft(bucketmercuryId, blockMercury.blockID);
			bucketmercury.setUnlocalizedName("bucketmercury").setContainerItem(
					Item.bucketEmpty);
			LanguageRegistry.addName(bucketmercury, "mercury Bucket");
			FluidContainerRegistry.registerFluidContainer(
					FluidRegistry.getFluidStack("mercury",
							FluidContainerRegistry.BUCKET_VOLUME),
					new ItemStack(bucketmercury), new ItemStack(Item.bucketEmpty));
		}

	}

	public static void addNames() {
		LanguageRegistry.addName(fluidMercury, FluidInfo.MERCURY_FLUID_NAME);
	}

	class BiomeIdException extends RuntimeException {

		public BiomeIdException(String biome, int id) {
			super(String.format("You have a Biome Id conflict at %d for %s",
					id, biome));

			if (FluidInfo.BIOME_MERCURY_DESERT_ID > 0) {
				if (BiomeGenBase.biomeList[FluidInfo.BIOME_MERCURY_DESERT_ID] != null) {
					throw new BiomeIdException(
							FluidInfo.BIOME_MERCURY_DESERT_KEY,
							FluidInfo.BIOME_MERCURY_DESERT_ID);
				}
				biomeMercuryDesert = BiomeGenMercuryDesert
						.makeBiome(FluidInfo.BIOME_MERCURY_DESERT_ID);

				if (FluidInfo.BIOME_MERCURY_OCEAN_ID > 0) {
					if (BiomeGenBase.biomeList[FluidInfo.BIOME_MERCURY_OCEAN_ID] != null) {
						throw new BiomeIdException(
								FluidInfo.BIOME_MERCURY_OCEAN_KEY,
								FluidInfo.BIOME_MERCURY_OCEAN_ID);
					}
					biomeMercuryOcean = BiomeGenMercuryOcean
							.makeBiome(FluidInfo.BIOME_MERCURY_OCEAN_ID);

				}
			}
		}
	}

}
