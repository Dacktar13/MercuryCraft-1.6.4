package mercurycraft.world;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraftforge.common.BiomeDictionary;

/**
 * 
 * @author CovertJaguar <http://www.railcraft.info/>
 */

public class BiomeGenMercuryDesert extends BiomeGenDesert {
	public static BiomeGenMercuryDesert makeBiome(int id) {
		BiomeGenMercuryDesert biome = new BiomeGenMercuryDesert(id);
		BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.DESERT);
		MercuryPopulate.INSTANCE.excessiveBiomes.add(biome.biomeID);
		MercuryPopulate.INSTANCE.surfaceDepositBiomes.add(biome.biomeID);
		return biome;
	}

	private BiomeGenMercuryDesert(int id) {
		super(id);
		setColor(16421912);
		setBiomeName("Desert Mercury Field");
		setDisableRain();
		setTemperatureRainfall(2.0F, 0.0F);
		setMinMaxHeight(0.1F, 0.2F);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
	}
}
