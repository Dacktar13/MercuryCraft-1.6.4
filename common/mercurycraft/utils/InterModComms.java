package mercurycraft.utils;



import java.util.logging.Level;
import java.util.logging.Logger;
import mercurycraft.world.MercuryPopulate;
import net.minecraft.world.biome.BiomeGenBase;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;

public class InterModComms {

    public static void processIMC(IMCEvent event) {
        for (IMCMessage m : event.getMessages()) {
            if ("add-facade".equals(m.key)) {
                processFacadeIMC(event, m);
            } else if (m.key.equals("mercury-lake-biome")) {
                processMercuryLakeBiomeIMC(event, m);
            } else if (m.key.equals("mercury-gen-exclude")) {
                processMercuryGenExcludeIMC(event, m);
            }
        }
    }

    public static void processFacadeIMC(IMCEvent event, IMCMessage m) {
        try {
            Splitter splitter = Splitter.on("@").trimResults();

            String[] array = Iterables.toArray(splitter.split(m.getStringValue()), String.class);
            if (array.length != 2) {
                Logger.getLogger("Mercurycraft").log(Level.INFO, String.format("Received an invalid add-facade request %s from mod %s", m.getStringValue(), m.getSender()));
            } else {
                Integer blId = Ints.tryParse(array[0]);
                Integer metaId = Ints.tryParse(array[1]);
                if (blId == null || metaId == null) {
                    Logger.getLogger("Mercurycraft").log(Level.INFO, String.format("Received an invalid add-facade request %s from mod %s", m.getStringValue(), m.getSender()));
                } else {
                   // ItemFacade.addFacade(new ItemStack(blId, 1, metaId));
                }
            }
        } catch (Exception ex) {

        }
    }

    public static void processMercuryLakeBiomeIMC(IMCEvent event, IMCMessage m) {
        try {
            String biomeID = m.getStringValue().trim();
            int id = Integer.valueOf(biomeID);
            if (id >= BiomeGenBase.biomeList.length) {
                throw new IllegalArgumentException("Biome ID must be less than " + BiomeGenBase.biomeList.length);
            }
            MercuryPopulate.INSTANCE.surfaceDepositBiomes.add(id);
        } catch (Exception ex) {
            Logger.getLogger("Mercurycraft").log(Level.WARNING, String.format("Received an invalid mercury-lake-biome request %s from mod %s", m.getStringValue(), m.getSender()));
        }
        Logger.getLogger("Mercurycraft").log(Level.INFO, String.format("Received an successfull mercury-lake-biome request %s from mod %s", m.getStringValue(), m.getSender()));
    }

    public static void processMercuryGenExcludeIMC(IMCEvent event, IMCMessage m) {
        try {
            String biomeID = m.getStringValue().trim();
            int id = Integer.valueOf(biomeID);
            if (id >= BiomeGenBase.biomeList.length) {
                throw new IllegalArgumentException("Biome ID must be less than " + BiomeGenBase.biomeList.length);
            }
            MercuryPopulate.INSTANCE.excludedBiomes.add(id);
        } catch (Exception ex) {
            Logger.getLogger("Mercurycraft").log(Level.WARNING, String.format("Received an invalid mercury-gen-exclude request %s from mod %s", m.getStringValue(), m.getSender()));
        }
        Logger.getLogger("Mercurycraft").log(Level.INFO, String.format("Received an successfull mercury-gen-exclude request %s from mod %s", m.getStringValue(), m.getSender()));
    }
}
