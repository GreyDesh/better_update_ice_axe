package net.greydesh.gdbuax.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

public class IceAxeInClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack itemPack = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount());
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount());
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			ItemStack _setstack = ItemStack.EMPTY.copy();
			_setstack.setCount(1);
			_itemHandlerModifiable.setStackInSlot(0, _setstack);
		}
		world.destroyBlock(BlockPos.containing(x, y, z), false);
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
