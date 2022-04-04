package com.craftminerd.eunithice.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;

public class HoneyImbuedAsphalt extends Block {

    public HoneyImbuedAsphalt(Properties properties) {
        super(properties);
    }

    public void stepOn(@NotNull Level world, @NotNull BlockPos p_154574_, @NotNull BlockState p_154575_, Entity entity) {


        if (!entity.isSteppingCarefully()) this.slowDown(entity);
        super.stepOn(world, p_154574_, p_154575_, entity);
    }

    private void slowDown(Entity entity) {
        double slowDownFactor = 0.6D;
        Vec3 vec3 = entity.getDeltaMovement();
        if (abs(vec3.x) > 0.10D || abs(vec3.z) > 0.10D) {
            entity.setDeltaMovement(vec3.x * slowDownFactor, vec3.y * slowDownFactor, vec3.z * slowDownFactor);
        }
    }

}
