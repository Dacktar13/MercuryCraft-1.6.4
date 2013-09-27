package mercurycraft.items;

import net.minecraft.item.ItemBlock;

public class ItemMachine extends ItemBlock {
	
	public ItemMachine(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg) {
		return dmg;
	}

}
