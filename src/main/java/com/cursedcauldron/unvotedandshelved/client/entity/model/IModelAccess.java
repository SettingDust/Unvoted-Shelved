package com.cursedcauldron.unvotedandshelved.client.entity.model;

import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;

//<>

public interface IModelAccess {
    static void translate(ModelPart part, Vector3f vec) {
        part.x += vec.x();
        part.y += vec.y();
        part.z += vec.z();
    }

    static void rotate(ModelPart part, Vector3f vec) {
        part.xRot += vec.x();
        part.yRot += vec.y();
        part.zRot += vec.z();
    }

    static void scale(ModelPart part, Vector3f vec) {
        ((IModelAccess)(Object)part).increaseXScale(vec.x());
        ((IModelAccess)(Object)part).increaseYScale(vec.y());
        ((IModelAccess)(Object)part).increaseZScale(vec.z());
    }

    PartPose getDefaultPose();

    void setDefaultPose(PartPose pose);

    static void resetPose(ModelPart part) {
        part.loadPose(((IModelAccess)(Object)part).getDefaultPose());
    }

    float xScale();

    void setXScale(float x);

    void increaseXScale(float x);

    float yScale();

    void setYScale(float y);

    void increaseYScale(float y);

    float zScale();

    void setZScale(float z);

    void increaseZScale(float z);
}