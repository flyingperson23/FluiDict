package flyingperson.fluidict;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.IModPlugin;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
    public void registerCategories(final IRecipeCategoryRegistration registry) {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        registry.addRecipeCategories(new RecipeCategory(helpers.getGuiHelper()));
    }
    
    public void register(final IModRegistry registry) {
        registry.handleRecipes(FluidEntry.class, RecipeWrapper::new, RecipeCategory.NAME);
        registry.addRecipes(FluidEntry.getAllFluids(), RecipeCategory.NAME);
    }
}
