package flyingperson.fluidict;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = FluiDict.MODID, name = FluiDict.NAME, version = FluiDict.VERSION, dependencies = "required:jei", guiFactory = "flyingperson.fluidict.config.ConfigGuiFactory")
public class FluiDict {
    public static final String MODID = "fluidict";
    public static final String NAME = "Fluid Dictionary";
    public static final String VERSION = "1.2";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MODID)) {
            ConfigManager.sync(MODID, Config.Type.INSTANCE);
        }
    }
}
