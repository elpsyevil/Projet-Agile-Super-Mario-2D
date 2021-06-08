package com.TETOSOFT.tilegame.sprites;

import com.TETOSOFT.graphics.Animation;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class playerTest  {
    private Animation anim = new Animation();
    private Player p = new Player(anim, anim, anim, anim);

    @Test
    public void testStates(){
        p.setState(p.STATE_DEAD);
        assertEquals(p.STATE_DEAD, p.getState());
    }

    @Test
    public void testPosition() {

        float pos = (float)123;
        p.setY(pos);
        assertEquals(pos,p.getY());
        p.setX(pos);
        assertEquals(pos,p.getX());
    }


    @Test
    public void testVelocity(){
        float V = (float)123;
        p.setVelocityX(V);
        assertEquals(V,p.getVelocityX());
        p.setVelocityY(V);
        assertEquals(V,p.getVelocityY());
    }


} 