package com.theishiopian.foragecraft;

import com.theishiopian.foragecraft.handler.BlockForageHandler;
import com.theishiopian.foragecraft.handler.FuelHandler;
import com.theishiopian.foragecraft.handler.PotatoPlanter;
import com.theishiopian.foragecraft.handler.RecipeHandler;
import com.theishiopian.foragecraft.handler.SpawnHandler;
import com.theishiopian.foragecraft.init.ModBlocks;
import com.theishiopian.foragecraft.init.ModEntities;
import com.theishiopian.foragecraft.init.ModItems;
import com.theishiopian.foragecraft.proxy.CommonProxy;
import com.theishiopian.foragecraft.world.generation.FCMasterWorldGenerator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MODID,name=Reference.NAME,version=Reference.VERSION,acceptedMinecraftVersions=Reference.MC_VERSIONS,updateJSON=Reference.UPDATE_JSON)

public class ForageCraftMod 
{
	@SidedProxy(clientSide=Reference.CLIENTPROXY, serverSide=Reference.SERVERPROXY)
	public static CommonProxy proxy;
	
	@Instance
	public static ForageCraftMod instance;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		// Call config
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		// Load config
		config.load();

		// leaves
		ConfigVariables.branchChance = config.getFloat("Branch chance", "Sticks from leaves", 1.0f, 0.0f, 1.0f, Descriptions.configBranchChance);
		ConfigVariables.branchMaxAmount = config.getInt("Maximum branch amount", "Sticks from leaves", 1, 0, 64, Descriptions.configBranchMaxAmount);
		
		// grass block
		ConfigVariables.rootChance = config.getFloat("Root chance", "Sticks from grass blocks", 0.09f, 0.0f, 1.0f, Descriptions.configRootChance);
		ConfigVariables.rootMaxAmount=config.getInt("Maximum root amount", "Sticks from grass blocks", 1, 0, 64, Descriptions.configRootMaxAmount);
		
		ConfigVariables.rockChance = config.getFloat("Rock chance", "Rocks from various blocks", 0.09f, 0.0f, 1.0f, Descriptions.configRockChance);
		ConfigVariables.rockMaxAmount = config.getInt("Maximum rock amount", "Rocks from various blocks", 1, 0, 64, Descriptions.configRockMaxAmount);
		
		ConfigVariables.wildCarrotChance = config.getFloat("Carrot chance", "Carrots from grass blocks", 0.01f, 0.0f, 1.0f, Descriptions.configWildCarrotChance);
		ConfigVariables.wildCarrotMaxAmount = config.getInt("Maximum carrot amount", "Carrots from grass blocks", 1, 0, 64, Descriptions.configWildCarrotMaxAmount);
		
		ConfigVariables.wildPotatoChance = config.getFloat("Potato chance", "Potatoes from grass blocks", 0.01f, 0.0f, 1.0f, Descriptions.configWildPotatoChance);
		ConfigVariables.wildPotatoMaxAmount = config.getInt("Maximum potato amount", "Potatoes from grass blocks", 1, 0, 64, Descriptions.configWildPotatoMaxAmount);
		
		ConfigVariables.wildToxicPotatoChance = config.getFloat("Poisonous potato chance", "Potatoes from grass blocks", 0.01f, 0.0f, 1.0f, Descriptions.configWildToxicPotatoChance);
		ConfigVariables.wildToxicPotatoMaxAmount = config.getInt("Maximum poisonous potato amount", "Potatoes from grass blocks", 1, 0, 64, Descriptions.configWildToxicPotatoMaxAmount);
		
		ConfigVariables.wildBeetRootChance = config.getFloat("Beet root chance", "Beet roots from grass blocks", 0.01f, 0.0f, 1.0f, Descriptions.configWildBeetRootChance);
		ConfigVariables.wildBeetRootMaxAmount = config.getInt("Maximum beet root amount", "Beet roots from grass blocks", 1, 0, 64, Descriptions.configWildBeetRootMaxAmount);
		
		// bones
		ConfigVariables.buriedBonesChance = config.getFloat("Buried bones chance", "Buried Bones", 0.005f, 0.0f, 1.0f, Descriptions.configBuriedBonesChance);
		ConfigVariables.buriedBonesMaxBoneAmount = config.getInt("Maximum buried bones amount", "Buried Bones", 9, 0, 64, Descriptions.configBuriedBonesMaxBoneAmount);
		ConfigVariables.buriedBonesMaxSkullAmount = config.getInt("Maximum buried skull amount", "Buried Bones", 1, 0, 64, Descriptions.configBuriedBonesMaxSkullAmount);
		
