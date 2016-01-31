package de.canitzp.hosenlab2.renderer;

import de.canitzp.hosenlab2.blocks.BlockSupplyCrate;
import de.canitzp.hosenlab2.models.ModelSupplyCrate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * @author canitzp
 */
public class SupplyCrateRenderer extends TileEntitySpecialRenderer implements IItemRenderer{

    private ResourceLocation crate;

    public SupplyCrateRenderer(BlockSupplyCrate.CrateTier crate){
        this.crate = new ResourceLocation("hosenlab2:textures/models/BlockSupplyCrate" + crate.getName() + ".png");
    }

    @Override
    public void renderTileEntityAt(TileEntity p_147500_1_, double x, double y, double z, float p_147500_8_) {
        ModelSupplyCrate model = new ModelSupplyCrate();
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(0.0F, 0.0F, 0.0F);
        this.bindTexture(this.crate);
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
        ModelSupplyCrate model = new ModelSupplyCrate();
        switch (type){
            case INVENTORY:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.5F, 0.55F, 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(-0.5F, -1.27F, 0.5F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(crate);
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED:
                GL11.glPushMatrix();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.6F, -1.2F, -0.0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(crate);
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                GL11.glScalef(1.2F, 1.2F, 1.2F);
                GL11.glRotatef(180, 2F, -0F, 0.1F);
                GL11.glTranslatef(1.5F, -1.2F, -0.3F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(crate);
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
            default:
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.0F, -1.27F, 0.0F);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(crate);
                model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;
        }
    }
}
