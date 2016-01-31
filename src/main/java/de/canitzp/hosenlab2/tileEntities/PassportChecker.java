package de.canitzp.hosenlab2.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class PassportChecker extends TileEntity {

    public String code;
    public boolean activated;
    public int tick;

    public PassportChecker() {}

    @Override
    public void writeToNBT(NBTTagCompound compound){
        if(this.code != null) compound.setString("code", this.code);
        super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        this.code = compound.getString("code");
        super.readFromNBT(compound);
    }

}