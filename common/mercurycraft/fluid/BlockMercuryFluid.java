package mercurycraft.fluid;



	
import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	/**
	 *
	 * @author CovertJaguar <http://www.railcraft.info/>
	 */
	public class BlockMercuryFluid extends BlockFluidClassic {

		public BlockMercuryFluid(int id) {
			super(id, Fluids.fluidMercury, Fluids.materialFluidMercury);
			this.setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
			
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister register) {
			blockIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":"
					+ FluidInfo.MERCURY_FLUID_ICON);
		}
		
		
	}

//		protected float particleRed;
//		protected float particleGreen;
//		protected float particleBlue;
//
//		public BlockMercuryFluid(int id, Fluid fluid, Material material) {
//			super(id, fluid, material);
//		}
//		@SideOnly(Side.CLIENT)
//		protected Icon theIcon;
//		protected boolean flammable;
//		protected int flammability = 0;
//		
//
//		@Override
//		public Icon getIcon(int side, int meta) {
//			return side != 0 && side != 1 ? this.theIcon : this.theIcon;
//		}
//
//		@Override
//		@SideOnly(Side.CLIENT)
//		public void registerIcons(IconRegister register) {
//			theIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":"
//					+ fluidName + "_still");
//		}
//			
//		
//
//		public BlockMercuryFluid setFlammable(boolean flammable) {
//			this.flammable = flammable;
//			return this;
//		}
//
//		public BlockMercuryFluid setFlammability(int flammability) {
//			this.flammability = flammability;
//			return this;
//		}
//
//		@Override
//		public int getFireSpreadSpeed(World world, int x, int y, int z, int metadata, ForgeDirection face) {
//			return flammable ? 300 : 0;
//		}
//
//		@Override
//		public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
//			return flammability;
//		}
//
//		@Override
//		public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
//			return flammable;
//		}
//
//		@Override
//		public boolean isFireSource(World world, int x, int y, int z, int metadata, ForgeDirection side) {
//			return flammable && flammability == 0;
//		}
//
//		public BlockMercuryFluid setParticleColor(float particleRed, float particleGreen, float particleBlue){
//			this.particleRed = particleRed;
//			this.particleGreen = particleGreen;
//			this.particleBlue = particleBlue;
//			return this;
//		}
//		
//		@Override
//		@SideOnly(Side.CLIENT)
//		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
//			super.randomDisplayTick(world, x, y, z, rand);
//
//			if (rand.nextInt(10) == 0 && world.doesBlockHaveSolidTopSurface(x, y - 1, z) && !world.getBlockMaterial(x, y - 2, z).blocksMovement()) {
//				double px = (double) ((float) x + rand.nextFloat());
//				double py = (double) y - 1.05D;
//				double pz = (double) ((float) z + rand.nextFloat());
//				
//				EntityFX fx = new EntityDropParticleFX(world, px, py, pz, particleRed, particleGreen, particleBlue);
//				FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
//			}
//		}
//		
//		@Override
//		public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
//			if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
//			return super.canDisplace(world, x, y, z);
//		}
//		
//		@Override
//		public boolean displaceIfPossible(World world, int x, int y, int z) {
//			if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
//			return super.displaceIfPossible(world, x, y, z);
//		}
//
//	}
