package uno.rebellious.lavasponge;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uno.rebellious.lavasponge.blocks.BlockRegister;
import uno.rebellious.lavasponge.config.LavaSpongeConfig;
import net.minecraftforge.fml.config.ModConfig;

@Mod(LavaSponge.MODID)
public class LavaSponge {

    public static final String MODID = "lavasponge";

    private static final Logger LOGGER = LogManager.getLogger();

    public LavaSponge() {
        BlockRegister.registerBlocks();
        ModSetup.setup();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, LavaSpongeConfig.SERVER_CONFIG);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
    }





}
