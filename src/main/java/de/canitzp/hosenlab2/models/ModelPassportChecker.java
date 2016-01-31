package de.canitzp.hosenlab2.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPassportChecker extends ModelBase {

    ModelRenderer body1;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer body2;

    public ModelPassportChecker(){
        textureWidth = 64;
        textureHeight = 64;

        body1 = new ModelRenderer(this, 0, 0);
        body1.addBox(0F, 0F, 0F, 16, 10, 16);
        body1.setRotationPoint(-8F, 14F, -8F);
        body1.setTextureSize(64, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        head1 = new ModelRenderer(this, 0, 27);
        head1.addBox(0F, 0F, 0F, 16, 6, 4);
        head1.setRotationPoint(-8F, 8F, -8F);
        head1.setTextureSize(64, 64);
        head1.mirror = true;
        setRotation(head1, 0F, 0F, 0F);
        head2 = new ModelRenderer(this, 0, 38);
        head2.addBox(0F, 0F, 0F, 1, 1, 12);
        head2.setRotationPoint(7F, 13F, -4F);
        head2.setTextureSize(64, 64);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        head3 = new ModelRenderer(this, 0, 38);
        head3.addBox(0F, 0F, 0F, 1, 1, 12);
        head3.setRotationPoint(-8F, 13F, -4F);
        head3.setTextureSize(64, 64);
        head3.mirror = true;
        setRotation(head3, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 0, 52);
        body2.addBox(0F, 0F, 0F, 4, 1, 4);
        body2.setRotationPoint(-2F, 13.95F, -2F);
        body2.setTextureSize(64, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        body1.render(f5);
        head1.render(f5);
        head2.render(f5);
        head3.render(f5);
        body2.render(f5);
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
