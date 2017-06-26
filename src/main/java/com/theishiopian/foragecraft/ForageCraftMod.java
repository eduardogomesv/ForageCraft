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
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		//leaves
		ConfigVariables.branchChance = config.getFloat("Branch chance", "Sticks from leaves", 1.0f, 0.0f, 1.0f, "The chance of a stick droping fom leaves");
		ConfigVariables.branchMaxAmount = config.getInt("Maximum branch amount", "Sticks from leaves", 1, 0, 64, "The maximum number of sticks you can get from leaves");
		
		//grass block
		ConfigVariables.rootChance = config.getFloat("Root chance", "Sticks from grass blocks", 0.09f, 0.0f, 1.0f, "The chance of digging up a root (stick) from a grass block");
		ConfigVariables.rootMaxAmount=config.getInt("Maximum root amount", "Sticks from grass blocks", 1, 0, 64, "The maximum amount of roots (sticks) you can get from a grass block");
		
		ConfigVariables.rockChance = config.getFloat("Rock chance", "Rocks from various blocks", 0.09f, 0.0f, 1.0f, "The chance of digging up a rock");
		ConfigVariables.rockMaxAmount=config.getInt("Maximum rock amount", "Rocks from various blocks", 1, 0, 64, "The maximum amount of rocks you can get from various blocks");
		
		ConfigVariables.wildCarrotChance = config.getFloat("Carrot chance", "Carrots from grass blocks", 0.01f, 0.0f, 1.0f, "The chance of digging up a carrot from a grass block");
		ConfigVariables.wildCarrotMaxAmount = config.getInt("Maximum carrot amount", "Carrots from grass blocks", 1, 0, 64, "The maximum amount of carrots you can get from a grass block");
		
		ConfigVariables.wildPotatoChance = config.getFloat("Potato chance", "Potatoes from grass blocks", 0.01f, 0.0f, 1.0f, "The chance of digging up a potato from a grass block");
		ConfigVariables.wildPotatoMaxAmount = config.getInt("Maximum potato amount", "Potatoes from grass blocks", 1, 0, 64, "The maximum amount of potatoes you can get from a grass block");
		
		ConfigVariables.wildToxicPotatoChance = config.getFloat("Poisonous potato chance", "Potatoes from grass blocks", 0.01f, 0.0f, 1.0f, "The chance of digging up a poisonous potato from a grass block");
		ConfigVariables.wildToxicPotatoMaxAmount = config.getInt("Maximum poisonous potato amount", "Potatoes from grass blocks", 1, 0, 64, "The maximum amount of poisonous potatoes you can get from a grass block");
		
		ConfigVariables.wildBeetRootChance = config.getFloat("Beet root chance", "Beet roots from grass blocks", 0.01f, 0.0f, 1.0f, "The chance of digging up a beet root from a grass block");
		ConfigVariables.wildBeetRootMaxAmount = config.getInt("Maximum beet root amount", "Beet roots from grass blocks", 1, 0, 64, "The maximum amount of beet root you can get from a grass block");
		
		//bones
		ConfigVariables.buriedBonesChance = config.getFloat("Buried bones chance", "Buried Bones", 0.005f, 0.0f, 1.0f, "The chance of uncovering ancient bones");
		ConfigVariables.buriedBonesMaxBoneAmount = config.getInt("Maximum buried bones amount", "Buried Bones", 9, 0, 64, "The maximum amount of bones you can get from buried skeletons");
		ConfigVariables.buriedBonesMaxSkullAmount = config.getInt("Maximum buried skull amount", "Buried Bones", 1, 0, 64, "The maximum amount of skulls buried skeletons can have");
		
		//dirt
		ConfigVariables.deepRootChance = config.getFloat("Deep root chance", "Sticks from dirt blocks", 0.07f, 0.0f, 1.0f, "The chance of digging up a stick from a dirt block");
		ConfigVariables.deepRootMaxAmount = config.getInt("Maximum deep root amount", "Sticks from dirt blocks", 1, 0, 64, "The maximum amount of roots (sticks) you can get from a dirt block");
		
		ConfigVariables.buriedFlintChance = config.getFloat("Buried Flint Chance", "Buried Flint", 0.04f, 0.0f, 1.0f, "The chance of finding flint in a dirt block");
		ConfigVariables.buriedFlintMaxAmount = config.getInt("Maximum buried flint amount", "Buried Flint", 1, 0, 64, "The maximum amount of flint you can get from a dirt block");
		
		//stone
		ConfigVariables.goldChance = config.getFloat("Gold chance", "Gold in stone", 0.005f, 0.0f, 1.0f, "The chance of finding gold (in nugget form) inside a stone block");
		ConfigVariables.goldMaxAmount = config.getInt("Maximum gold amount", "Gold in stone", 1, 0, 64, "The maximum amount of gold nuggets you can find in a stone block");
		
		ConfigVariables.flintChipChance = config.getFloat("Flint chip chance", "Flint chips", 0.05f, 0.0f, 1.0f, "The chance of finding flint in a stone block");
		ConfigVariables.flintChipMaxAmount = config.getInt("Maximum flint chip amount", "Flint chips", 1, 0, 64, "The maximum amount of flint you gant get from a stone block");
		
		//coal ore
		ConfigVariables.coalDiamondChance = config.getFloat("Coal diamond chance", "Coal gems", 0.001f, 0.0f, 1.0f, "The chance of finding diamond while mining coal");
		ConfigVariables.coalDiamondMaxAmount = config.getInt("Maximum coal diamond amount", "Coal gems", 1, 0, 64, "The maximum amount of diamonds you can get from coal ore");
		
		ConfigVariables.coalEmeraldChance = config.getFloat("Coal emerald chance", "Coal gems", 0.001f, 0.0f, 1.0f, "The chance of finding emerald while mining coal");
		ConfigVariables.coalEmeraldMaxAmount = config.getInt("Maximum coal emerald amount", "Coal gems", 1, 0, 64, "The maximum amount of emeralds you can get from coal ore");
		
		//nether quartz
		ConfigVariables.netherGoldChance = config.getFloat("Nether gold chance", "Nether gold", 1.0f, 0.0f, 1.0f, "The chance of getting gold (in nugget form) from nether quartz");
		ConfigVariables.netherGoldMaxAmount = config.getInt("Maximum nether gold amount", "Nether gold", 9, 0, 64, "The maximum amount of gold nuggets you can get from nether quartz");
		
		//seeds from grass
		ConfigVariables.pumpkinSeeds = config.getBoolean("Pumpkin seeds from grass", "Pumpkin seeds", true, "This determines whether or not you can find pumpkin seeds in grass");
		ConfigVariables.melonSeeds = config.getBoolean("Melon seeds from grass", "Melon seeds", true, "This determines whether or not you can find melon seeds in grass");
		ConfigVariables.beetrootSeeds = config.getBoolean("Beetroot seeds from grass", "Beetroot seeds", true, "This determines whether or not you can find beetroot seeds in grass");
		config.save();

		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModEntities.init();
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
