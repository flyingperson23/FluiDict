package flyingperson.fluidict.config;

import flyingperson.fluidict.FluiDict;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiFluidictConfig extends GuiConfig {
    public GuiFluidictConfig(final GuiScreen parent) {
        super(parent, FluiDict.MODID, "FluiDict");
    }
}
