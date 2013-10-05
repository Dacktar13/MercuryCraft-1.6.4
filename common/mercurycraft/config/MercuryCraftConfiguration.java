package mercurycraft.config;

import java.io.File;

import mercurycraft.ModInformation;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class MercuryCraftConfiguration extends Configuration {

		public MercuryCraftConfiguration(File file) {
			super(file);
		}

		@Override
		public void save() {
			Property versionProp = get(CATEGORY_GENERAL, "version", ModInformation.VERSION);
			versionProp.set(ModInformation.VERSION);
			super.save();
		}

	}