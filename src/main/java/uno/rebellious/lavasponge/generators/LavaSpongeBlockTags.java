package uno.rebellious.lavasponge.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static uno.rebellious.lavasponge.blocks.BlockRegister.HOT_LAVA_SPONGE;
import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;

public class LavaSpongeBlockTags extends BlockTagsProvider {
    public LavaSpongeBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_HOE).add(HOT_LAVA_SPONGE.get()).add(LAVA_SPONGE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(HOT_LAVA_SPONGE.get()).add(LAVA_SPONGE.get());
    }

    @Override
    public String getName() {
        return "LavaSponge Tags";
    }
}
