
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.greydesh.gdbuax.item.IceAxeLeftItem;
import net.greydesh.gdbuax.item.IceAxeItem;
import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GdbuaxMod.MODID);
	public static final RegistryObject<Item> ICE_AXE = REGISTRY.register("ice_axe", () -> new IceAxeItem());
	public static final RegistryObject<Item> ICE_AXE_LEFT = REGISTRY.register("ice_axe_left", () -> new IceAxeLeftItem());
	public static final RegistryObject<Item> ICE_AXE_IN = block(GdbuaxModBlocks.ICE_AXE_IN);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
