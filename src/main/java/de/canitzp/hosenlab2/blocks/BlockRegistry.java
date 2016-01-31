package de.canitzp.hosenlab2.blocks;

public class BlockRegistry {

    public static BlockOre oreCopper, oreTin, oreBauxite, oreLead, oreSilver, oreNickel;
    public static PassportChecker passportChecker;
    public static BlockSupplyCrate crateMK1, crateMK2, crateMK3;

    public static void preInit(){
        oreCopper = new BlockOre("oreCopper", 1);
        oreTin = new BlockOre("oreTin", 1);
        oreBauxite = new BlockOre("oreBauxite", 2);
        oreLead = new BlockOre("oreLead", 2);
        oreSilver = new BlockOre("oreSilver", 2);
        oreNickel = new BlockOre("oreNickel", 2);
        passportChecker = new PassportChecker();
        crateMK1 = new BlockSupplyCrate(BlockSupplyCrate.CrateTier.WOOD);
        crateMK2 = new BlockSupplyCrate(BlockSupplyCrate.CrateTier.IRON);
        crateMK3 = new BlockSupplyCrate(BlockSupplyCrate.CrateTier.DIAMOND);
    }

}
