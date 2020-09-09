package uno.rebellious.lavasponge.blocks;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import uno.rebellious.lavasponge.LavaSponge;

import java.util.Arrays;
import java.util.stream.Stream;

public class HotLavaSpongeBlock extends WetSpongeBlock {
    public HotLavaSpongeBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        long count = iceDirectionStreamProvider(worldIn, pos)
                .count();


        if (count >= 5) {
            worldIn.setBlockState(pos, BlockRegister.LAVA_SPONGE.get().getDefaultState(), 3);
            worldIn.playEvent(2001, pos, Block.getStateId(Blocks.ICE.getDefaultState()));
            iceDirectionStreamProvider(worldIn, pos)
                    .forEach(direction -> {
                        worldIn.setBlockState(pos.offset(direction), Blocks.WATER.getDefaultState(), 3);
                    });
        }
    }

    private Stream<Direction> iceDirectionStreamProvider(World worldIn, BlockPos pos) {
        return Arrays.stream(Direction.values())
                .filter(direction -> worldIn.getBlockState(pos.offset(direction)).getBlock().getTags().contains(new ResourceLocation("minecraft:ice")));
    }
}
