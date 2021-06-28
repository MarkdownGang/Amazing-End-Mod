package net.fabricmc.example;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
   public static final FoodComponent FLUORESCENT_APPLE = (new FoodComponent.Builder()).hunger(4).saturationModifier((float) 0.3).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.GLOWING,400,0), 1F).statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,400,0), 1F).build();
}
