package net.kaupenjoe.mccourse.fluid;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid STILL_FLUORITE_WATER = Registry.register(Registries.FLUID,
            Identifier.of(MCCourseMod.MOD_ID, "fluorite_water"), new FluoriteWaterFluid.Still());
    public static final FlowableFluid FLOWING_FLUORITE_WATER = Registry.register(Registries.FLUID,
            Identifier.of(MCCourseMod.MOD_ID, "flowing_fluorite_water"), new FluoriteWaterFluid.Flowing());

    public static final Block FLUORITE_WATER_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(MCCourseMod.MOD_ID,
            "fluorite_water_block"), new FluidBlock(ModFluids.STILL_FLUORITE_WATER, Block.Settings.copy(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item FLUORITE_WATER_BUCKET = Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID,
            "fluorite_water_bucket"), new BucketItem(ModFluids.STILL_FLUORITE_WATER,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {
        MCCourseMod.LOGGER.info("Registering Fluid for " + MCCourseMod.MOD_ID);
    }
}