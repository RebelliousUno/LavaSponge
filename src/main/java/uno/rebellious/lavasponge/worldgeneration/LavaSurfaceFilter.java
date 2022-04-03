package uno.rebellious.lavasponge.worldgeneration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.Random;

public class LavaSurfaceFilter extends PlacementFilter {

    private LavaSurfaceFilter() {}

    @Override
    protected boolean shouldPlace(PlacementContext p_191835_, Random p_191836_, BlockPos p_191837_) {
        return false;
    }

    @Override
    public PlacementModifierType<?> type() {
        return null;
    }
}
