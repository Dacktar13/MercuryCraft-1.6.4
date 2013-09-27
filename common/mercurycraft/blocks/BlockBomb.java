package mercurycraft.blocks;

import java.util.Random;

import mercurycraft.CreativeTabMercuryCraft;
import mercurycraft.tileentities.TileEntityBomb;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBomb extends BlockContainer {

	public BlockBomb(int id) {
		super(id, Material.iron);	
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.BOMB_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon idleIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BOMB_TEXTURE);
		idleIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BOMB_IDLE_TEXTURE);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBomb();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : idleIcon;
	}
	
	@Override
	public int idDropped(int meta, Random random, int fortune) {
		return -1;
	}
	
}
