package uno.rebellious.lavasponge.events;


import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uno.rebellious.lavasponge.LavaSponge;
import uno.rebellious.lavasponge.blocks.BlockRegister;
@Mod.EventBusSubscriber(modid = LavaSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Events {

    private static CreativeModeTab LAVASPONGE_TAB;

    @SubscribeEvent
    public static void addToTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == LAVASPONGE_TAB) {
            event.accept(BlockRegister.HOT_LAVA_SPONGE);
            event.accept(BlockRegister.LAVA_SPONGE);
        }
    }
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        LAVASPONGE_TAB = event.registerCreativeModeTab(new ResourceLocation(LavaSponge.MODID, "lavasponge"), builder -> {
            builder.title(Component.translatable("item_group." + LavaSponge.MODID + ".item_group")).icon(() -> new ItemStack(BlockRegister.LAVA_SPONGE_ITEM.get())).build();
        });
    }

}
