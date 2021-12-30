package uno.rebellious.lavasponge.blocks;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.Queue;


public class LavaSpongeBlock extends SpongeBlock {

    public LavaSpongeBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void tryAbsorbWater(Level worldIn, BlockPos pos) {
        if (this.absorb(worldIn, pos)) {
            worldIn.setBlock(pos, BlockRegister.HOT_LAVA_SPONGE.get().defaultBlockState(), 2);
            worldIn.levelEvent(2001, pos, Block.getId(Blocks.LAVA.defaultBlockState()));
        }
    }

    private boolean absorb(Level worldIn, BlockPos pos) {
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
                    if (blockState.getBlock() instanceof BucketPickup && !((BucketPickup) blockState.getBlock()).pickupBlock(worldIn, blockPos1, blockState).isEmpty()) {
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockPos1, j + 1));
                        }
                    } else if (blockState.getBlock() instanceof LiquidBlock) {
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
