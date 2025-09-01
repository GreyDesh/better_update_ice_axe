
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GdbuaxMod.MODID);
	public static final RegistryObject<SoundEvent> ICE_AXE_CLIMB = REGISTRY.register("ice_axe_climb", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("gdbuax", "ice_axe_climb")));
}
