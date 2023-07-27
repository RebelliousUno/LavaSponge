package uno.rebellious.lavasponge.generators;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraftforge.registries.ForgeRegistries;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import java.util.Map;
import java.util.stream.Collectors;

public class LavaSpongeLootTables extends VanillaBlockLoot {

    @Override
    public void generate() {
        dropSelf(BlockRegister.HOT_LAVA_SPONGE.get());
        dropSelf(BlockRegister.LAVA_SPONGE.get());
    }

    @Override
    protected Iterable getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(LavaSponge.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}

