package uno.rebellious.lavasponge.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;

public class LavaSpongeLanguageProvider extends LanguageProvider {

    private static final String TAB_NAME = "lavasponge";

    public LavaSpongeLanguageProvider(DataGenerator generator, String locale) {
        super(generator, LavaSponge.MODID, locale);
    }


    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "LavaSponge");
        add(BlockRegister.HOT_LAVA_SPONGE.get(), "Hot Lava Sponge");
        add(BlockRegister.LAVA_SPONGE.get(), "Lava Sponge");
        add(BlockRegister.HOT_LAVA_SPONGE.get().getDescriptionId() + ".description", "Surround with 5 Ice Blocks, or use as a fuel in a furnace to cool down.");
    }
}
