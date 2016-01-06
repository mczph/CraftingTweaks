package net.blay09.mods.craftingtweaks.addon;

import net.blay09.mods.craftingtweaks.api.CraftingTweaksAPI;
import net.blay09.mods.craftingtweaks.api.DefaultProvider;
import net.blay09.mods.craftingtweaks.api.TweakProvider;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class VanillaTweakProviderImpl implements TweakProvider {

    private final DefaultProvider defaultProvider = CraftingTweaksAPI.createDefaultProvider();

    @Override
    public boolean load() {
        return true;
    }

    @Override
    public boolean requiresServerSide() {
        return false;
    }

    @Override
    public int getCraftingGridStart(int id) {
        return 1;
    }

    @Override
    public int getCraftingGridSize(int id) {
        return 9;
    }

    @Override
    public boolean transferIntoGrid(EntityPlayer entityPlayer, Container container, int id, Slot sourceSlot) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        return defaultProvider.transferIntoGrid(entityPlayer, container, workbench.craftMatrix, sourceSlot);
    }

    @Override
    public ItemStack putIntoGrid(EntityPlayer entityPlayer, Container container, int id, ItemStack itemStack, int index) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        return defaultProvider.putIntoGrid(entityPlayer, container, workbench.craftMatrix, itemStack, index);
    }

    @Override
    public IInventory getCraftMatrix(EntityPlayer entityPlayer, Container container, int id) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        return workbench.craftMatrix;
    }

    @Override
    public void clearGrid(EntityPlayer entityPlayer, Container container, int id) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        defaultProvider.clearGrid(entityPlayer, container, workbench.craftMatrix);
    }

    @Override
    public void rotateGrid(EntityPlayer entityPlayer, Container container, int id) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        defaultProvider.rotateGrid(entityPlayer, container, workbench.craftMatrix);
    }

    @Override
    public void balanceGrid(EntityPlayer entityPlayer, Container container, int id) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        defaultProvider.balanceGrid(entityPlayer, container, workbench.craftMatrix);
    }

    @Override
    public boolean canTransferFrom(EntityPlayer entityPlayer, Container container, int id, Slot slot) {
        return defaultProvider.canTransferFrom(entityPlayer, container, id, slot);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initGui(GuiContainer guiContainer, List<GuiButton> buttonList) {
        final int paddingTop = 17;
        buttonList.add(CraftingTweaksAPI.createRotateButton(0, guiContainer.guiLeft + 10, guiContainer.guiTop + paddingTop));
        buttonList.add(CraftingTweaksAPI.createBalanceButton(0, guiContainer.guiLeft + 10, guiContainer.guiTop + paddingTop + 18));
        buttonList.add(CraftingTweaksAPI.createClearButton(0, guiContainer.guiLeft + 10, guiContainer.guiTop + paddingTop + 36));
    }

    @Override
    public String getModId() {
        return "minecraft";
    }
}
