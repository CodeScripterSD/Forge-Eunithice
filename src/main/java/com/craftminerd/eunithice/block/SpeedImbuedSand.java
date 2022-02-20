package com.craftminerd.eunithice.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SpeedImbuedSand extends FallingBlock {
    private final int dustColor;
    public SpeedImbuedSand(int dustColor, Properties properties) {
        super(properties);
        this.dustColor = dustColor;
    }

    public int getDustColor(BlockState p_55970_, BlockGetter p_55971_, BlockPos p_55972_) {
        return this.dustColor;
    }

//	@Override
//	public float getSpeedFactor() {
//		// TODO Auto-generated method stub
//		return 1.9f;
//	}

    public void stepOn(Level world, BlockPos p_154574_, BlockState p_154575_, Entity entity) {


        if (!entity.isSteppingCarefully()) this.speedUp(entity);
        super.stepOn(world, p_154574_, p_154575_, entity);
    }

    private void speedUp(Entity entity) {
        double speedUpFactor = 1.9D;
        Vec3 vec3 = entity.getDeltaMovement();

        entity.setDeltaMovement(vec3.x * speedUpFactor, vec3.y, vec3.z * speedUpFactor);
    }

}
