package uno.rebellious.lavasponge.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class HotLavaSpongeBlock extends Block {
    public HotLavaSpongeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("block.lavasponge.hot_lavasponge.description"));
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
        doCoolDownCheck(worldIn, pos);
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        doCoolDownCheck(worldIn, pos);
    }

    private void doCoolDownCheck(Level worldIn, BlockPos pos) {
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

    private Stream<Direction> iceDirectionStreamProvider(Level worldIn, BlockPos pos) {
        return Arrays.stream(Direction.values())
                .filter(direction -> worldIn.getBlockState(pos.relative(direction)).is(BlockTags.ICE));
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
     * of whether the block can receive random update ticks
     * Taken from WetSpongeBlock since it doesn't take a type of particle to drip..
     */
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
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
