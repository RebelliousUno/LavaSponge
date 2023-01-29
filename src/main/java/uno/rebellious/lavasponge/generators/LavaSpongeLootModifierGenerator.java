package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.predicates.ConditionReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import uno.rebellious.lavasponge.modifiers.LavaSpongeLootModifier;

import static uno.rebellious.lavasponge.config.LavaSpongeConfig.*;

public class LavaSpongeLootModifierGenerator extends GlobalLootModifierProvider {

    public LavaSpongeLootModifierGenerator(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        this.add("piglin_brute_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.PIGLIN_BRUTE.getDefaultLootTable()).build()
                }, 0.5
        ));
        this.add("piglin_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.PIGLIN.getDefaultLootTable()).build()
                }, 0.25
        ));
        this.add("zombie_piglin_modifier", new LavaSpongeLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(EntityType.ZOMBIFIED_PIGLIN.getDefaultLootTable()).build()
                }, 0.25
        ));
    }
}
