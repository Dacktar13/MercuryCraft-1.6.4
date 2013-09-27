package mercurycraft;

import mercurycraft.blocks.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * MercuryCraft
 * 
 * CreativeTabMercuryCraft
 * 
 * @author Dacktar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CreativeTabMercuryCraft extends CreativeTabs {

	public static final CreativeTabs tabMercuryCraft = new CreativeTabMercuryCraft("mercurycraft");
	
	public CreativeTabMercuryCraft(String label) {
		super(label);
	}

	@Override
    public ItemStack getIconItemStack() {
		return new ItemStack(Blocks.mercuryOre);
	}
	
	@Override
    public String getTranslatedTabLabel() {
		return "MercuryCraft";
	}
}