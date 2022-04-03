package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeBlockStates extends BlockStateProvider {
    public LavaSpongeBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, LavaSponge.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegister.HOT_LAVA_SPONGE.get());
        simpleBlock(BlockRegister.LAVA_SPONGE.get());
    }
}
