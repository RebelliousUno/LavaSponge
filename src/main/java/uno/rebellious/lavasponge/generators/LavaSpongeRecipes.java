package uno.rebellious.lavasponge.generators;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.function.Consumer;

import static uno.rebellious.lavasponge.blocks.BlockRegister.ICE_ITEM_TAG;

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
        ShapedRecipeBuilder.shaped(BlockRegister.LAVA_SPONGE.get())
                .pattern("XXX")
                .pattern("XSX")
                .pattern("XXX")
                .define('X', ICE_ITEM_TAG)
                .define('S', BlockRegister.HOT_LAVA_SPONGE.get())
                .group("lavasponge")
                .unlockedBy("lavasponge", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.HOT_LAVA_SPONGE_ITEM.get()))
                .save(consumer, new ResourceLocation("lavasponge","lavasponge_ice"));

    }
}
