package com.cursedcauldron.unvotedandshelved.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

//<>

public class CopperGolemEntity extends GolemEntity implements IAnimatable, IAnimationTickable {
    AnimationFactory factory = new AnimationFactory(this);

    public CopperGolemEntity(EntityType<? extends GolemEntity> entityType, World level) {
        super(entityType, level);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("coppergolem.animation.walk", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("coppergolem.animation.idle", true));
        }
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<CopperGolemEntity>(this, "controller", 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public static DefaultAttributeContainer.Builder createGolemAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2600000238418579D);
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BLOCK_COPPER_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.5F, 1.25F);
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_COPPER_HIT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_COPPER_BREAK;
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 0.2600000238418579D));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(1, new LookAroundGoal(this));
        super.initGoals();
    }

    @Override
    public int tickTimer() {
        return age;
    }
}