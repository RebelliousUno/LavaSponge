package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeItemModels extends ItemModelProvider {
    public LavaSpongeItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LavaSponge.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        withExistingParent(BlockRegister.HOT_LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/hot_lavasponge"));
        withExistingParent(BlockRegister.LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/lavasponge"));
    }
}
