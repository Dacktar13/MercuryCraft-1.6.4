package mercurycraft.world;

import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.BiomeDictionary;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BiomeGenMercuryOcean extends BiomeGenOcean {

	public static BiomeGenMercuryOcean makeBiome(int id) {
		BiomeGenMercuryOcean biome = new BiomeGenMercuryOcean(id);
		BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.WATER);
		MercuryPopulate.INSTANCE.excessiveBiomes.add(biome.biomeID);
		MercuryPopulate.INSTANCE.surfaceDepositBiomes.add(biome.biomeID);
		return biome;
	}

	private BiomeGenMercuryOcean(int id) {
		super(id);
		setBiomeName("Ocean Mercury Field");
		setColor(112);
		setMinMaxHeight(-1.0F, 0.4F);
	}
}