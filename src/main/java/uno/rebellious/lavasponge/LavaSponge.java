package uno.rebellious.lavasponge;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uno.rebellious.lavasponge.blocks.BlockRegister;

@Mod(LavaSponge.MODID)
public class LavaSponge {

    public static final String MODID = "lavasponge";

    private static final Logger LOGGER = LogManager.getLogger();

    public LavaSponge() {
        BlockRegister.registerBlocks();
    }

}
