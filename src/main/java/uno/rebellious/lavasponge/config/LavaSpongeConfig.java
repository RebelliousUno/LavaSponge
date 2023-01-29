package uno.rebellious.lavasponge.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class LavaSpongeConfig {
    public static final String CATEGORY_GENERAL = "general";
    public static final String SUBCATEGORY_DROP_CHANCES = "drop_chance";

    public static ForgeConfigSpec.DoubleValue PIGLIN_BRUTE_DROP_CHANCE;
    public static ForgeConfigSpec.DoubleValue PIGLIN_DROP_CHANCE;
    public static ForgeConfigSpec.DoubleValue ZOMBIE_PIGLIN_DROP_CHANCE;
    public static ForgeConfigSpec SERVER_CONFIG;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        SERVER_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        PIGLIN_BRUTE_DROP_CHANCE = SERVER_BUILDER.comment("Piglin Brute Drop Chance").defineInRange("piglin_brute_drop_chance", 0.5, 0, 1);
        PIGLIN_DROP_CHANCE = SERVER_BUILDER.comment("Piglin Drop Chance").defineInRange("piglin_drop_chance", 0.25, 0, 1);
        ZOMBIE_PIGLIN_DROP_CHANCE = SERVER_BUILDER.comment("Zombie Piglin Drop Chance").defineInRange("zombie_piglin_drop_chance", 0.25, 0, 1);
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
