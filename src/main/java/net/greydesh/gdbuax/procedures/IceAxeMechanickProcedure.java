package net.greydesh.gdbuax.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.greydesh.gdbuax.init.GdbuaxModBlocks;

public class IceAxeMechanickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		ItemStack localItem = ItemStack.EMPTY;
		String tagsItems = "";
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double addPosX = 0;
		double addPosY = 0;
		double addPosZ = 0;
		tagsItems = "gdbuax:ice_axe";
		posX = entity.getX() + entity.getLookAngle().x * 1;
		posY = entity.getY() + 1.6 + entity.getLookAngle().y * 1;
		posZ = entity.getZ() + entity.getLookAngle().z * 1;
		addPosX = x + direction.getStepX();
		addPosY = y + direction.getStepY();
		addPosZ = z + direction.getStepZ();
		if ((world.getBlockState(BlockPos.containing(addPosX, addPosY - 1, addPosZ))).getBlock() == Blocks.AIR) {
			addPosY = addPosY - 1;
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((tagsItems).toLowerCase(java.util.Locale.ENGLISH))))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((tagsItems).toLowerCase(java.util.Locale.ENGLISH))))
				&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing(posX, posY, posZ)).canOcclude()) {
			if (entity.isShiftKeyDown() && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(addPosX, addPosY, addPosZ), GdbuaxModBlocks.ICE_AXE_IN.get().defaultBlockState(), 3);
				{
					Direction _dir = direction;
					BlockPos _pos = BlockPos.containing(addPosX, addPosY, addPosZ);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(addPosX, addPosY, addPosZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("damage", (itemstack.getDamageValue()));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				world.levelEvent(2001, BlockPos.containing(addPosX, addPosY, addPosZ), Block.getId(blockstate));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(addPosX, addPosY, addPosZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()));
					} else {
						_level.playLocalSound(addPosX, addPosY, addPosZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()), false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			} else {
				entity.setDeltaMovement(new Vec3(0, 0.5, 0));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 18);
				world.levelEvent(2001, BlockPos.containing(posX, posY, posZ), Block.getId(blockstate));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(posX, posY, posZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()));
					} else {
						_level.playLocalSound(posX, posY, posZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()), false);
					}
				}
			}
		} else {
			if (entity.isShiftKeyDown() && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(addPosX, addPosY, addPosZ), GdbuaxModBlocks.ICE_AXE_IN.get().defaultBlockState(), 3);
				{
					Direction _dir = direction;
					BlockPos _pos = BlockPos.containing(addPosX, addPosY, addPosZ);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(addPosX, addPosY, addPosZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("damage", (itemstack.getDamageValue()));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				world.levelEvent(2001, BlockPos.containing(addPosX, addPosY, addPosZ), Block.getId(blockstate));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(addPosX, addPosY, addPosZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()));
					} else {
						_level.playLocalSound(addPosX, addPosY, addPosZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gdbuax:ice_axe_climb")), SoundSource.PLAYERS, (float) 0.5, (float) (0.5 + Math.random()), false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			} else if (world.getBlockState(BlockPos.containing(posX, posY, posZ)).canOcclude()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
