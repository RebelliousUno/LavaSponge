package uno.rebellious.lavasponge.generators;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;

public class LavaspongeRecipes extends RecipeProvider {

    public LavaspongeRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LAVA_SPONGE.get())
                .pattern(" X ")
                .pattern("XSX")
                .pattern(" X ")
                .define('X', Items.LAVA_BUCKET)
                .define('S', Items.SPONGE)
                .group("lavasponge")
                .unlockedBy("lavasponge", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAVA_BUCKET, Items.SPONGE))
                .save(output);
    }
}
