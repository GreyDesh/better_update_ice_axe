
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.greydesh.gdbuax.block.IceAxeInBlock;
import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(GdbuaxMod.MODID);
	public static final DeferredBlock<Block> ICE_AXE_IN = REGISTRY.register("ice_axe_in", IceAxeInBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
