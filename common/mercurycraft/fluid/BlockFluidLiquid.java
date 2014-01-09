package mercurycraft.fluid;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class BlockFluidLiquid extends BlockFluidClassic {

	public BlockFluidLiquid(int id, Fluid fluid) {
		super(id, fluid, Material.water);
		this.setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		
	}

	
	
	@SideOnly(Side.CLIENT)
	protected boolean flammable;
	protected int flammability = 0;

	public BlockFluidLiquid setFlammable(boolean flammable) {
		this.flammable = flammable;
		return this;
	}

	public BlockFluidLiquid setFlammability(int flammability) {
		this.flammability = flammability;
		return this;
	}

	@Override
	public int getFireSpreadSpeed(World world, int x, int y, int z,
			int metadata, ForgeDirection face) {
		return flammable ? 300 : 0;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z,
			int metadata, ForgeDirection face) {
		return flammability;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z,
			int metadata, ForgeDirection face) {
		return flammable;
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, int metadata,
			ForgeDirection side) {
		return flammable && flammability == 0;
	}

}
