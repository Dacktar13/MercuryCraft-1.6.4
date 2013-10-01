package mercurycraft.blocks;

import java.util.Random;

import mercurycraft.CreativeTabMercuryCraft;
import mercurycraft.tileentities.TileEngine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MercuryEngine extends BlockContainer {

	public MercuryEngine(int i) {
		super(i, Material.iron);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(BlockInfo.MERCURY_ENGINE_UNLOCALIZED_NAME);
		setStepSound(Block.soundMetalFootstep);
		setHardness(0.5F);
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;

	@SideOnly(Side.CLIENT)
	private Icon botIcon;

	@SideOnly(Side.CLIENT)
	private Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.MERCURY_ENGINE_TOP_ICON);
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.MERCURY_ENGINE_SIDE_ICON);
		botIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.MERCURY_ENGINE_BOT_ICON);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int mete) {
		if (side == 0) {
			return botIcon;
		} else {
			if (side == 1) {
				return topIcon;
			} else {
				return sideIcon;
			}
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEngine();
	}

	@Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile instanceof TileEngine) {
			return ForgeDirection.getOrientation(
					((TileEngine) tile).orientation).getOpposite() == side;
		}
		return false;
	}

	
	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int par6, float par7, float par8,
			float par9) {

		TileEngine tile = (TileEngine) world.getBlockTileEntity(i, j, k);

		// Drop through if the player is sneaking
		if (entityplayer.isSneaking()) {
			return false;
		}

		return false;
	}

	@Override
	public void onPostBlockPlaced(World world, int x, int y, int z, int par5) {
		TileEngine tile = (TileEngine) world.getBlockTileEntity(x, y, z);
		tile.orientation = ForgeDirection.UP.ordinal();
		
	}

	@Override
	public int damageDropped(int i) {
		return i;
	}

	@SuppressWarnings({ "all" })
	@Override
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		TileEngine tile = (TileEngine) world.getBlockTileEntity(i, j, k);

		if (!tile.isBurning())
			return;

		float f = (float) i + 0.5F;
		float f1 = (float) j + 0.0F + (random.nextFloat() * 6F) / 16F;
		float f2 = (float) k + 0.5F;
		float f3 = 0.52F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;

		world.spawnParticle("reddust", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("reddust", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
	}

		
	
}
