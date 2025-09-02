
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.greydesh.gdbuax.item.IceAxeLeftItem;
import net.greydesh.gdbuax.item.IceAxeItem;
import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GdbuaxMod.MODID);
	public static final DeferredItem<Item> ICE_AXE = REGISTRY.register("ice_axe", IceAxeItem::new);
	public static final DeferredItem<Item> ICE_AXE_LEFT = REGISTRY.register("ice_axe_left", IceAxeLeftItem::new);
	public static final DeferredItem<Item> ICE_AXE_IN = block(GdbuaxModBlocks.ICE_AXE_IN);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
