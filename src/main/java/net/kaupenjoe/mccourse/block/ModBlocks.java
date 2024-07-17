package net.kaupenjoe.mccourse.block;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f).requiresTool()));

    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()));
    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(6f).requiresTool()));

    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(7f).requiresTool()));
    public static final Block FLUORITE_NETHER_ORE = registerBlock("fluorite_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block FLUORITE_STAIRS = registerBlock("fluorite_stairs",
            new StairsBlock(ModBlocks.FLUORITE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block FLUORITE_SLAB = registerBlock("fluorite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block FLUORITE_BUTTON = registerBlock("fluorite_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create().requiresTool()));
    public static final Block FLUORITE_PRESSURE_PLATE = registerBlock("fluorite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLUORITE_FENCE = registerBlock("fluorite_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool()));
    public static final Block FLUORITE_FENCE_GATE = registerBlock("fluorite_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().requiresTool()));
    public static final Block FLUORITE_WALL = registerBlock("fluorite_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()));

    public static final Block FLUORITE_DOOR = registerBlock("fluorite_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));
    public static final Block FLUORITE_TRAPDOOR = registerBlock("fluorite_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MCCourseMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MCCourseMod.LOGGER.info("Registering Mod Blocks for " + MCCourseMod.MOD_ID);
    }
}
