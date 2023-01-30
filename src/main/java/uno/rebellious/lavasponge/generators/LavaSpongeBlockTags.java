package uno.rebellious.lavasponge.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.concurrent.CompletableFuture;

public class LavaSpongeBlockTags extends BlockTagsProvider {
    public LavaSpongeBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegister.HOT_LAVA_SPONGE.get()).add(BlockRegister.LAVA_SPONGE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegister.HOT_LAVA_SPONGE.get()).add(BlockRegister.LAVA_SPONGE.get());
    }

    @Override
    public String getName() {
        return "LavaSponge Tags";
    }

}
