package mercurycraft.fluid;

import mercurycraft.config.ConfigHandler;
import mercurycraft.network.BucketHandler;
import mercurycraft.world.BiomeGenMercuryDesert;
import mercurycraft.world.BiomeGenMercuryOcean;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {

	public static boolean spawnMercurySprings = true;
	public static BiomeGenMercuryDesert biomeMercuryDesert;
	public static BiomeGenMercuryOcean biomeMercuryOcean;
	public static Fluid fluidMercury;
	public static Material materialFluidMercury;
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

		// mercury fluid

		fluidMercury = new Fluid(FluidInfo.MERCURY_FLUID_UNLOCALIZED_NAME)
				.setBlockID(FluidInfo.MERCURY_FLUID_ID);
		FluidRegistry.registerFluid(fluidMercury);

		materialFluidMercury = new MaterialLiquid(MapColor.clayColor);

		blockMercuryLiquid = new BlockFluidLiquid(FluidInfo.MERCURY_FLUID_ID, fluidMercury)
				.setUnlocalizedName(
						FluidInfo.BLOCK_MERCURY_FLUID_UNLOCALIZED_NAME)
				.setTextureName(
						FluidInfo.TEXTURE_LOCATION + ":"
								+ FluidInfo.MERCURY_FLUID_ICON);
		GameRegistry.registerBlock(blockMercuryLiquid,
				FluidInfo.MERCURY_FLUID_KEY);

		// mercury bucket

		bucketMercury = new MercurycraftBucket(FluidInfo.MERCURY_BUCKET_ID,
				FluidInfo.MERCURY_FLUID_ID)
				.setUnlocalizedName(FluidInfo.MERCURY_BUCKET_UNLOCALIZED_NAME)
				.setMaxStackSize(1)
				.setContainerItem(Item.bucketEmpty)
				.setTextureName(
						FluidInfo.TEXTURE_LOCATION + ":"
								+ FluidInfo.MERCURY_BUCKET_ICON);

		MinecraftForge.EVENT_BUS.register(new BucketHandler());

		// mercury spring

		if (blockMercuryLiquid != null) {
			Property mercurySpringsProp = ConfigHandler.config.get(
					Configuration.CATEGORY_GENERAL, "mercurySprings", true);
			spawnMercurySprings = mercurySpringsProp.getBoolean(true);
			BlockSpring.EnumSpring.MERCURY.canGen = spawnMercurySprings;
			BlockSpring.EnumSpring.MERCURY.liquidBlock = blockMercuryLiquid;
		}

	}

	public static void addNames() {
		LanguageRegistry.addName(bucketMercury, FluidInfo.MERCURY_BUCKET_NAME);

	}

	public static void postInit() {

		FluidContainerRegistry
				.registerFluidContainer(new FluidContainerData(FluidRegistry
						.getFluidStack(fluidMercury.getName(),
								FluidContainerRegistry.BUCKET_VOLUME),
						new ItemStack(Fluids.bucketMercury), new ItemStack(
								Item.bucketEmpty)));

	}

}