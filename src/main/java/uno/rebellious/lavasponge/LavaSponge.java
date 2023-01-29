package uno.rebellious.lavasponge;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uno.rebellious.lavasponge.blocks.BlockRegister;
import uno.rebellious.lavasponge.config.LavaSpongeConfig;
import uno.rebellious.lavasponge.modifiers.LootModifierRegister;

@Mod(LavaSponge.MODID)
public class LavaSponge {

    public static final String MODID = "lavasponge";

    private static final Logger LOGGER = LogManager.getLogger();

    public LavaSponge() {
        BlockRegister.registerBlocks();
        LootModifierRegister.registerLootModifers();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, LavaSpongeConfig.SERVER_CONFIG);

    }
//
//    static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);
//    static DeferredRegister<Codec<LavaSpongeBiomeModifier>> CODEC = BIOME_MODIFIER_SERIALIZERS.register("lavasponge_nether", () ->
//            RecordCodecBuilder.create(builder -> builder.group(
//                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(LavaSpongeBiomeModifier::biomes),
//                    PlacedFeature.CODEC.fieldOf("feature").forGetter(LavaSpongeBiomeModifier::feature)
//            ).apply(builder, LavaSpongeBiomeModifier::new)));


}
