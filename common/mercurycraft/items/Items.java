package mercurycraft.items;

import java.nio.channels.Pipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item mercuryIngot;
	public static Item mercuryWand;
	public static Item mercuryStick;
	public static Item card;
	public static Pipe mercuryPipe;


	public static void init() {
		mercuryIngot = new MercuryIngot(ItemInfo.MERCURY_INGOT_ID);
		mercuryWand = new MercuryWand(ItemInfo.MERCURY_WAND_ID);
		mercuryStick = new MercuryStick(ItemInfo.MERCURY_STICK_ID);
		card = new ItemCard(ItemInfo.CARD_ID);
		// mercuryPipe = new MercuryPipe(ItemInfo.MERCURY_PIPE_ID);
	}

	public static void addNames() {
		LanguageRegistry.addName(mercuryWand, ItemInfo.MERCURY_WAND_NAME);
		LanguageRegistry.addName(mercuryIngot, ItemInfo.MERCURY_INGOT_NAME);
		LanguageRegistry.addName(mercuryStick, ItemInfo.MERCURY_STICK_NAME);
		// LanguageRegistry.addName(mercuryPipe, ItemInfo.MERCURY_PIPE_NAME);

		for (int i = 0; i < ItemInfo.CARD_NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(card, 1, i),
					ItemInfo.CARD_NAMES[i]);
		}

	}


}
