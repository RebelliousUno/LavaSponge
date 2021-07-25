package uno.rebellious.lavasponge.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class HotLavaSpongeBlock extends Block {
    public HotLavaSpongeBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
        doCoolDownCheck(worldIn, pos);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        doCoolDownCheck(worldIn, pos);
    }

    private void doCoolDownCheck(World worldIn, BlockPos pos) {
        long count = iceDirectionStreamProvider(worldIn, pos)
                .count();
        if (count >= 5) {
            worldIn.setBlock(pos, BlockRegister.LAVA_SPONGE.get().defaultBlockState(), 3);
            worldIn.levelEvent(2001, pos, Block.getId(Blocks.ICE.defaultBlockState()));

            BlockState blockToReplace = worldIn.dimensionType().ultraWarm() ? Blocks.AIR.defaultBlockState() : Blocks.WATER.defaultBlockState();

            iceDirectionStreamProvider(worldIn, pos)
                    .forEach(direction -> worldIn.setBlock(pos.relative(direction), blockToReplace, 3));
        }
    }

    private Stream<Direction> iceDirectionStreamProvider(World worldIn, BlockPos pos) {
        return Arrays.stream(Direction.values())
                .filter(direction -> worldIn.getBlockState(pos.relative(direction)).getBlock().getTags().contains(new ResourceLocation("minecraft:ice")));
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
     * of whether the block can receive random update ticks
     * Taken from WetSpongeBlock since it doesn't take a type of particle to drip..
     */
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandom(rand);
        if (direction == Direction.UP) return;

        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = worldIn.getBlockState(blockpos);

        if (!stateIn.canOcclude() || !blockstate.isFaceSturdy(worldIn, blockpos, direction.getOpposite())) {
            double dripX = pos.getX();
            double dripY = pos.getY();
            double dripZ = pos.getZ();
            if (direction == Direction.DOWN) {
                dripY -= 0.05D; //Start drip at a slight below Y
                dripX += rand.nextDouble(); //Random X
                dripZ += rand.nextDouble(); //Random Z
            } else {
                dripY += (rand.nextDouble() * 0.8D); // Y + random/8
                if (direction.getAxis() == Direction.Axis.X) { // if EAST West
                    dripZ += rand.nextDouble(); // Randomise the Z position (
                    if (direction == Direction.EAST) {
                        ++dripX;
                    } else {
                        dripX += 0.05D;  //if West increment X by a bit
                    }
                } else { //AXIS is Z (So NORTH/SOUTH)
                    dripX += rand.nextDouble();
                    if (direction == Direction.SOUTH) {
                        ++dripZ; // Decrement Z if South
                    } else {
                        dripZ += 0.05D; // Increment Z if North
                    }
                }
            }
            worldIn.addParticle(ParticleTypes.DRIPPING_LAVA, dripX, dripY, dripZ, 0.0D, 0.0D, 0.0D);
        }
    }
}
