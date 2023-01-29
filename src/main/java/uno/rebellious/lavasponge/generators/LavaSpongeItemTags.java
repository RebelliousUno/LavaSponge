package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;

import static uno.rebellious.lavasponge.blocks.BlockRegister.ICE_ITEM_TAG;

public class LavaSpongeItemTags extends ItemTagsProvider {
    public LavaSpongeItemTags(DataGenerator generator, LavaSpongeBlockTags blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, LavaSponge.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //No Item Tags Needed
        tag(ICE_ITEM_TAG).add(Blocks.ICE.asItem()).add(Blocks.PACKED_ICE.asItem()).add(Blocks.BLUE_ICE.asItem());
    }

    @Override
    public String getName() {
        return "LavaSponge Tags";
    }
}
