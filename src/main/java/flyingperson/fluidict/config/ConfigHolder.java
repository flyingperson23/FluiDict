package flyingperson.fluidict.config;

import flyingperson.fluidict.FluiDict;
import net.minecraftforge.common.config.Config;

@Config(modid = FluiDict.MODID, name = FluiDict.MODID, category = FluiDict.MODID)
public class ConfigHolder {

    @Config.Comment("Items to show when fluid is hovered over")
    public static HoverText hoverText = new HoverText();

    @Config.Comment("Should the fluid list below act as a whitelist? true for whitelist, false for blacklist")
    public static boolean isWhitelist = false;

    @Config.Comment("Fluids to hide/show\nPut in the registry name of the fluid you want to hide/show\ni.e. 'water' or 'lava' (without the quotes)")
    @Config.RequiresMcRestart
    public static String[] fluidList = new String[0];

    public static class HoverText {
        @Config.Comment("Should placeability be shown?")
        public boolean showPlaceable = false;

        @Config.Comment("Should color be shown?")
        public boolean showColor = false;

        @Config.Comment("Should density be shown?")
        public boolean showDensity = true;

        @Config.Comment("Should name be shown?")
        public boolean showName = true;

        @Config.Comment("Should luminosity be shown?")
        public boolean showLuminosity = true;

        @Config.Comment("Should temperature be shown?")
        public boolean showTemperature = false;

        @Config.Comment("Should viscosity be shown?")
        public boolean showViscosity = true;

        @Config.Comment("Should gaseousness be shown?")
        public boolean showGaseous = false;

        @Config.Comment("Should unlocalized name be shown?")
        public boolean showUnlocalizedName = false;
    }
}
