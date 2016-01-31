package de.canitzp.hosenlab2.renderer;

import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.items.ItemPassport;
import de.canitzp.hosenlab2.items.ItemRegistry;
import de.canitzp.hosenlab2.models.ModelPassport;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class PassportItemRenderer implements IItemRenderer {

    public static ModelPassport model;
    public String name;
    private static ItemPassport item = ItemRegistry.hosePassport;
    private ResourceLocation location;

    public PassportItemRenderer(String name){
        model = new ModelPassport();
        this.name = name;
        this.location = new ResourceLocation(Hosenlab2.MODID, "textures/passports/" + name + "Passport.png");
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type != ItemRenderType.ENTITY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    public static void reg(ItemPassport item){
        PassportItemRenderer.item = item;
    }


    @Override
    public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
        if(stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();
        switch (type){
            case INVENTORY:
                GL11.glPushMatrix();
                if(stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = 120;
                    GL11.glTranslatef(0.28F, -0.8F, 0F);
                }
                if(!stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = (float) Math.PI;
                    GL11.glTranslatef(0.28F, -0.35F, 0F);
                }
                Minecraft.getMinecraft().renderEngine.bindTexture(location);
                GL11.glScalef(0.085F, 0.085F, 0.085F);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(135, 0, 1, 0);
                GL11.glRotatef(25, 1, 0, 0);
                PassportItemRenderer.item.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED:
                GL11.glPushMatrix();
                if(stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = 120;
                    GL11.glTranslatef(1F, 0.3F, 0.8F);
                }
                if(!stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = (float) Math.PI;
                    GL11.glTranslatef(1F, 0.3F, 0.8F);
                }
                Minecraft.getMinecraft().renderEngine.bindTexture(location);
                GL11.glScalef(0.085F, 0.085F, 0.085F);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(135, 0, 1, 0);
                GL11.glRotatef(25, 1, 0, 0);
                PassportItemRenderer.item.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                if(stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = 120;
                    GL11.glTranslatef(-0F, 0.5F, 0.0F);
                }
                if(!stack.stackTagCompound.getBoolean("isOpen")){
                    PassportItemRenderer.item.model.top.rotateAngleX = (float) Math.PI;
                    GL11.glTranslatef(0F, 0.0F, 0.0F);
                }
                Minecraft.getMinecraft().renderEngine.bindTexture(location);
                GL11.glScalef(0.085F, 0.085F, 0.085F);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(-135, 0, 1, 0);
                GL11.glRotatef(25, 1, 0, 0);
                GL11.glTranslatef(10F, 0, 0);
                GL11.glRotatef(20, 0, 1, 0);
                GL11.glRotatef(-15, 0, 0, 1);
                GL11.glRotatef(15, 1, 0, 0);
                PassportItemRenderer.item.model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;

        }
    }
}
