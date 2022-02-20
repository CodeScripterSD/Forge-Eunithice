package com.craftminerd.eunithice.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class HoneyImbuedAsphalt extends Block {

    public HoneyImbuedAsphalt(Properties properties) {
        super(properties);
    }

    public void stepOn(Level world, BlockPos p_154574_, BlockState p_154575_, Entity entity) {


        if (!entity.isSteppingCarefully()) this.slowDown(entity, 0.6D);
        super.stepOn(world, p_154574_, p_154575_, entity);
    }

    private void slowDown(Entity entity, double slowDownFactor) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.x > 0.25D || vec3.z > 0.25D) {
            entity.setDeltaMovement(vec3.x * slowDownFactor, vec3.y * slowDownFactor, vec3.z * slowDownFactor);
        }
    }

}
