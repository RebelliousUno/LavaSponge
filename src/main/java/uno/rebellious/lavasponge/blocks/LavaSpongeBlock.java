package uno.rebellious.lavasponge.blocks;

import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Queue;


public class LavaSpongeBlock extends SpongeBlock {

    public LavaSpongeBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    protected void tryAbsorbWater(World worldIn, BlockPos pos) {
        if (this.absorb(worldIn, pos)) {
            worldIn.setBlock(pos, BlockRegister.HOT_LAVA_SPONGE.get().defaultBlockState(), 2);
            worldIn.levelEvent(2001, pos, Block.getId(Blocks.LAVA.defaultBlockState()));
        }
    }

    private boolean absorb(World worldIn, BlockPos pos) {
        Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
        queue.add(new Tuple<>(pos, 0));
        int i = 0;

        while (!queue.isEmpty()) {
            Tuple<BlockPos, Integer> tuple = queue.poll();
            BlockPos blockPos = tuple.getA();
            int j = tuple.getB();
            for (Direction direction : Direction.values()) {
                BlockPos blockPos1 = blockPos.relative(direction);
                BlockState blockState = worldIn.getBlockState(blockPos1);
                FluidState fluidState = worldIn.getFluidState(blockPos1);
                if (fluidState.is(FluidTags.LAVA)) {
                    if (blockState.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler) blockState.getBlock()).takeLiquid(worldIn, blockPos1, blockState) != Fluids.EMPTY) {
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockPos1, j + 1));
                        }
                    } else if (blockState.getBlock() instanceof FlowingFluidBlock) {
                        worldIn.setBlock(blockPos1, Blocks.AIR.defaultBlockState(), 3);
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockPos1, j + 1));
                        }
                    }
                }
            }
            if (i > 64) {
                break;
            }
        }
        return i > 0;
    }
}
