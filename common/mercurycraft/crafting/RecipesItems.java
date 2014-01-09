package mercurycraft.crafting;

import mercurycraft.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesItems {

	public static void registerRecipes() {

		// Mercury Stick Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(Items.mercuryStick, 4),
				new Object[] { "   ", " m ", " m ", 'm', Items.mercuryIngot });

		// Mercury Wand Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(Items.mercuryWand), new Object[] {
				"  m", " s ", "s  ", 'm', Items.mercuryIngot, 's',
				Items.mercuryStick });

		// Crafting of cards
		GameRegistry.addRecipe(new ItemStack(Items.card), new Object[] {
				" s ", "sms", " s ", 'm', Items.mercuryIngot, 's',
				Block.stone });
		
		

	}

}
