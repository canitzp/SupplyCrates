package de.canitzp.hosenlab2;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import de.canitzp.hosenlab2.gen.OreGeneration;
import de.canitzp.hosenlab2.gen.WorldDecorationEvent;
import de.canitzp.hosenlab2.items.ItemRegistry;
import de.canitzp.hosenlab2.proxy.Common;
import de.canitzp.hosenlab2.tileEntities.PassportChecker;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateDiamond;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateIron;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateWood;
import de.canitzp.hosenlab2.util.ServerTickEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tubeTransportSystem.item.ItemStation;

@Mod(modid = Hosenlab2.MODID, name = Hosenlab2.NAME, version = Hosenlab2.VERSION)
public class Hosenlab2 {
    @SidedProxy(clientSide = "de.canitzp.hosenlab2.proxy.Client", serverSide = "de.canitzp.hosenlab2.proxy.Common")
    public static Common proxy;

    public static final String MODID = "hosenlab2";
    public static final String NAME = "Hosenlab 2";
    public static final String VERSION = "@VERSION@";
    public static Logger logger = LogManager.getLogger(NAME);
    public static CreativeTabs tabHosenlab2;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        tabHosenlab2 = (new CreativeTabs(CreativeTabs.getNextID(), "tabHosenlab2") {
            @Override
            public Item getTabIconItem() {
                return ItemRegistry.hosePassport;
            }
        });
        BlockRegistry.preInit();
        ItemRegistry.preInit();
        GameRegistry.registerTileEntity(PassportChecker.class, "passportChecker");
        GameRegistry.registerTileEntity(TileEntitySupplyCrateWood.class, "supplyCrateWood");
        GameRegistry.registerTileEntity(TileEntitySupplyCrateIron.class, "supplyCrateIron");
        GameRegistry.registerTileEntity(TileEntitySupplyCrateDiamond.class, "supplyCrateDiamond");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.renderItems();
        OreGeneration.init();
        RecipeRegistry.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }

}
