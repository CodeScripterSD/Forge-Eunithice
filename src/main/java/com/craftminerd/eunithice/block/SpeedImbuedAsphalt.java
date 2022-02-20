package com.craftminerd.eunithice.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SpeedImbuedAsphalt extends Block {

    public SpeedImbuedAsphalt(Properties properties) {
        super(properties);
        // TODO Auto-generated constructor stub
    }

    public void stepOn(Level world, BlockPos p_154574_, BlockState p_154575_, Entity entity) {


        if (!entity.isSteppingCarefully()) this.speedUp(entity, 1.9D);
        super.stepOn(world, p_154574_, p_154575_, entity);
    }

    private void speedUp(Entity entity, double speedUpFactor) {
        Vec3 vec3 = entity.getDeltaMovement();

        entity.setDeltaMovement(vec3.x * speedUpFactor, vec3.y, vec3.z * speedUpFactor);
    }

}
