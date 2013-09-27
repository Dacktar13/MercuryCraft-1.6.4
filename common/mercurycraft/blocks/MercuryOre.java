package mercurycraft.blocks;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MercuryOre extends Block {

	public MercuryOre(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(BlockInfo.MERCURY_ORE_UNLOCALIZED_NAME);
		setStepSound(Block.soundMetalFootstep);
		setLightValue(0.6F);
		setHardness(2F);
		
		

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.MERCURY_ORE_ICON);
	}

}
