package uno.rebellious.lavasponge.modifiers;

import com.mojang.serialization.MapCodec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uno.rebellious.lavasponge.LavaSponge;

public class LootModifierRegister {
    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, LavaSponge.MODID);
    private static final RegistryObject<MapCodec<LavaSpongeLootModifier>> LAVA_SPONGE_LOOT_MODIFIER = GLM.register("lava_sponge_loot_mod", LavaSpongeLootModifier.CODEC);

    public static void registerLootModifers() {
        GLM.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
