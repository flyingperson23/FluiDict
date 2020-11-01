package flyingperson.fluidict;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fluids.FluidStack;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeWrapper implements IRecipeWrapper {
    public static final IRecipeWrapperFactory<FluidEntry> FACTORY;
    public final FluidEntry theRecipe;
    
    public RecipeWrapper(final FluidEntry recipe) {
        this.theRecipe = recipe;
    }
    
    public void getIngredients(final IIngredients ingredients) {
        ingredients.setOutput(VanillaTypes.FLUID, new FluidStack(this.theRecipe.getFluid(), 1000));
        ingredients.setOutput(VanillaTypes.ITEM, UniversalBucket.getFilledBucket(new UniversalBucket(), this.theRecipe.getFluid()));
        ingredients.setInput(VanillaTypes.ITEM, new ItemStack(Items.BUCKET));
    }
    
    static {
        FACTORY = RecipeWrapper::new;
    }
}
