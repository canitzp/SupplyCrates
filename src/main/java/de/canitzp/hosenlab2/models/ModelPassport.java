package de.canitzp.hosenlab2.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;


public class ModelPassport extends ModelBase {

    public ModelRenderer bottom;
    public ModelRenderer top;

    public ModelPassport(){
        textureWidth = 1024;
        textureHeight = 1024;

        bottom = new ModelRenderer(this, 0, 0);
        bottom.addBox(0F, 0F, 0F, 259, 1, 162);
        bottom.setRotationPoint(-163F, 0F, 0F);
        bottom.setTextureSize(1024, 1024);
        bottom.mirror = true;
        setRotation(bottom, 0F, 0F, 0F);
        top = new ModelRenderer(this, 0, 165);
        top.addBox(0F, 0F, 0F, 259, 1, 162);
        top.setRotationPoint(-163F, 0F, 162F);
        top.setTextureSize(1024, 1024);
        top.mirror = true;
        setRotation(top, 3.141593F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        bottom.render(f5);
        top.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }

    public void open(){
        this.top.rotateAngleX = 120;
    }

    public void close(){
        this.top.rotateAngleX = (float)Math.PI;
    }

}
