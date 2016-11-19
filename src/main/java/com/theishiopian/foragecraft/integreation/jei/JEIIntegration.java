package com.theishiopian.foragecraft.integreation.jei;

import net.minecraftforge.fml.common.Loader;

public final class JEIIntegration
{
    public static boolean isLoaded()
    {
        return Loader.isModLoaded("JEI");
    }
}
