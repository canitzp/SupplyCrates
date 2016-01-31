package de.canitzp.hosenlab2.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSupplyCrate extends ModelBase{

    ModelRenderer down1;
    ModelRenderer down2;
    ModelRenderer down3;
    ModelRenderer down4;
    ModelRenderer body;
    ModelRenderer top1;
    ModelRenderer top2;
    ModelRenderer top3;
    ModelRenderer top4;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;

    public ModelSupplyCrate()
    {
        textureWidth = 64;
        textureHeight = 64;

        down1 = new ModelRenderer(this, 0, 0);
        down1.addBox(0F, 0F, 0F, 16, 1, 1);
        down1.setRotationPoint(-8F, 23F, -8F);
        down1.setTextureSize(64, 64);
        down1.mirror = true;
        setRotation(down1, 0F, 0F, 0F);
        down2 = new ModelRenderer(this, 0, 0);
        down2.addBox(0F, 0F, 0F, 16, 1, 1);
        down2.setRotationPoint(-8F, 23F, 7F);
        down2.setTextureSize(64, 64);
        down2.mirror = true;
        setRotation(down2, 0F, 0F, 0F);
        down3 = new ModelRenderer(this, 0, 3);
        down3.addBox(0F, 0F, 0F, 1, 1, 14);
        down3.setRotationPoint(7F, 23F, -7F);
        down3.setTextureSize(64, 64);
        down3.mirror = true;
        setRotation(down3, 0F, 0F, 0F);
        down4 = new ModelRenderer(this, 0, 3);
        down4.addBox(0F, 0F, 0F, 1, 1, 14);
        down4.setRotationPoint(-8F, 23F, -7F);
        down4.setTextureSize(64, 64);
        down4.mirror = true;
        setRotation(down4, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 19);
        body.addBox(0F, 0F, 0F, 15, 15, 15);
        body.setRotationPoint(-7.5F, 8.5F, -7.5F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        top1 = new ModelRenderer(this, 0, 0);
        top1.addBox(0F, 0F, 0F, 16, 1, 1);
        top1.setRotationPoint(-8F, 8F, -8F);
        top1.setTextureSize(64, 64);
        top1.mirror = true;
        setRotation(top1, 0F, 0F, 0F);
        top2 = new ModelRenderer(this, 0, 0);
        top2.addBox(0F, 0F, 0F, 16, 1, 1);
        top2.setRotationPoint(-8F, 8F, 7F);
        top2.setTextureSize(64, 64);
        top2.mirror = true;
        setRotation(top2, 0F, 0F, 0F);
        top3 = new ModelRenderer(this, 0, 3);
        top3.addBox(0F, 0F, 0F, 1, 1, 14);
        top3.setRotationPoint(-8F, 8F, -7F);
        top3.setTextureSize(64, 64);
        top3.mirror = true;
        setRotation(top3, 0F, 0F, 0F);
        top4 = new ModelRenderer(this, 0, 3);
        top4.addBox(0F, 0F, 0F, 1, 1, 14);
        top4.setRotationPoint(7F, 8F, -7F);
        top4.setTextureSize(64, 64);
        top4.mirror = true;
        setRotation(top4, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 31, 3);
        body1.addBox(0F, 0F, 0F, 1, 14, 1);
        body1.setRotationPoint(-8F, 9F, -8F);
        body1.setTextureSize(64, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 31, 3);
        body2.addBox(0F, 0F, 0F, 1, 14, 1);
        body2.setRotationPoint(7F, 9F, -8F);
        body2.setTextureSize(64, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 31, 3);
        body3.addBox(0F, 0F, 0F, 1, 14, 1);
        body3.setRotationPoint(-8F, 9F, 7F);
        body3.setTextureSize(64, 64);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 31, 3);
        body4.addBox(0F, 0F, 0F, 1, 14, 1);
        body4.setRotationPoint(7F, 9F, 7F);
        body4.setTextureSize(64, 64);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        down1.render(f5);
        down2.render(f5);
        down3.render(f5);
        down4.render(f5);
        body.render(f5);
        top1.render(f5);
        top2.render(f5);
        top3.render(f5);
        top4.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        body4.render(f5);
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


}
