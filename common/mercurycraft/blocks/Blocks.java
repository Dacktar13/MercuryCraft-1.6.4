package mercurycraft.blocks;

import mercurycraft.items.ItemMachine;
import mercurycraft.tileentities.TileEntityBomb;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {

	public static MercuryOre mercuryOre;
	public static Block batteryBox;
	public static Block mercuryEngine;
	//public static Block machine;
	public static Block bomb;
	//public static Block blockMercury;
	//public static Block springBlock;

	public static void init() {
		mercuryOre = new MercuryOre(BlockInfo.MERCURY_ORE_ID);
		GameRegistry.registerBlock(mercuryOre, BlockInfo.MERCURY_ORE_KEY);
		batteryBox = new BatteryBox(BlockInfo.BATTERY_BOX_ID);
		GameRegistry.registerBlock(batteryBox, ItemMachine.class, BlockInfo.BATTERY_BOX_KEY);
		mercuryEngine = new MercuryEngine(BlockInfo.MERCURY_ENGINE_ID);
		GameRegistry.registerBlock(mercuryEngine, BlockInfo.MERCURY_ENGINE_KEY);
		//machine = new BlockMachine(BlockInfo.MACHINE_ID);
		//GameRegistry.registerBlock(machine, ItemMachine.class,
		//		BlockInfo.MACHINE_KEY);
		bomb = new BlockBomb(BlockInfo.BOMB_ID);
		GameRegistry.registerBlock(bomb, BlockInfo.BOMB_KEY);

	}

	public static void addNames() {
		LanguageRegistry.addName(mercuryOre, BlockInfo.MERCURY_ORE_NAME);
		LanguageRegistry.addName(batteryBox, BlockInfo.BATTERY_BOX_NAME);
		LanguageRegistry.addName(mercuryEngine, BlockInfo.MERCURY_ENGINE_NAME);
		//LanguageRegistry.addName(machine, BlockInfo.MACHINE_NAME);
		LanguageRegistry.addName(bomb, BlockInfo.BOMB_NAME);
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBomb.class,
				BlockInfo.BOMB_TE_KEY);
	}

	
}
