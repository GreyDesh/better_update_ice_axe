
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greydesh.gdbuax.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.greydesh.gdbuax.GdbuaxMod;

public class GdbuaxModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, GdbuaxMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ICE_AXE_CLIMB = REGISTRY.register("ice_axe_climb", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("gdbuax", "ice_axe_climb")));
}
