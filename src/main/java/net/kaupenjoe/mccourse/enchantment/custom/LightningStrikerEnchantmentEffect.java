package net.kaupenjoe.mccourse.enchantment.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record LightningStrikerEnchantmentEffect(int level) implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
            .group(Codec.INT.fieldOf("level").forGetter(LightningStrikerEnchantmentEffect::level))
            .apply(instance, LightningStrikerEnchantmentEffect::new));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(level == 1) {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if(level == 2) {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
