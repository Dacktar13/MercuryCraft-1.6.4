package mercurycraft.items;

import java.util.List;

import mercurycraft.CreativeTabMercuryCraft;
import mercurycraft.client.sounds.Sounds;
import mercurycraft.entities.EntitySpaceship;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MercuryWand extends Item {

	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;

	public MercuryWand(int id) {
		super(id);
		setCreativeTab(CreativeTabMercuryCraft.tabMercuryCraft);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.MERCURY_WAND_UNLOCALIZED_NAME);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity target) {
		if (!target.worldObj.isRemote) {
			target.motionY = 2;
			if (isCharged(itemstack.getItemDamage())) {
				target.motionX = (target.posX - player.posX) * 2;
				target.motionZ = (target.posZ - player.posZ) * 2;
				
				itemstack.setItemDamage(0);
				Sounds.WAND_USE.play(target.posX, target.posY, target.posZ, 1, 3);
			}else{
				itemstack.setItemDamage(itemstack.getItemDamage() + 1);
				Sounds.WAND_USE.play(target.posX, target.posY, target.posZ, 1, 0);
			}
			
			
		}
	
		return false;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MERCURY_WAND_ICON);
		chargedIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MERCURY_WAND_ICON_CHARGED);
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add("This fun thing has been used " + itemstack.getItemDamage() + " times");
		
		if (isCharged(itemstack.getItemDamage())) {
			info.add("This item is charged");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		if (isCharged(dmg)) {
			return chargedIcon;
		}else{
			return itemIcon;
		}
	}
	
	private boolean isCharged(int dmg){
		return dmg >= 10;
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote && player.isSneaking()) {
			EntitySpaceship ship = new EntitySpaceship(world);
			
			ship.posX = x + 0.5;
			ship.posY = y + 1.5;
			ship.posZ = z + 0.5;
			
			if (isCharged(stack.getItemDamage())) {
				ship.setCharged();	
				
				stack.setItemDamage(0);
			}else{
				stack.setItemDamage(stack.getItemDamage() + 1);			
			}
			
			world.spawnEntityInWorld(ship);

			return true;
		}else{
			return false;
		}
		
	}

}
