package mercurycraft.proxies;

import net.minecraft.client.Minecraft;
import mercurycraft.client.RenderSpaceship;
import mercurycraft.client.sounds.SoundHandler;
import mercurycraft.entities.EntitySpaceship;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initSounds() {
		new SoundHandler();
	}

	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
	}
	
	/* LOCALIZATION */
	@Override
	public String getCurrentLanguage() {
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}

	@Override
	public void addName(Object obj, String s) {
		LanguageRegistry.addName(obj, s);
	}

	@Override
	public void addLocalization(String s1, String string) {
		LanguageRegistry.instance().addStringLocalization(s1, string);
	}
}