		// dirt
		ConfigVariables.deepRootChance = config.getFloat("Deep root chance", "Sticks from dirt blocks", 0.07f, 0.0f, 1.0f, Descriptions.configDeepRootChance);
		ConfigVariables.deepRootMaxAmount = config.getInt("Maximum deep root amount", "Sticks from dirt blocks", 1, 0, 64, Descriptions.configDeepRootMaxAmount);
		
		ConfigVariables.buriedFlintChance = config.getFloat("Buried Flint Chance", "Buried Flint", 0.04f, 0.0f, 1.0f, Descriptions.configBuriedFlintChance);
		ConfigVariables.buriedFlintMaxAmount = config.getInt("Maximum buried flint amount", "Buried Flint", 1, 0, 64, Descriptions.configBuriedFlintMaxAmount);
		
		// stone
		ConfigVariables.goldChance = config.getFloat("Gold chance", "Gold in stone", 0.005f, 0.0f, 1.0f, Descriptions.configGoldChance);
		ConfigVariables.goldMaxAmount = config.getInt("Maximum gold amount", "Gold in stone", 1, 0, 64, Descriptions.configGoldMaxAmount);
		
		ConfigVariables.flintChipChance = config.getFloat("Flint chip chance", "Flint chips", 0.05f, 0.0f, 1.0f, Descriptions.configFlintChipChance);
		ConfigVariables.flintChipMaxAmount = config.getInt("Maximum flint chip amount", "Flint chips", 1, 0, 64, Descriptions.configFlintChipMaxAmount);
		
		// coal ore
		ConfigVariables.coalDiamondChance = config.getFloat("Coal diamond chance", "Coal gems", 0.001f, 0.0f, 1.0f, Descriptions.configCoalDiamondChance);
		ConfigVariables.coalDiamondMaxAmount = config.getInt("Maximum coal diamond amount", "Coal gems", 1, 0, 64, Descriptions.configCoalDiamondMaxAmount);
		
		ConfigVariables.coalEmeraldChance = config.getFloat("Coal emerald chance", "Coal gems", 0.001f, 0.0f, 1.0f, Descriptions.configCoalEmeraldChance);
		ConfigVariables.coalEmeraldMaxAmount = config.getInt("Maximum coal emerald amount", "Coal gems", 1, 0, 64, Descriptions.configCoalEmeraldMaxAmount);
		
		// nether quartz
		ConfigVariables.netherGoldChance = config.getFloat("Nether gold chance", "Nether gold", 1.0f, 0.0f, 1.0f, Descriptions.configNetherGoldChance);
		ConfigVariables.netherGoldMaxAmount = config.getInt("Maximum nether gold amount", "Nether gold", 9, 0, 64, Descriptions.configNetherGoldMaxAmount);
		
		// seeds from grass
		ConfigVariables.pumpkinSeeds = config.getBoolean("Pumpkin seeds from grass", "Pumpkin seeds", true, Descriptions.configPumpkinSeeds);
		ConfigVariables.melonSeeds = config.getBoolean("Melon seeds from grass", "Melon seeds", true, Descriptions.configMelonSeeds);
		ConfigVariables.beetrootSeeds = config.getBoolean("Beetroot seeds from grass", "Beetroot seeds", true, Descriptions.configBeetrootSeeds);

		// Developer
		ConfigVariables.developerMode = config.getBoolean("Developer Mode", "development", false, Descriptions.configDeveloperMode);

		// Mod Integration
		ConfigVariables.jeiVanillaInt = config.getBoolean("JEI Integration", "Mod Integration", false, Descriptions.configJeiVanillaInt);

		// World Generation
		ConfigVariables.enableSticks = config.getBoolean("Sticks generation", "World Generation", true, Descriptions.configEnableSticks);
		ConfigVariables.enableRocks = config.getBoolean("Rocks generation", "World Generation", true, Descriptions.configEnableRocks);

		// Save config
		config.save();

		// Initialize Items
		ModItems.init();
		ModItems.register();

		// Initialize Blocks
		ModBlocks.init();
		ModBlocks.register();

		// Initialize Entities
		ModEntities.init();

		// Let's Do This
		proxy.init();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new PotatoPlanter());
		MinecraftForge.EVENT_BUS.register(new BlockForageHandler());
		MinecraftForge.EVENT_BUS.register(new SpawnHandler());
		RecipeHandler.Shapless();
		SeedLoader.seed();
		GameRegistry.registerFuelHandler(new FuelHandler());
		GameRegistry.registerWorldGenerator(new FCMasterWorldGenerator(), 10);
	}
}
