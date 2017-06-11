package com.theishiopian.foragecraft.world.generation;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

//Based on sky_01's MC forums tutorial: 
//http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2666351-1-8-x-and-1-9-structure-generation-tutorial

public class FCMasterWorldGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		switch (world.provider.getDimension())
		{
			case -1:
				generateNether(world, random, blockX, blockZ);
			break;
			case 0:
				generateOverworld(world, random, blockX, blockZ);
			break;
			case 1:
				generateEnd(world, random, blockX, blockZ);
			break;
		}

	}

	private void generateNether(World world, Random rand, int blockX, int blockZ)
	{

	}

	private void generateOverworld(World world, Random rand, int blockX, int blockZ)
	{


		WorldGenerator rocky = new RockGenerator();

		int MIN = 32;
		int MAX = 1024;
		int rockRange = MIN + rand.nextInt(MAX - MIN);

		for (int i = 0; i < rockRange; i++)
		{
			int randX = blockX + rand.nextInt(16);
			int randY = rand.nextInt(255);
			int randZ = blockZ + rand.nextInt(16);
			
			rocky.generate(world, rand, new BlockPos(randX, randY, randZ));
		}

	}

	private void generateEnd(World world, Random rand, int blockX, int blockZ)
	{

	}

}
