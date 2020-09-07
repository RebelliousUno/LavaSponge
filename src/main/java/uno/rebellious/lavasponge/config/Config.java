package uno.rebellious.lavasponge.config;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class Config {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("lavasponge") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockRegister.LAVA_SPONGE.get());
        }
    };


}
