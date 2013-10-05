package mercurycraft.items;

import mercurycraft.CreativeTabMercuryCraft;
import mercurycraft.utils.StringUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketMercurycraft extends ItemBucket {

	private String iconName;

	public ItemBucketMercurycraft(int i, int blockId) {
		super(i, blockId);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setContainerItem(Item.bucketEmpty);
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("mercurycraft:" + iconName);
	}
}
