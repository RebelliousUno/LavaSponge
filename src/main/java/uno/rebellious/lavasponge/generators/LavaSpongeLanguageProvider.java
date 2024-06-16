package uno.rebellious.lavasponge.generators;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static uno.rebellious.lavasponge.blocks.BlockRegister.HOT_LAVA_SPONGE;
import static uno.rebellious.lavasponge.blocks.BlockRegister.LAVA_SPONGE;

public class LavaSpongeLanguageProvider extends LanguageProvider {

    private static final String TAB_NAME = "lavasponge";

    public LavaSpongeLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }


    @Override
    protected void addTranslations() {
        add("item_group." + TAB_NAME + ".item_group", "LavaSponge");
        add(HOT_LAVA_SPONGE.get(), "Hot Lava Sponge");
        add(LAVA_SPONGE.get(), "Lava Sponge");
        add(HOT_LAVA_SPONGE.get().getDescriptionId() + ".description", "Surround with 5 Ice Blocks, or use as a fuel in a furnace to cool down.");
    }
}