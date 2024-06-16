package uno.rebellious.lavasponge.generators;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import uno.rebellious.lavasponge.LavaSponge;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = LavaSponge.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LavaspongeRecipes(output, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(LavaspongeLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));
        var blockTags = new LavaSpongeBlockTags(output, lookupProvider, LavaSponge.MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new LavaSpongeItemTags(output, lookupProvider, blockTags.contentsGetter(), LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new LavaSpongeLootModifierGenerator(output, lookupProvider, LavaSponge.MODID));
        generator.addProvider(event.includeClient(), new LavaSpongeBlockStates(output, LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeItemModels(output, LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeLanguageProvider(output, LavaSponge.MODID, "en_us"));
    }
}