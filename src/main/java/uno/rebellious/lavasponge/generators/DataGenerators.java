package uno.rebellious.lavasponge.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uno.rebellious.lavasponge.LavaSponge;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = LavaSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LavaSpongeRecipes(output));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(LavaSpongeLootTables::new, LootContextParamSets.BLOCK))));
        LavaSpongeBlockTags blockTags = new LavaSpongeBlockTags(output, lookupProvider, LavaSponge.MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new LavaSpongeItemTags(output, lookupProvider, blockTags.contentsGetter(), LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new LavaSpongeLootModifierGenerator(output, LavaSponge.MODID));

        generator.addProvider(event.includeClient(), new LavaSpongeBlockStates(output, LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeItemModels(output, LavaSponge.MODID, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LavaSpongeLanguageProvider(output, LavaSponge.MODID, "en_us"));

    }
}
