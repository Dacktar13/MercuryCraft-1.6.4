package mercurycraft.crafting;

import mercurycraft.blocks.Blocks;
import mercurycraft.items.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingRecipes {

	public static void registerRecipes() {

		GameRegistry.addSmelting(Blocks.mercuryOre.blockID, new ItemStack(
				Items.mercuryIngot), 5);
	}

}
