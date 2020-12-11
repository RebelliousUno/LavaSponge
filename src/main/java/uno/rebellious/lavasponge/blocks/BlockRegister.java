package uno.rebellious.lavasponge.blocks;

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

    private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LavaSponge.MODID);
    public static final RegistryObject<LavaSpongeBlock> LAVA_SPONGE = BLOCKS.register("lavasponge", () -> new LavaSpongeBlock(Block.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.METAL)));
    public static final RegistryObject<HotLavaSpongeBlock> HOT_LAVA_SPONGE = BLOCKS.register("hot_lavasponge", () -> new HotLavaSpongeBlock(Block.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.METAL).lightValue(14)));
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LavaSponge.MODID);
    public static final RegistryObject<Item> LAVA_SPONGE_ITEM = ITEMS.register("lavasponge", () -> new BlockItem(LAVA_SPONGE.get(), new Item.Properties().group(Config.ITEM_GROUP)));
    public static final RegistryObject<Item> HOT_LAVA_SPONGE_ITEM = ITEMS.register("hot_lavasponge", () -> new BlockItem(HOT_LAVA_SPONGE.get(), new Item.Properties().group(Config.ITEM_GROUP).isImmuneToFire().maxStackSize(1).containerItem(LAVA_SPONGE_ITEM.get())) {
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