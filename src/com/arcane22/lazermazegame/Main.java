package com.arcane22.lazermazegame;

import com.arcane22.lazermazegame.v1.GameThread;


/**
 * @class Main
 * @author Lee Hong Jun (arcane22, hong3883@naver.com)
 * @description
 *  - Last modified 2021. 12. 07
 */

public class Main {
    public static void main(String[] args) throws Exception {

        // Get game version from program argument
        String version = args[0];

        // Separate game version
        switch(version) {
            case "v1":
                GameThread thread = new GameThread();
                thread.start();
                System.out.println("Run game version 1");
                break;

            case "v2":
                System.out.println("Run game version 2");
                break;

            default:
                throw new Exception("UndefinedVersionTypeException");
        }
    }
}
