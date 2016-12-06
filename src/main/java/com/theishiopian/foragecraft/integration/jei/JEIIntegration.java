package com.theishiopian.foragecraft.integration.jei;

import net.minecraftforge.fml.common.Loader;

public final class JEIIntegration
{
    public static boolean isLoaded()
    {
        return Loader.isModLoaded("JEI");
    }
}
