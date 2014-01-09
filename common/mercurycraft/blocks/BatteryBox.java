package mercurycraft.blocks;

import java.util.List;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BatteryBox extends Block {

	public BatteryBox(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(BlockInfo.BATTERY_BOX_UNLOCALIZED_NAME);
		setStepSound(Block.soundMetalFootstep);
		setHardness(2F);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon botIcon;
	@SideOnly(Side.CLIENT)
	private Icon[] sideIcons;	
	@SideOnly(Side.CLIENT)
	private Icon disableIcon;		
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_TOP);
		botIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_BOT);
		
		sideIcons = new Icon[BlockInfo.MACHINE_SIDES.length];
		for (int i = 0; i < sideIcons.length; i++) {
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_SIDES[i]);	
		}
				
		disableIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_DISABLED);	 
 	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (side == 0) {
			return botIcon;
		}else if(side == 1) {
			return isDisabled(meta) ? disableIcon : topIcon;
		}else{
			int type = meta / 2;
			return sideIcons[type];
		}		
	}
	
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
			spawnAnvil(world, x, y + 20, z);
		}
	}
	
    @Override
  	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
  		int meta = world.getBlockMetadata(x,y,z);
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && !isDisabled(meta)) {
			switch(meta / 2) {
				case 1:
					for (int i = 0; i < 5; i++) {
						spawnAnvil(world, x, y + 20 + i, z);
					}
					break;
				case 2:		
					for (int i = -1; i <= 1; i++) {
						spawnAnvil(world, x + i, y + 20, z - 2);
						spawnAnvil(world, x + i, y + 20, z + 2);
						spawnAnvil(world, x - 2, y + 20, z + i);
						spawnAnvil(world, x + 2, y + 20, z + i);
					}
					break;
				case 3:
					for (int i = 1; i <= 3; i++) {
						spawnAnvil(world, x + i, y + 20, z);
						spawnAnvil(world, x - i, y + 20, z);
						spawnAnvil(world, x, y + 20, z + i);
						spawnAnvil(world, x, y + 20, z - i);
					}
					break;		
			}
		}
		
	}
	
	private boolean isDisabled(int meta) {
		return meta % 2 == 1;
	}
	
	private void spawnAnvil(World world, int x, int y, int z) {
		if (world.isAirBlock(x, y, z)) {
			world.setBlock(x, y, z, Block.anvil.blockID);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float offsetX, float offsetY, float offsteZ) {
		if (!world.isRemote) {
			int meta = world.getBlockMetadata(x, y, z);
			
			int type = meta / 2;
			
			int disabled = meta % 2 == 0 ? 1 : 0;
			
			int newMeta = type * 2 + disabled;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
	
		return true;
	}
	
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < BlockInfo.MACHINE_SIDES.length; i++) {
			list.add(new ItemStack(id, 1, i * 2));
		}
	}
	
}
