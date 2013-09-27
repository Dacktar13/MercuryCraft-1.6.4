package mercurycraft.world;

import mercurycraft.fluid.Fluids;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;


/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class GenLayerAddMercuryOcean extends GenLayerBiomeReplacer {

	public static final double NOISE_FIELD_SCALE = 0.0005;
	public static final double NOISE_FIELD_THRESHOLD = 0.9;

	public GenLayerAddMercuryOcean(final long worldSeed, final long seed, final GenLayer parent) {
		super(worldSeed, seed, parent, NOISE_FIELD_SCALE, NOISE_FIELD_THRESHOLD, Fluids.biomeMercuryOcean.biomeID);
	}

	@Override
	protected boolean canReplaceBiome(int biomeId) {
		return biomeId == BiomeGenBase.ocean.biomeID;
	}
}
