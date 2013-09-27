package mercurycraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEngine extends TileEntity implements IInventory{


boolean isActive = false; // Used for SMP synch

boolean lastPower = false;

public int orientation;

public boolean isRedstonePowered = false;

public TileEngine() {

}


private void setActive(boolean isActive) {
if (this.isActive == isActive)
	return;

this.isActive = isActive;

}


@Override
public void readFromNBT(NBTTagCompound nbttagcompound) {
super.readFromNBT(nbttagcompound);

int kind = nbttagcompound.getInteger("kind");



orientation = nbttagcompound.getInteger("orientation");
}


@Override
public String getInvName() {
return "Engine";
}

@Override
public int getInventoryStackLimit() {
return 64;
}

@Override
public boolean isUseableByPlayer(EntityPlayer entityplayer) {
return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this;
}

/* STATE INFORMATION */
public boolean isBurning() {
return false;
}


@Override
public int getSizeInventory() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public ItemStack getStackInSlot(int i) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public ItemStack decrStackSize(int i, int j) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public ItemStack getStackInSlotOnClosing(int i) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setInventorySlotContents(int i, ItemStack itemstack) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean isInvNameLocalized() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void openChest() {
	// TODO Auto-generated method stub
	
}


@Override
public void closeChest() {
	// TODO Auto-generated method stub
	
}


@Override
public boolean isItemValidForSlot(int i, ItemStack itemstack) {
	// TODO Auto-generated method stub
	return false;
}

}