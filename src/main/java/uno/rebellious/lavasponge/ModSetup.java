package uno.rebellious.lavasponge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;
import uno.rebellious.lavasponge.worldgeneration.WorldGen;

@Mod.EventBusSubscriber(modid = LavaSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(WorldGen::onBiomeLoadingEvent);
    }

    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(WorldGen::registerConfiguredFeatures);
    }
}
