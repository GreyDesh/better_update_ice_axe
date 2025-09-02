package net.greydesh.gdbuax.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.greydesh.gdbuax.init.GdbuaxModItems;

public class IceAxeReplaceProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack localItem = ItemStack.EMPTY;
		if (itemstack.getItem() == GdbuaxModItems.ICE_AXE.get() && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			localItem = new ItemStack(GdbuaxModItems.ICE_AXE_LEFT.get()).copy();
			localItem.applyComponents((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getComponents());
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = localItem.copy();
				_setstack.setCount(localItem.getCount());
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else if (itemstack.getItem() == GdbuaxModItems.ICE_AXE_LEFT.get() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			localItem = new ItemStack(GdbuaxModItems.ICE_AXE.get()).copy();
			localItem.applyComponents((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getComponents());
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = localItem.copy();
				_setstack.setCount(localItem.getCount());
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
