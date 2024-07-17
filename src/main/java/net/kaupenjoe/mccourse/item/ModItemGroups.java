package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FLUORITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "fluorite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite"))
                    .icon(() -> new ItemStack(ModItems.FLUORITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FLUORITE);
                        entries.add(ModItems.RAW_FLUORITE);

                        entries.add(ModItems.CHAINSAW);
                        entries.add(ModItems.STRAWBERRY);

                        entries.add(ModItems.STARLIGHT_ASHES);

                    }).build());

    public static final ItemGroup FLUORITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "fluorite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLUORITE_BLOCK);

                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.FLUORITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.FLUORITE_END_ORE);
                        entries.add(ModBlocks.FLUORITE_NETHER_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                        entries.add(ModBlocks.FLUORITE_STAIRS);
                        entries.add(ModBlocks.FLUORITE_SLAB);

                        entries.add(ModBlocks.FLUORITE_BUTTON);
                        entries.add(ModBlocks.FLUORITE_PRESSURE_PLATE);

                        entries.add(ModBlocks.FLUORITE_FENCE);
                        entries.add(ModBlocks.FLUORITE_FENCE_GATE);
                        entries.add(ModBlocks.FLUORITE_WALL);

                        entries.add(ModBlocks.FLUORITE_DOOR);
                        entries.add(ModBlocks.FLUORITE_TRAPDOOR);

                    }).build());

    public static void registerItemGroups() {
        MCCourseMod.LOGGER.info("Registering Item Groups for " + MCCourseMod.MOD_ID);
    }
}
