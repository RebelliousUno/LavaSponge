package uno.rebellious.lavasponge.modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;
import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE_ITEM;

public class LavaSpongeLootModifier extends LootModifier {
    double chance;
    public static final Supplier<Codec<LavaSpongeLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst)
            .and(Codec.DOUBLE.fieldOf("chance").forGetter(m -> m.chance))
            .apply(inst, LavaSpongeLootModifier::new)));

    public LavaSpongeLootModifier(LootItemCondition[] conditionsIn, double chance) {
        super(conditionsIn);
        this.chance = chance > 1 ? 1 : chance;
        if (this.chance < 0) this.chance = 0;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        double roll = RandomSource.create().nextDouble();
        if (roll < chance) generatedLoot.add(new ItemStack(LAVA_SPONGE.get()));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
