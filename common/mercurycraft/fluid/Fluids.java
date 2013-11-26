package mercurycraft.fluid;

import mercurycraft.blocks.BlockInfo;
import mercurycraft.config.ConfigHandler;
import mercurycraft.items.ItemInfo;
import mercurycraft.proxies.CommonProxy;
import mercurycraft.world.BiomeGenMercuryDesert;
import mercurycraft.world.BiomeGenMercuryOcean;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {

	public static boolean spawnMercurySprings = true;
	public static BiomeGenMercuryDesert biomeMercuryDesert;
	public static BiomeGenMercuryOcean biomeMercuryOcean;
	private static Fluid mercurycraftFluidMercury;
	public static Fluid fluidMercury;
	public static Block blockMercuryLiquid;
	public static Item bucketMercury;
	public static boolean canMercuryBurn;
	public static double mercuryWellScalar;

	public static void init() {

		class BiomeIdException extends RuntimeException {

			public BiomeIdException(String biome, int id) {
				super(String.format(
						"You have a Biome Id conflict at %d for %s", id, biome));
			}
		}

		if (FluidInfo.BIOME_MERCURY_DESERT_ID > 0) {
			if (BiomeGenBase.biomeList[FluidInfo.BIOME_MERCURY_DESERT_ID] != null) {
				throw new BiomeIdException(FluidInfo.BIOME_MERCURY_DESERT_KEY,
						FluidInfo.BIOME_MERCURY_DESERT_ID);
			}
			biomeMercuryDesert = BiomeGenMercuryDesert
					.makeBiome(FluidInfo.BIOME_MERCURY_DESERT_ID);
		}

		if (FluidInfo.BIOME_MERCURY_OCEAN_ID > 0) {
			if (BiomeGenBase.biomeList[FluidInfo.BIOME_MERCURY_OCEAN_ID] != null) {
				throw new BiomeIdException(FluidInfo.BIOME_MERCURY_OCEAN_KEY,
						FluidInfo.BIOME_MERCURY_OCEAN_ID);
			}
			biomeMercuryOcean = BiomeGenMercuryOcean
					.makeBiome(FluidInfo.BIOME_MERCURY_OCEAN_ID);
		}

		// mercury
		mercurycraftFluidMercury = new Fluid("mercury").setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(mercurycraftFluidMercury);
		fluidMercury = FluidRegistry.getFluid("mercury");

		if (fluidMercury.getBlockID() == -1) {
			if (FluidInfo.BLOCK_MERCURY_FLUID_ID > 0) {
				blockMercuryLiquid = new BlockMercurycraftFluid(
						FluidInfo.BLOCK_MERCURY_FLUID_ID, fluidMercury,
						Material.water).setFlammable(canMercuryBurn)
						.setFlammability(0);
				blockMercuryLiquid.setUnlocalizedName(FluidInfo.BLOCK_MERCURY_FLUID_UNLOCALIZED_NAME);
				CommonProxy.proxy.addName(blockMercuryLiquid, "mercury");
				//LanguageRegistry.addName(blockMercuryLiquid, FluidInfo.BLOCK_MERCURY_FLUID_NAME);
				CommonProxy.proxy.registerBlock(blockMercuryLiquid);
				//GameRegistry.registerBlock(blockMercuryLiquid, FluidInfo.BLOCK_MERCURY_FLUID_KEY);
				fluidMercury.setBlockID(blockMercuryLiquid);
			}
		} else {
			blockMercuryLiquid = Block.blocksList[fluidMercury.getBlockID()];
		}

		if (blockMercuryLiquid != null) {
			Property mercurySpringsProp = ConfigHandler.config.get(
					Configuration.CATEGORY_GENERAL, "mercurySprings", true);
			spawnMercurySprings = mercurySpringsProp.getBoolean(true);
			BlockSpring.EnumSpring.MERCURY.canGen = spawnMercurySprings;
			BlockSpring.EnumSpring.MERCURY.liquidBlock = blockMercuryLiquid;
		}

		// Buckets

		if (blockMercuryLiquid != null && ItemInfo.MERCURY_BUCKET_ID > 0) {
			bucketMercury = new MercuryBucket(ItemInfo.MERCURY_BUCKET_ID,
					FluidInfo.BLOCK_MERCURY_FLUID_ID);

			FluidContainerRegistry.registerFluidContainer(FluidRegistry
					.getFluidStack("mercury",
							FluidContainerRegistry.BUCKET_VOLUME),
					new ItemStack(bucketMercury), new ItemStack(
							Item.bucketEmpty));
		}

		mercurycraft.fluid.BucketHandler.INSTANCE.buckets.put(
				blockMercuryLiquid, bucketMercury);
		MinecraftForge.EVENT_BUS
				.register(mercurycraft.fluid.BucketHandler.INSTANCE);

	}

	public static void addNames() {

		LanguageRegistry.addName(bucketMercury, ItemInfo.MERCURY_BUCKET_NAME);
	}

}