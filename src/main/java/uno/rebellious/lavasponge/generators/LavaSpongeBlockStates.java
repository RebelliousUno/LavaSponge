
package uno.rebellious.lavasponge.generators;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static uno.rebellious.lavasponge.blocks.BlockRegister.HOT_LAVA_SPONGE;
import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;

public class LavaSpongeBlockStates extends BlockStateProvider {
    public LavaSpongeBlockStates(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(HOT_LAVA_SPONGE.get());
        simpleBlock(LAVA_SPONGE.get());
    }
}
