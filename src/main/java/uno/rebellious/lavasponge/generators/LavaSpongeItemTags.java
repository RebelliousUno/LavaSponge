package uno.rebellious.lavasponge.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static uno.rebellious.lavasponge.blocks.BlockRegister.ICE_ITEM_TAG;

public class LavaSpongeItemTags extends ItemTagsProvider {
    public LavaSpongeItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookupCompletableFuture, String modid, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookupCompletableFuture, modid, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //No Item Tags Needed
        tag(ICE_ITEM_TAG).add(Blocks.ICE.asItem()).add(Blocks.PACKED_ICE.asItem()).add(Blocks.BLUE_ICE.asItem());
    }

    @Override
    public String getName() {
        return "LavaSponge Item Tags";
    }
}
