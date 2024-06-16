package uno.rebellious.lavasponge.config;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import uno.rebellious.lavasponge.LavaSponge;

@EventBusSubscriber(modid = LavaSponge.MODID, bus = EventBusSubscriber.Bus.MOD)
public class LavaSpongeConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue PIGLIN_BRUTE_DROP_CHANCE;
    private static final ModConfigSpec.DoubleValue PIGLIN_DROP_CHANCE;
    private static final ModConfigSpec.DoubleValue ZOMBIE_PIGLIN_DROP_CHANCE;

    public static final String CATEGORY_GENERAL = "general";

    public static ModConfigSpec SERVER_CONFIG;

    static {
        BUILDER.comment("General Settings").push(CATEGORY_GENERAL);

        PIGLIN_BRUTE_DROP_CHANCE = BUILDER.comment("Piglin Brute Drop Chance").defineInRange("piglin_brute_drop_chance", 0.5, 0, 1);
        PIGLIN_DROP_CHANCE = BUILDER.comment("Piglin Drop Chance").defineInRange("piglin_drop_chance", 0.25, 0, 1);
        ZOMBIE_PIGLIN_DROP_CHANCE = BUILDER.comment("Zombie Piglin Drop Chance").defineInRange("zombie_piglin_drop_chance", 0.25, 0, 1);
        BUILDER.pop();
        SERVER_CONFIG = BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent configEvent) {
    }
}