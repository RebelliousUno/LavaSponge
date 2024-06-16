package uno.rebellious.lavasponge.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static uno.rebellious.lavasponge.LavaSponge.MODID;

public class BlockRegister {
    public static final TagKey<Item> ICE_ITEM_TAG = ItemTags.create(ResourceLocation.bySeparator(MODID + ":lavaspongecooler", ':'));
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredBlock<Block> LAVA_SPONGE = BLOCKS.register("lavasponge", () -> new LavaSpongeBlock(BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> HOT_LAVA_SPONGE = BLOCKS.register("hot_lavasponge", () -> new HotLavaSpongeBlock(BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.METAL).lightLevel((lightValue) -> 14)));
    public static final DeferredItem<BlockItem> LAVA_SPONGE_ITEM = ITEMS.registerSimpleBlockItem("lavasponge", LAVA_SPONGE);
    public static final DeferredItem<BlockItem> HOT_LAVA_SPONGE_ITEM = ITEMS.register("hot_lavasponge",() -> new BlockItem(HOT_LAVA_SPONGE.get(), new Item.Properties().fireResistant().stacksTo(1).craftRemainder(LAVA_SPONGE_ITEM.get())) {
        @Override
        public int getBurnTime(ItemStack stack, RecipeType recipeType) {
            return 16000;
        }
    });

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LAVASPONGE_TAB = CREATIVE_MODE_TABS.register("lavasponge", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.FUNCTIONAL_BLOCKS)
            .icon(() -> HOT_LAVA_SPONGE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(HOT_LAVA_SPONGE_ITEM.get());
                output.accept(LAVA_SPONGE_ITEM.get());
            })
            .title(Component.translatable("item_group.lavasponge.item_group"))
            .build());

    /**
     *  // Creates a creative tab with the id "lavasponge:example_tab" for the example item, that is placed after the combat tab
     *     public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
     *             .title(Component.translatable("itemGroup.lavasponge"))
     *             .withTabsBefore(CreativeModeTabs.COMBAT)
     *             .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
     *             .displayItems((parameters, output) -> {
     *                 output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
     *             }).build());
     */

}