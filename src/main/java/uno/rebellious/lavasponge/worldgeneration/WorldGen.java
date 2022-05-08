package uno.rebellious.lavasponge.worldgeneration;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import uno.rebellious.lavasponge.blocks.BlockRegister;
import uno.rebellious.lavasponge.config.LavaSpongeConfig;

import static net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.anyOf;
import static net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.matchesFluid;

public class WorldGen {

    public static Holder<PlacedFeature> LAVA_SPONGE_GEN;
    public static final int NETHER_VEINSIZE = LavaSpongeConfig.VEIN_SIZE.get();
    public static final int NETHER_AMOUNT = LavaSpongeConfig.NETHER_AMOUNT.get();


    public static void registerConfiguredFeatures() {
        OreConfiguration netherConfig = new OreConfiguration(new BlockMatchTest(Blocks.MAGMA_BLOCK),
                BlockRegister.LAVA_SPONGE.get().defaultBlockState(), NETHER_VEINSIZE);
        LAVA_SPONGE_GEN = registerPlacedFeature("lavasponge_nether", new ConfiguredFeature<>(Feature.SCATTERED_ORE, netherConfig),
                CountPlacement.of(NETHER_AMOUNT),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(36)),
                BlockPredicateFilter.forPredicate(anyOf( //Exposed to Lava
                        matchesFluid(Fluids.LAVA, new BlockPos(-1, 0, 0)),
                        matchesFluid(Fluids.LAVA, new BlockPos(1, 0, 0)),
                        matchesFluid(Fluids.LAVA, new BlockPos(0, 0, -1)),
                        matchesFluid(Fluids.LAVA, new BlockPos(0, 0, 1)),
                        matchesFluid(Fluids.LAVA, new BlockPos(0, 1, 0)),
                        matchesFluid(Fluids.LAVA, new BlockPos(0, -1, 0))
                        ))
        );
    }


    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName,
                                                                                                                      ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }


    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (LavaSpongeConfig.WORLD_GEN.get() && event.getCategory() == Biome.BiomeCategory.NETHER) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LAVA_SPONGE_GEN);
        }
    }
}
