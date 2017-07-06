package com.theishiopian.foragecraft.world.generation;

import java.util.Random;

import com.theishiopian.foragecraft.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

//Based on sky_01's MC forums tutorial: 
//http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2666351-1-8-x-and-1-9-structure-generation-tutorial

public class StickGenerator extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		Block stick = ModBlocks.stick_block;

		BlockPos sp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());

		Block toReplace = worldIn.getBlockState(sp).getBlock();

		if((toReplace == Blocks.AIR ||toReplace == Blocks.TALLGRASS) && (worldIn.getBlockState(sp.down()).isSideSolid(worldIn, pos, EnumFacing.UP)&&worldIn.getBlockState(sp.down()).getBlock()==Blocks.GRASS)&&pos.getY()>64)
		{
			worldIn.setBlockState(pos, stick.getDefaultState().withProperty(BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(rand)), 2);
			System.out.println("Generating stick at /tp "+sp.getX()+" "+sp.getY()+" "+sp.getZ());
		}

		return false;
	}

}
