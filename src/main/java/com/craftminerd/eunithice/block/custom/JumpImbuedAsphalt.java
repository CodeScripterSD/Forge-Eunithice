package com.craftminerd.eunithice.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class JumpImbuedAsphalt extends Block {

    public JumpImbuedAsphalt(Properties properties) {
        super(properties);
        // TODO Auto-generated constructor stub
    }

    @Override
    public float getJumpFactor() {
        return 2f;
    }

    public void stepOn(@NotNull Level world, @NotNull BlockPos p_154574_, @NotNull BlockState p_154575_, Entity entity) {


        if (!entity.isSteppingCarefully()) this.bounceUp(entity);
        super.stepOn(world, p_154574_, p_154575_, entity);
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (((Math.abs(vec3.x) > 0.25D) || (Math.abs(vec3.z) > 0.25D)) && !(vec3.y < 0.0D)) {

            double bounceFactor = 0;
            float fairSpeedMultFactor = 1.2F;

            if (Math.abs(vec3.x) > Math.abs(vec3.z)) { bounceFactor = fairSpeedMultFactor * Math.abs(vec3.x); }
            else if (Math.abs(vec3.x) < Math.abs(vec3.z)) { bounceFactor = fairSpeedMultFactor * Math.abs(vec3.z); }

            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setDeltaMovement(vec3.x, bounceFactor * d0, vec3.z);
        }

    }

}
