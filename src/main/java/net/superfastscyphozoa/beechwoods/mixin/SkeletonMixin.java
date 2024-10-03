package net.superfastscyphozoa.beechwoods.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractSkeletonEntity.class)
public class SkeletonMixin {

	@WrapOperation(
			method = "initEquipment",
			at = @At(value = "FIELD", target = "Lnet/minecraft/item/Items;BOW:Lnet/minecraft/item/Item;")
	)
	private Item chooseWeapon(Operation<Item> original) {
		AbstractSkeletonEntity skelly = (AbstractSkeletonEntity) (Object) this;

		if (skelly.getRandom().nextBetween(1, 3) > 2){
			if (skelly.getRandom().nextBoolean()){
				return Items.STONE_SWORD;
			} else {
				return Items.STONE_AXE;
			}
		} else {
			return original.call();
		}
	}

}