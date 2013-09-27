package mercurycraft.client.particles;

import mercurycraft.blocks.Blocks;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityPoisonFX extends EntityFX {

	public EntityPoisonFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);	
		
		func_110125_a(Blocks.poison.particleIcon);
		
		particleScale = 3;
		particleAlpha = rand.nextFloat();
		particleRed = rand.nextFloat() * 0.5F;
		particleGreen = rand.nextFloat() * 0.5F + 0.5F;
		particleBlue = rand.nextFloat() * 0.5F;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		particleScale = (1 - (float)particleAge / particleMaxAge) * 3;
	}
	
	@Override
	public int getFXLayer() {
		return 1;
	}
	
}
