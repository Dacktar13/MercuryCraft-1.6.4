package mercurycraft.blocks;


import mercurycraft.utils.StringUtils;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

	public class ItemBlockMercuryCraft extends ItemBlock {

		public ItemBlockMercuryCraft(int id) {
			super(id);
		}

		@Override
		public int getMetadata(int i) {
			return i;
		}

		@Override
		public String getItemDisplayName(ItemStack itemstack) {
			return StringUtils.localize(getUnlocalizedName(itemstack));
		}
	}
