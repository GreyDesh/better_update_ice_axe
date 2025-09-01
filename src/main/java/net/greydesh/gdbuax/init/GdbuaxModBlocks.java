
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.greydesh.gdbuax.block.IceAxeInBlock;
import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, GdbuaxMod.MODID);
	public static final RegistryObject<Block> ICE_AXE_IN = REGISTRY.register("ice_axe_in", () -> new IceAxeInBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
