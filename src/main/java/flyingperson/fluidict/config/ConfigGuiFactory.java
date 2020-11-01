package flyingperson.fluidict.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class ConfigGuiFactory implements IModGuiFactory {
    public void initialize(final Minecraft minecraftInstance) {
    }

    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    public GuiScreen createConfigGui(final GuiScreen arg0) {
        return new GuiFluidictConfig(arg0);
    }

    public boolean hasConfigGui() {
        return true;
    }
}

