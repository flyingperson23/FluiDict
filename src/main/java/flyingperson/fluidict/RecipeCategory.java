package flyingperson.fluidict;

import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import net.minecraft.item.ItemStack;
import java.util.List;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.IGuiHelper;
import net.minecraft.util.ResourceLocation;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.recipe.IRecipeCategory;

public class RecipeCategory implements IRecipeCategory<RecipeWrapper> {
    public static final String NAME = "fluidict.category";
    private final IDrawable background;
    private final IDrawable overlay;
    private final IDrawable icon;
    public static final ResourceLocation ICON;
    
    public RecipeCategory(final IGuiHelper helper) {
        this.background = helper.createDrawable(new ResourceLocation(FluiDict.MODID, "textures/gui/background.png"), 0, 0, 128, 80);
        this.overlay = helper.createDrawable(new ResourceLocation(FluiDict.MODID, "textures/gui/overlay.png"), 0, 0, 81, 53);
        this.icon = helper.drawableBuilder(RecipeCategory.ICON, 0, 0, 16, 16).setTextureSize(16, 16).build();
    }
    
    public String getUid() {
        return NAME;
    }
    
    public String getTitle() {
        return "Fluid Dictionary";
    }
    
    public String getModName() {
        return "Fluid Dictionary";
    }
    
    public IDrawable getBackground() {
        return this.background;
    }
    
    public IDrawable getIcon() {
        return this.icon;
    }
    
    public void setRecipe(final IRecipeLayout recipeLayout, final RecipeWrapper recipeWrapper, final IIngredients ingredients) {
        final List<List<ItemStack>> outputItem = ingredients.getOutputs(VanillaTypes.ITEM);
        final List<List<ItemStack>> inputItem = ingredients.getInputs(VanillaTypes.ITEM);
        final IGuiFluidStackGroup guiFluidStacks = recipeLayout.getFluidStacks();
        final IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiFluidStacks.init(0, false, 16, 16, 81, 49, 1000, false, this.overlay);
        if (outputItem.size() > 0) {
            guiItemStacks.init(1, false, 102, 47);
        }
        if (inputItem.size() > 0) {
            guiItemStacks.init(2, true, 102, 15);
        }
        guiFluidStacks.set(ingredients);
        guiItemStacks.set(ingredients);
        guiFluidStacks.addTooltipCallback(new FluidTooltipCallback());
    }
    
    static {
        ICON = new ResourceLocation(FluiDict.MODID, "textures/gui/icon.png");
    }
}
