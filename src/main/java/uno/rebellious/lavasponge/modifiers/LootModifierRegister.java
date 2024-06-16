package uno.rebellious.lavasponge.modifiers;


import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import uno.rebellious.lavasponge.LavaSponge;

public class LootModifierRegister {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, LavaSponge.MODID);
    private static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<LavaSpongeLootModifier>> LAVA_SPONGE_LOOT_MODIFIER = GLM.register("lava_sponge_loot_mode", LavaSpongeLootModifier.CODEC);
}