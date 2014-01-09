package mercurycraft.fluid;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;

public class MercurycraftBucket extends ItemBucket {

	private int liquidId;

	public MercurycraftBucket(int itemId, int liquidId) {
		super(itemId, liquidId);

		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		this.liquidId = liquidId;

	}

	public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
		if (liquidId <= 0) {
			return false;
		} else if (!world.isAirBlock(x, y, z)
				&& world.getBlockMaterial(x, y, z).isSolid()) {
			return false;
		} else {
			world.setBlock(x, y, z, liquidId, 0, 3);
			return true;
		}
	}

}
