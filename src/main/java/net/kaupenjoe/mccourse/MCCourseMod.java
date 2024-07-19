package net.kaupenjoe.mccourse;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.command.ReturnHomeCommand;
import net.kaupenjoe.mccourse.command.SetHomeCommand;
import net.kaupenjoe.mccourse.effect.ModEffects;
import net.kaupenjoe.mccourse.event.PlayerCopyHandler;
import net.kaupenjoe.mccourse.item.ModItemGroups;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.potion.ModPotions;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.villager.ModVillagers;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();
		ModEffects.registerEffects();

		ModPotions.registerPotions();
		ModVillagers.registerVillagers();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
		CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
		ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

		registerCustomTrades();
	}

	private static void registerCustomTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.STRAWBERRY, 6), 6, 2, 0.04f
			));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 9),
					new ItemStack(ModItems.CHAINSAW, 1), 1, 6, 0.09f
			));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 6),
					new ItemStack(ModItems.FLUORITE, 19), 4, 1, 0.04f
			));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 6),
					new ItemStack(ModItems.RAW_FLUORITE, 19), 4, 1, 0.04f
			));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.FLUORITE, 6),
					new ItemStack(ModItems.SPECTRE_STAFF, 1), 1, 8, 0.04f
			));
		});
	}
}