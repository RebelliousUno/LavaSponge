package uno.rebellious.lavasponge;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import uno.rebellious.lavasponge.config.LavaSpongeConfig;

import static uno.rebellious.lavasponge.blocks.BlockRegister.*;
import static uno.rebellious.lavasponge.modifiers.LootModifierRegister.GLM;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LavaSponge.MODID)
public class LavaSponge
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lavasponge";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();





    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public LavaSponge(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
        GLM.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, LavaSpongeConfig.SERVER_CONFIG);
    }
}
