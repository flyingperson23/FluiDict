package flyingperson.fluidict;

import flyingperson.fluidict.config.ConfigHolder;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import net.minecraftforge.fluids.FluidStack;

public class FluidEntry {

    private final Fluid theFluid;
    private final boolean placeable;
    private final int color;
    private final int density;
    private final String name;
    private final int luminosity;
    private final int temperature;
    private final int viscosity;
    private final boolean isGas;
    private final String unlocalizedName;
    
    public FluidEntry(final Fluid theFluid, final boolean placeable, final int color, final int density, final String name, final int luminosity, final int temperature, final int viscosity, final boolean isGas, String unlocalizedName) {
        this.theFluid = theFluid;
        this.placeable = placeable;
        this.color = color;
        this.density = density;
        this.name = name;
        this.luminosity = luminosity;
        this.temperature = temperature;
        this.viscosity = viscosity;
        this.isGas = isGas;
        this.unlocalizedName = unlocalizedName;
    }
    
    public FluidEntry(final FluidStack stack) {
        this(stack.getFluid());
    }
    
    public FluidEntry(final Fluid fluid) {
        this(fluid, fluid.canBePlacedInWorld(), fluid.getColor(), fluid.getDensity(), fluid.getName(), fluid.getLuminosity(), fluid.getTemperature(), fluid.getViscosity(), fluid.isGaseous(), fluid.getUnlocalizedName());
    }

    public Fluid getFluid() {
        return theFluid;
    }
    
    public static ArrayList<FluidEntry> getAllFluids() {
        return FluidRegistry.getRegisteredFluids().values().stream().filter(fluid -> Arrays.stream(ConfigHolder.fluidsToHide).noneMatch(e -> fluid.getName().equals(e))).map(FluidEntry::new).collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<String> getTooltip() {
        final ArrayList<String> tooltip = new ArrayList<>();
        if (ConfigHolder.hoverText.showPlaceable) tooltip.add(I18n.format("fluidict.hover.placeable", placeable));
        if (ConfigHolder.hoverText.showColor) tooltip.add(I18n.format("fluidict.hover.color", color));
        if (ConfigHolder.hoverText.showDensity) tooltip.add(I18n.format("fluidict.hover.density", density));
        if (ConfigHolder.hoverText.showName) tooltip.add(I18n.format("fluidict.hover.name", name));
        if (ConfigHolder.hoverText.showLuminosity) tooltip.add(I18n.format("fluidict.hover.luminosity", luminosity));
        if (ConfigHolder.hoverText.showTemperature) tooltip.add(I18n.format("fluidict.hover.temperature", temperature));
        if (ConfigHolder.hoverText.showViscosity) tooltip.add(I18n.format("fluidict.hover.viscosity", viscosity));
        if (ConfigHolder.hoverText.showGaseous) tooltip.add(I18n.format("fluidict.hover.gaseous", isGas));
        if (ConfigHolder.hoverText.showUnlocalizedName) tooltip.add(I18n.format("fluidict.hover.unlocalizedName", unlocalizedName));
        return tooltip;
    }
}
