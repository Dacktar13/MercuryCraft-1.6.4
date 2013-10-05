package mercurycraft.proxies;

import mercurycraft.blocks.ItemBlockMercuryCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	@SidedProxy(clientSide = "mercurycraft.proxies.ClientProxy", serverSide = "mercurycraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	public void initSounds() {
		
	}

	public void initRenderers() {
		
	}
	
	public String getCurrentLanguage() {
		return null;
	}
	
	/* LOCALIZATION */
	public void addName(Object obj, String s) {
	}

	public void addLocalization(String s1, String string) {
	}

	
	/* REGISTRATION */
	public void registerBlock(Block block) {
		registerBlock(block, ItemBlockMercuryCraft.class);
	}

	
	public void registerBlock(Block block, Class<? extends ItemBlock> item) {
		GameRegistry.registerBlock(block, item, block.getUnlocalizedName().replace("tile.", ""));
	}

	public void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

}
