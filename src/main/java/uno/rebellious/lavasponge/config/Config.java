package uno.rebellious.lavasponge.config;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class Config {

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab("lavasponge") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockRegister.LAVA_SPONGE.get());
        }
    };


}
