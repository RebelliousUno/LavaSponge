package uno.rebellious.lavasponge.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.config.Config;

public class BlockRegister {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LavaSponge.MODID);
    public static final RegistryObject<LavaSpongeBlock> LAVA_SPONGE = BLOCKS.register("lavasponge", () -> new LavaSpongeBlock(AbstractBlock.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.METAL)));
    public static final RegistryObject<HotLavaSpongeBlock> HOT_LAVA_SPONGE = BLOCKS.register("hot_lavasponge", () -> new HotLavaSpongeBlock(AbstractBlock.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.METAL).func_235838_a_((lightValue) -> 14)));
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LavaSponge.MODID);
    public static final RegistryObject<Item> LAVA_SPONGE_ITEM = ITEMS.register("lavasponge", () -> new BlockItem(LAVA_SPONGE.get(), new Item.Properties().group(Config.ITEM_GROUP)));
    public static final RegistryObject<Item> HOT_LAVA_SPONGE_ITEM = ITEMS.register("hot_lavasponge", () -> new BlockItem(HOT_LAVA_SPONGE.get(), new Item.Properties().group(Config.ITEM_GROUP).maxStackSize(1).containerItem(LAVA_SPONGE_ITEM.get())) {
        @Override
        public int getBurnTime(ItemStack itemStack) {
            return 16000;
        }
    });


    public static void registerBlocks() {


        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


}

/*
private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));

public ExampleMod() {
    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
}
 */