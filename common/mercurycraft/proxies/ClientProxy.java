package mercurycraft.proxies;

import mercurycraft.client.RenderSpaceship;
import mercurycraft.client.sounds.SoundHandler;
import mercurycraft.entities.EntitySpaceship;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initSounds() {
		new SoundHandler();
	}

	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
	}
}