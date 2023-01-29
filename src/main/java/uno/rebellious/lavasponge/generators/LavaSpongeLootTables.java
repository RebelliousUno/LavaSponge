package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.PiglinBarterLoot;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.block.Block;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeLootTables extends BaseLootTableProvider {
    public LavaSpongeLootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockRegister.HOT_LAVA_SPONGE.get(), createSimpleTable("hot_lavasponge", BlockRegister.HOT_LAVA_SPONGE.get()));
        lootTables.put(BlockRegister.LAVA_SPONGE.get(), createSimpleTable("lavasponge", BlockRegister.LAVA_SPONGE.get()));
    }
}

