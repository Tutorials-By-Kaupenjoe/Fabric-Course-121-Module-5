package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.custom.ChainsawItem;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxDamage(32)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.mccourse.strawberry.tooltip.1"));

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));

    public static final Item SPECTRE_STAFF = registerItem("spectre_staff",
            new Item(new Item.Settings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
