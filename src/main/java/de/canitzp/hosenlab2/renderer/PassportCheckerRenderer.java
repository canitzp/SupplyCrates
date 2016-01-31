package de.canitzp.hosenlab2.renderer;

import de.canitzp.hosenlab2.models.ModelPassportChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class PassportCheckerRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float p_147500_8_) {
        ModelPassportChecker model = new ModelPassportChecker();
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(0.0F, 0.0F, 0.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("hosenlab2:textures/models/PassportChecker.png"));
        int meta = tile.getWorldObj().getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
        if(meta == 0 || meta == 5){
            GL11.glRotatef(0F, 0F, 1F, 0F);
        }
        if(meta == 1 || meta == 6){
            GL11.glRotatef(270, 0F, 1F, 0F);
        }
        if(meta == 2 || meta == 7){
            GL11.glRotatef(180, 0F, 1F, 0F);
        }
        if(meta == 3 || meta == 8){
            GL11.glRotatef(90, 0F, 1F, 0F);
        }
        model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        ModelPassportChecker model = new ModelPassportChecker();
        switch (type){
            case INVENTORY:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.5F, 0.55F, 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(-0.5F, -1.27F, 0.5F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("hosenlab2:textures/models/PassportChecker.png"));
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.6F, -1.2F, -0.0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("hosenlab2:textures/models/PassportChecker.png"));
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                GL11.glScalef(1.2F, 1.2F, 1.2F);
                GL11.glRotatef(180, 2F, -0F, 0.1F);
                GL11.glTranslatef(1.5F, -1.2F, -0.3F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("hosenlab2:textures/models/PassportChecker.png"));
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            default:
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.0F, -1.27F, 0.0F);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("hosenlab2:textures/models/PassportChecker.png"));
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
        }
    }
}
