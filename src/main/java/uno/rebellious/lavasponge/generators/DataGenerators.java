package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uno.rebellious.lavasponge.LavaSponge;

@Mod.EventBusSubscriber(modid = LavaSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider(event.includeServer(), new LavaSpongeRecipes(generator));
        generator.addProvider(event.includeServer(), new LavaSpongeLootTables(generator));
        LavaSpongeBlockTags blockTags = new LavaSpongeBlockTags(generator, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new LavaSpongeItemTags(generator, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new LavaSpongeLootModifierGenerator(generator, LavaSponge.MODID));

        generator.addProvider(event.includeClient(), new LavaSpongeBlockStates(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeItemModels(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeLanguageProvider(generator, "en_us"));

    }
}
