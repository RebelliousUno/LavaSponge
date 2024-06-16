
package uno.rebellious.lavasponge.generators;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static uno.rebellious.lavasponge.blocks.BlockRegister.HOT_LAVA_SPONGE_ITEM;
import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE_ITEM;

public class LavaSpongeItemModels extends ItemModelProvider {


    public LavaSpongeItemModels(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(HOT_LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/hot_lavasponge"));
        withExistingParent(LAVA_SPONGE_ITEM.getId().getPath(), modLoc("block/lavasponge"));
    }
}
