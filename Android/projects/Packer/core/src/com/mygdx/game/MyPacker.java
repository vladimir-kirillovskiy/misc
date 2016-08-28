package com.mygdx.game;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by Vladk on 06/08/2016.
 */
public class MyPacker {

    public static void main (String[] arg) throws Exception{
        TexturePacker.process("android/assets/Player",      // input
                "android/assets/Player Finished",           // output
                "Player Animation");                                        // Name of the final sprite sheet
    }


    // to run it - Right click on MyPacker class and select "Run 'MyPacker.main()'"
}
