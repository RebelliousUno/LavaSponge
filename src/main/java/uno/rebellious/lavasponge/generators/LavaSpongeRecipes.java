package uno.rebellious.lavasponge.generators;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.function.Consumer;

public class LavaSpongeRecipes extends RecipeProvider {
    public LavaSpongeRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BlockRegister.LAVA_SPONGE.get())
                .pattern(" X ")
                .pattern("XSX")
                .pattern(" X ")
                .define('X', Items.LAVA_BUCKET)
                .define('S', Items.SPONGE)
                .group("lavasponge")
                .unlockedBy("lavasponge", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAVA_BUCKET, Items.SPONGE))
                .save(consumer);
    }
}
