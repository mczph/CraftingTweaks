package net.blay09.mods.craftingtweaks.api;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public interface TweakProvider {

    String getModId();
    boolean load();

    default boolean requiresServerSide() {
        return true;
    }
    default int getCraftingGridStart(int id) {
        return 1;
    }
    default int getCraftingGridSize(int id) {
        return 9;
    }

    void clearGrid(EntityPlayer entityPlayer, Container container, int id);
    void rotateGrid(EntityPlayer entityPlayer, Container container, int id);
    void balanceGrid(EntityPlayer entityPlayer, Container container, int id);

    boolean canTransferFrom(EntityPlayer entityPlayer, Container container, int id, Slot sourceSlot);
    boolean transferIntoGrid(EntityPlayer entityPlayer, Container container, int id, Slot sourceSlot);
    ItemStack putIntoGrid(EntityPlayer entityPlayer, Container container, int id, ItemStack itemStack, int index);
    IInventory getCraftMatrix(EntityPlayer entityPlayer, Container container, int id);

    @SideOnly(Side.CLIENT)
    void initGui(GuiContainer guiContainer, List<GuiButton> buttonList);

}
