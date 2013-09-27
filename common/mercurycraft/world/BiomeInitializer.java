package mercurycraft.world;

import mercurycraft.fluid.Fluids;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BiomeInitializer {

	public BiomeInitializer() {
	}

	@ForgeSubscribe
	public void initBiomes(WorldTypeEvent.InitBiomeGens event) {
		if (Fluids.biomeMercuryDesert != null) {
			event.newBiomeGens[0] = new GenLayerAddMercuryDesert(event.seed, 1500L, event.newBiomeGens[0]);
			event.newBiomeGens[1] = new GenLayerAddMercuryDesert(event.seed, 1500L, event.newBiomeGens[1]);
			event.newBiomeGens[2] = new GenLayerAddMercuryDesert(event.seed, 1500L, event.newBiomeGens[2]);
		}
		if (Fluids.biomeMercuryOcean != null) {
			event.newBiomeGens[0] = new GenLayerAddMercuryOcean(event.seed, 1500L, event.newBiomeGens[0]);
			event.newBiomeGens[1] = new GenLayerAddMercuryOcean(event.seed, 1500L, event.newBiomeGens[1]);
			event.newBiomeGens[2] = new GenLayerAddMercuryOcean(event.seed, 1500L, event.newBiomeGens[2]);
		}


	}
}
