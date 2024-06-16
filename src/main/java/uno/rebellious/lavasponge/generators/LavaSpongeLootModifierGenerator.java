package uno.rebellious.lavasponge.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import uno.rebellious.lavasponge.modifiers.LavaSpongeLootModifier;

import java.util.concurrent.CompletableFuture;

public class LavaSpongeLootModifierGenerator extends GlobalLootModifierProvider {


    public LavaSpongeLootModifierGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, modid, registries);
    }

    @Override
    protected void start(HolderLookup.Provider provider) {
        this.add("piglin_brute_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.PIGLIN_BRUTE.getDefaultLootTable().location()).build()
                }, 0.5
        ));
        this.add("piglin_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.PIGLIN.getDefaultLootTable().location()).build()
                }, 0.05
        ));
        this.add("zombie_piglin_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.ZOMBIFIED_PIGLIN.getDefaultLootTable().location()).build()
                }, 0.05
        ));
    }
}
