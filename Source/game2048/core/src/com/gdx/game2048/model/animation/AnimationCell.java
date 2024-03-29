package com.gdx.game2048.model.animation;

import com.gdx.game2048.model.data.Cell;

/**
 * Created by Cyber on 12/3/2017.
 */
//A cell contain information about animation.
public class AnimationCell extends Cell {
    public int[] extras;
    public AnimationType animationType;
    private long animationTime;
    private long delayTime;
    private long timeElapsed = 0;

    public AnimationCell(int x, int y, AnimationType animationType, long length, long delay, int[] extras) {
        super(x, y);
        this.animationType = animationType;
        animationTime = length;
        delayTime = delay;
        this.extras = extras;
    }

    public void setAnimation(AnimationType animationType, long length, long delay, int[] extras) {
        this.animationType = animationType;
        animationTime = length;
        delayTime = delay;
        this.extras = extras;
    }

    public AnimationType getAnimationType() {
        return animationType;
    }

    public void update(long deltatime) {
        this.timeElapsed = this.timeElapsed + deltatime;
    }

    public boolean animationDone() {
        return animationTime + delayTime < timeElapsed;
    }

    public double getPercentageDone() {
        return Math.max(0, 1.0 * (timeElapsed - delayTime) / animationTime);
    }

    public boolean isActive() {
        return (timeElapsed >= delayTime);
    }

}
