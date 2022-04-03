package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;

public class LavaSpongeItemTags extends ItemTagsProvider {
    public LavaSpongeItemTags(DataGenerator generator, LavaSpongeBlockTags blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, LavaSponge.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //No Item Tags Needed
    }

    @Override
    public String getName() {
        return "LavaSponge Tags";
    }
}
