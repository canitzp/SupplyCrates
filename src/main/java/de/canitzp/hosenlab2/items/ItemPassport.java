package de.canitzp.hosenlab2.items;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.models.ModelPassport;
import de.canitzp.hosenlab2.renderer.PassportItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemPassport extends Item {

    private String ownerName, birthDate, sex, issuer, expireDate, code, stampDate;
    private Granted stamp;
    private Nationality nationality;
    public ModelPassport model;


    public ItemPassport(String ownerName, String birthDate, String sex, String issuer, String expireDate, String code, Nationality nationality, Granted stamp, String stampDate){
        setUnlocalizedName("hosenlab2." + ownerName + "Passport");
        setTextureName("hosenlab2:" + ownerName + "Passport");
        setCreativeTab(Hosenlab2.tabHosenlab2);
        setMaxStackSize(1);
        GameRegistry.registerItem(this, ownerName + "Passport");
        this.ownerName = ownerName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.issuer = issuer;
        this.expireDate = expireDate;
        this.code = code;
        this.stamp = stamp;
        this.stampDate = stampDate;
        this.nationality = nationality;
        model = new ModelPassport();
    }

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        onItemRightClick(p_77648_1_, p_77648_3_, p_77648_2_);
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if(!world.isRemote){
            PassportItemRenderer.reg(this);
            if(!stack.stackTagCompound.getBoolean("isOpen")){
                stack.stackTagCompound.setBoolean("isOpen", true);
            }
            else {
                stack.stackTagCompound.setBoolean("isOpen", false);
            }
        }
        return stack;
    }

    public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if(stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getSex() {
        return sex;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getCode() {
        return code;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public String getStampDate() {
        return stampDate;
    }

    public Granted getStamp() {
        return stamp;
    }

    public static enum Granted{
        GRANTED,
        DENIED,
        REASON;
    }

    public static enum Nationality{
        ARSTOTZKA,
        ANTEGIRA,
        IMPOR,
        KOLECHIA,

        CAOSFIELD
    }
}
