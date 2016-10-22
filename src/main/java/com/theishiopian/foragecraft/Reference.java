package com.theishiopian.foragecraft;

public class Reference
{
    public static final String MODID = "foragecraft";
    public static final String NAME = "ForageCraft";
    public static final String VERSION = "1.7";

    public static final String CLIENTPROXY = "com.theishiopian.foragecraft.proxy.Client";
    public static final String SERVERPROXY = "com.theishiopian.foragecraft.proxy.Server";

    //TODO: Use unlocalized names in en_US.lang instead of registry names.

    public static enum Fascine {
        FASCINE("fascine", "fascine");

        private String unlocalizedName;
        private String registryName;

        Fascine(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}
