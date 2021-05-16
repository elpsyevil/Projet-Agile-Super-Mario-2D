package com.TETOSOFT.tilegame.sprites;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.TETOSOFT.graphics.Animation;

/**
    The Player.
*/
public class Player extends Creature 
{

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround,isJumping;
    private Animation jumpLeft,jumpRight,playerDead;
    
    // protected Animation[] playerJump;

    public Player(Animation left, Animation right, Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);

        Image imgJumpLeft = new ImageIcon("images/playerjumpLeft.png").getImage();
        Animation animLeft = new Animation();
        animLeft.addFrame(imgJumpLeft, 70);
        this.jumpLeft = animLeft;
        
        Image imgJumpRight = new ImageIcon("images/playerjumpRight.png").getImage();
        Animation animRight = new Animation();
        animRight.addFrame(imgJumpRight, 70);
        this.jumpRight = animRight;

        Image imgPlayerDead = new ImageIcon("images/playerDead.png").getImage();
        Animation animDead = new Animation();
        animDead.addFrame(imgPlayerDead, 70);
        this.playerDead = animDead;
    }


    public void collideHorizontal() {
        setVelocityX(0);
    }


    public void collideVertical() {
        // check if collided with ground
        if (getVelocityY() > 0) {
            onGround = true;
            isJumping=false;
            
        }
        setVelocityY(0);
        
        
    }


    public void setY(float y) {
        // check if falling
        if (Math.round(y) > Math.round(getY())) {
            onGround = false;
        }
        super.setY(y);
    }


    public void wakeUp() {
        // do nothing
    }


    /**
        Makes the player jump if the player is on the ground or
        if forceJump is true.
    */
    public void jump(boolean forceJump) {
        if (onGround || forceJump) {
            onGround = false;
            setVelocityY(JUMP_SPEED);
            isJumping = true;
        }

        
    }


    public float getMaxSpeed() {
        return 0.5f;
    }

    public void update(long elapsedTime) {
        // select the correct Animation
        Animation newAnim = anim;
       
        // if (getVelocityY() == 0) {
        //     isJumping=false;
        // }
        if (getVelocityX() < 0) {
            if (isJumping) newAnim = jumpLeft;
            else{
            newAnim = left;
            this.dead = false;
        }
        // System.out.println(getVelocityY());
    }
        else if (getVelocityX() > 0) {
            if (isJumping) newAnim = jumpRight;
            else{
            newAnim = right;
            this.dead = false;
        }
    }
        else {
            if (isJumping){ 
                if (newAnim == left || newAnim == jumpLeft )
                    newAnim = jumpLeft;
                else newAnim = jumpRight;
            }
            else{
                if (newAnim == left || newAnim == jumpLeft)
                    newAnim = left;
                else newAnim = right;
                this.dead = true;
        }};
        if (state == STATE_DEAD || state == STATE_DYING) {
            newAnim = playerDead;
            this.dead = true;}

        // update the Animation
        if (anim != newAnim) {
            anim = newAnim;
            anim.start();
        }
        

        else {
            anim.update(elapsedTime, this.dead);
        }

        // update to "dead" state
        stateTime += elapsedTime;
        if (state == STATE_DYING && stateTime >= DIE_TIME) {
            setState(STATE_DEAD);
        }

        
    }

}
