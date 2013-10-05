package mercurycraft.items;

import mercurycraft.CreativeTabMercuryCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MercuryStick extends Item{

	public MercuryStick(int id) {
		super(id);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(ItemInfo.MERCURY_STICK_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MERCURY_STICK_ICON);
	}
	
}