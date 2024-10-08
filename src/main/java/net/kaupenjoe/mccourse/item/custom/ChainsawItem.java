package net.kaupenjoe.mccourse.item.custom;

import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class ChainsawItem extends Item {
    public ChainsawItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if(!world.isClient()) {
            if(world.getBlockState(context.getBlockPos()).isIn(BlockTags.LOGS)) {
                world.breakBlock(context.getBlockPos(), true, context.getPlayer());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()), item ->
                        Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                context.getWorld().playSound(null, context.getBlockPos(), ModSounds.CHAINSAW_CUT, SoundCategory.BLOCKS, 1f, 1f);

                // Server Particles (Via Server, Seen by all players)
                ((ServerWorld) context.getWorld()).spawnParticles(ParticleTypes.SCULK_SOUL, context.getBlockPos().getX() + 0.5f, context.getBlockPos().getY() + 1.0f,
                        context.getBlockPos().getZ() + 0.5f, 25, 0.0, 0.05, 0.0, 0.15f);
            } else {
                context.getWorld().playSound(null, context.getBlockPos(), ModSounds.CHAINSAW_PULL, SoundCategory.BLOCKS, 1f, 1f);
            }
        }

        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mccourse.chainsaw.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.mccourse.chainsaw.tooltip.1"));
            tooltip.add(Text.translatable("tooltip.mccourse.chainsaw.tooltip.2"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
