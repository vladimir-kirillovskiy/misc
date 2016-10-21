package com.mygdx.game;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vladk on 2016-10-21.
 */
public class PlatformComponent implements Component {
    public Vector2 originalPosition;
    public float timePassed = 0;
}
