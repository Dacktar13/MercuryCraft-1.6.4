package mercurycraft.network;

import mercurycraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {

	@ForgeSubscribe
	public void fillBucket(FillBucketEvent e) {
		if (e.current.itemID != Item.bucketEmpty.itemID)
			return;

		ItemStack fullBucket = getLiquid(e.world, e.target);

		if (fullBucket == null)
			return;

		e.world.setBlockToAir(e.target.blockX, e.target.blockY, e.target.blockZ);
		e.result = fullBucket;
		e.setResult(Result.ALLOW);
	}

	private ItemStack getLiquid(World world, MovingObjectPosition pos) {
		int blockId = world.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
		if (blockId == Fluids.blockMercuryLiquid.blockID)
			return new ItemStack(Fluids.bucketMercury); // copy this line to add
														// other liquids to
														// bucket handler
		

		return null;
	}

}
