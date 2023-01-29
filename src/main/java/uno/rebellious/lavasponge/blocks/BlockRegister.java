package uno.rebellious.lavasponge.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.config.Config;


public class BlockRegister {

//    private static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS,LavaSponge.MODID);

    public static final TagKey<Item> ICE_ITEM_TAG = ItemTags.create(new ResourceLocation(LavaSponge.MODID, "lavaspongecooler"));
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LavaSponge.MODID);
    public static final RegistryObject<LavaSpongeBlock> LAVA_SPONGE = BLOCKS.register("lavasponge", () -> new LavaSpongeBlock(BlockBehaviour.Properties.of(Material.SPONGE).strength(0.6F).sound(SoundType.METAL)));
    public static final RegistryObject<HotLavaSpongeBlock> HOT_LAVA_SPONGE = BLOCKS.register("hot_lavasponge", () -> new HotLavaSpongeBlock(BlockBehaviour.Properties.of(Material.SPONGE).strength(0.6F).sound(SoundType.METAL).lightLevel((lightValue) -> 14)));
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LavaSponge.MODID);
    public static final RegistryObject<Item> LAVA_SPONGE_ITEM = ITEMS.register("lavasponge", () -> new BlockItem(LAVA_SPONGE.get(), new Item.Properties().tab(Config.ITEM_GROUP)));
    public static final RegistryObject<Item> HOT_LAVA_SPONGE_ITEM = ITEMS.register("hot_lavasponge", () -> new BlockItem(HOT_LAVA_SPONGE.get(), new Item.Properties().tab(Config.ITEM_GROUP).fireResistant().stacksTo(1).craftRemainder(LAVA_SPONGE_ITEM.get())) {
        @Override
        public int getBurnTime(ItemStack stack, RecipeType recipeType) {
            return 16000;
        }
    });

    public static void registerBlocks() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }


}