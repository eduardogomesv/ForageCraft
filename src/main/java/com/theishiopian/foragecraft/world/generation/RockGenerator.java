package com.theishiopian.foragecraft.world.generation;

import java.util.Random;

import com.theishiopian.foragecraft.ConfigVariables;
import com.theishiopian.foragecraft.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;

//Based on sky_01's MC forums tutorial: 
//http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2666351-1-8-x-and-1-9-structure-generation-tutorial

public class RockGenerator extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		Random rng = new Random();
		
		Block rock = null;
		
		switch(rng.nextInt(2))
		{
			case 0: rock = ModBlocks.rock_normal;
			break;
			case 1: rock = ModBlocks.rock_flat;
			break;
			default: rock = ModBlocks.rock_normal;
		}

		BlockPos rp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());

		Block toReplace = worldIn.getBlockState(rp).getBlock();

		if((toReplace == Blocks.AIR ||toReplace == Blocks.TALLGRASS) && worldIn.getBlockState(rp.down()).isSideSolid(worldIn, pos, EnumFacing.UP))
		{
			//TODO: add sandstone rocks or something similar
			if(!BiomeDictionary.hasType(worldIn.getBiome(pos), BiomeDictionary.Type.SANDY))
				worldIn.setBlockState(rp, rock.getDefaultState(), 2);
			else if(!worldIn.canSeeSky(pos))
				worldIn.setBlockState(rp, rock.getDefaultState(), 2);

			if(ConfigVariables.developerMode)
			{
				System.out.println("Generating rock at X: " + rp.getX() + " Y: " + rp.getY() + " Z: " + rp.getZ());
			}
		}

		return false;
	}

}
