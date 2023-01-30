package uno.rebellious.lavasponge.generators;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.function.Consumer;

import static uno.rebellious.lavasponge.blocks.BlockRegister.ICE_ITEM_TAG;

public class LavaSpongeRecipes extends RecipeProvider {

    public LavaSpongeRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegister.LAVA_SPONGE.get())
                .pattern(" X ")
                .pattern("XSX")
                .pattern(" X ")
                .define('X', Items.LAVA_BUCKET)
                .define('S', Items.SPONGE)
                .group("lavasponge")
                .unlockedBy("lavasponge", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAVA_BUCKET, Items.SPONGE))
                .save(consumer);

        //TODO: Fix Dupe Bug with
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegister.LAVA_SPONGE.get())
//                .pattern("XXX")
//                .pattern("XSX")
//                .pattern("XXX")
//                .define('X', ICE_ITEM_TAG)
//                .define('S', BlockRegister.HOT_LAVA_SPONGE.get())
//                .group("lavasponge")
//                .unlockedBy("lavasponge", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.HOT_LAVA_SPONGE_ITEM.get()))
//                .save(consumer, new ResourceLocation("lavasponge", "lavasponge_ice"));

    }
}
