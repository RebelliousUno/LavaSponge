package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import uno.rebellious.lavasponge.LavaSponge;

@Mod.EventBusSubscriber(modid = LavaSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new LavaSpongeRecipes(generator));
            generator.addProvider(new LavaSpongeLootTables(generator));
            LavaSpongeBlockTags blockTags = new LavaSpongeBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new LavaSpongeItemTags(generator, blockTags, event.getExistingFileHelper()));
            //generator.addProvider(new LavaSpongeLootTablesModifier(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new LavaSpongeBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new LavaSpongeItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new LavaSpongeLanguageProvider(generator, "en_us"));
        }
    }
}
