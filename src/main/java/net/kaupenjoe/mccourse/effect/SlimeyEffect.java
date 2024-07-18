package net.kaupenjoe.mccourse.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// MIT License!
public class SlimeyEffect extends StatusEffect {
    protected SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity.horizontalCollision) {
            Vec3d intialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(intialVec.x, 0.2D, intialVec.z);
            entity.setVelocity(climbVec.multiply(0.97D));
            return true;
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
