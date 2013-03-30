package cooler.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cooler.utils.Config;
import cooler.utils.Registry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCooler extends Item {

    public ItemCooler(int par1) {
        super(par1);
        maxStackSize = 1;
        setNoRepair();
        setCreativeTab(CreativeTabs.tabMisc);
        setMaxDamage(Config.coolerDamage - 1);
    }

    @Override
    public ItemStack getContainerItemStack(
            ItemStack itemStack) {

        itemStack
                .setItemDamage(itemStack.getItemDamage() + 1);

        return itemStack;
    }

    // Makes the cooler stay on the Crafting Grid
    public boolean doesContainerItemLeaveCraftingGrid(
            ItemStack par1ItemStack) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister
                .registerIcon(Registry.texture
                        + Registry.cooler);
    }
}