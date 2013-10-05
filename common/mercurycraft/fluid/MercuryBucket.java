package mercurycraft.fluid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mercurycraft.CreativeTabMercuryCraft;
import mercurycraft.items.ItemInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.ItemFluidContainer;

public class MercuryBucket extends ItemFluidContainer{

	public MercuryBucket(int id, int flu_id) {
		super(id, flu_id);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setUnlocalizedName(ItemInfo.MERCURY_BUCKET_UNLOCALIZED_NAME);
		setContainerItem(Item.bucketEmpty);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MERCURY_BUCKET_ICON);
	}
	
}
