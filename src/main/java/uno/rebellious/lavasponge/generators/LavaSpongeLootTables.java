package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.function.BiConsumer;

import static uno.rebellious.lavasponge.generators.LootTableHelper.createSimpleTable;

public class LavaSpongeLootTables implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> builder) {
        builder.accept(BlockRegister.HOT_LAVA_SPONGE.getId(), createSimpleTable("hot_lavasponge", BlockRegister.HOT_LAVA_SPONGE.get()));
        builder.accept(BlockRegister.LAVA_SPONGE.getId(), createSimpleTable("lavasponge", BlockRegister.LAVA_SPONGE.get()));
    }
}

