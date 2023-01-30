package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeItemModels extends ItemModelProvider {


    public LavaSpongeItemModels(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(BlockRegister.HOT_LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/hot_lavasponge"));
        withExistingParent(BlockRegister.LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/lavasponge"));
    }
}
