package uno.rebellious.lavasponge.generators;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import uno.rebellious.lavasponge.LavaSponge;

import static uno.rebellious.lavasponge.blocks.BlockRegister.*;

public class LavaspongeLootTables extends VanillaBlockLoot {

    public LavaspongeLootTables(HolderLookup.Provider provider) {
        super(provider);
    }

    @Override
    protected void generate() {
        dropSelf(HOT_LAVA_SPONGE.get());
        dropSelf(LAVA_SPONGE.get());
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS.getEntries() // Get all registered entries
                .stream() // Stream the wrapped objects
                .filter(e -> e.getKey().location().getNamespace().equals(LavaSponge.MODID))
                .map(Holder::value) // Get the object if available
                .toList(); // Create the iterable
    }
}
