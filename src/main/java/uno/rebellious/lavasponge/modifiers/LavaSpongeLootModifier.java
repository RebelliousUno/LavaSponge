package uno.rebellious.lavasponge.modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;

public class LavaSpongeLootModifier extends LootModifier {

    public static final Supplier<MapCodec<LavaSpongeLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
            .and(Codec.DOUBLE.fieldOf("chance").forGetter(m -> m.chance))
            .apply(inst, LavaSpongeLootModifier::new)));
    private final double chance;

    public LavaSpongeLootModifier(LootItemCondition[] conditionsIn, double chance) {
        super(conditionsIn);
        this.chance = chance > 1 ? 1 : chance < 0 ? 0 : chance;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        double roll = RandomSource.create().nextDouble();
        if (roll < chance) generatedLoot.add(new ItemStack(LAVA_SPONGE.get()));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}