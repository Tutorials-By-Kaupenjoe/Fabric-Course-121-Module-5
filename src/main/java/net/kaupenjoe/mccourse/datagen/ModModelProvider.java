package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool fluoriteTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLUORITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_NETHER_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        fluoriteTexturePool.stairs(ModBlocks.FLUORITE_STAIRS);
        fluoriteTexturePool.slab(ModBlocks.FLUORITE_SLAB);

        fluoriteTexturePool.button(ModBlocks.FLUORITE_BUTTON);
        fluoriteTexturePool.pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE);

        fluoriteTexturePool.fence(ModBlocks.FLUORITE_FENCE);
        fluoriteTexturePool.fenceGate(ModBlocks.FLUORITE_FENCE_GATE);
        fluoriteTexturePool.wall(ModBlocks.FLUORITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.FLUORITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.FLUORITE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLUORITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHAINSAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
    }
}
