package uno.rebellious.lavasponge.generators;


import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import uno.rebellious.lavasponge.blocks.BlockRegister;

import javax.annotation.Nonnull;
import java.util.List;

public class LavaSpongeChestModifier extends LootModifier {

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected LavaSpongeChestModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(BlockRegister.LAVA_SPONGE_ITEM.get()));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<LavaSpongeChestModifier> {

        @Override
        public LavaSpongeChestModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            return new LavaSpongeChestModifier(ailootcondition);
        }

        @Override
        public JsonObject write(LavaSpongeChestModifier instance) {
            return null;
        }
    }
}