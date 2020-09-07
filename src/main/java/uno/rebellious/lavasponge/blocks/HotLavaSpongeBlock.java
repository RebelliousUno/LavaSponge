package uno.rebellious.lavasponge.blocks;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;

public class HotLavaSpongeBlock extends WetSpongeBlock {
    public HotLavaSpongeBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        //If placed with Ice on at least 5 sides covert to lava sponge
        //
        long c = Arrays.stream(Direction.values())
                .filter( direction -> worldIn.getBlockState(pos.offset(direction)).getBlock() instanceof IceBlock)
                .count();
        if (c >= 5) {
            worldIn.setBlockState(pos, BlockRegister.LAVA_SPONGE.get().getDefaultState(), 3);
        }
    }
}
