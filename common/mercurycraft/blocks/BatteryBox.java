package mercurycraft.blocks;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
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
	private Icon frontIcon;

	@SideOnly(Side.CLIENT)
	private Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		frontIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.BATTERY_BOX_ICON);
		sideIcon = register.registerIcon("furnace_top");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int mete) {
		if (side == 2) {
			return frontIcon;
		} else {
			return sideIcon;
		}
	}
	
}
