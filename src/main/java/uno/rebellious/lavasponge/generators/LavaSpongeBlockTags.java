package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeBlockTags extends BlockTagsProvider {
    public LavaSpongeBlockTags(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, LavaSponge.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegister.HOT_LAVA_SPONGE.get()).add(BlockRegister.LAVA_SPONGE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegister.HOT_LAVA_SPONGE.get()).add(BlockRegister.LAVA_SPONGE.get());
    }

    @Override
    public String getName() {
        return "LavaSponge Tags";
    }
}
