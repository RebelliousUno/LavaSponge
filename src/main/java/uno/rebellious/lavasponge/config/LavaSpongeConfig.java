package uno.rebellious.lavasponge.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class LavaSpongeConfig {
    public static final String CATEGORY_GENERAL = "general";
    public static final String SUBCATEGORY_WORLD_GENERATION = "worldGen";
    public static ForgeConfigSpec.BooleanValue WORLD_GEN;
    public static ForgeConfigSpec.IntValue VEIN_SIZE;
    public static ForgeConfigSpec.IntValue NETHER_AMOUNT;
    public static ForgeConfigSpec SERVER_CONFIG;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        SERVER_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        WORLD_GEN = SERVER_BUILDER.comment("Should generate in world").define("world_gen", true);
        VEIN_SIZE = SERVER_BUILDER.comment("Lava Sponge Vein Size").defineInRange("vein_size", 1, 0, 50);
        NETHER_AMOUNT = SERVER_BUILDER.comment("Nether Amount").defineInRange("nether_amount", 100, 0, 200);
        SERVER_BUILDER.pop();
        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading configEvent) {
    }
}
