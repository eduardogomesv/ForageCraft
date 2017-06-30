package com.theishiopian.foragecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RoadStone extends Block
{

	public RoadStone()
	{
		super(Material.ROCK, MapColor.GRAY);
		setUnlocalizedName("road_stone");
		setRegistryName("road_stone");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(SoundType.STONE);
	}
	
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        super.onEntityWalk(worldIn, pos, entityIn);
        
        entityIn.setVelocity(entityIn.motionX*=1.5, 0, entityIn.motionZ*=1.5);
    }
}
