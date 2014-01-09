package mercurycraft.items;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MercuryIngot extends Item{

	public MercuryIngot(int id) {
		super(id);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(ItemInfo.MERCURY_INGOT_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MERCURY_INGOT_ICON);
	}
	
}
