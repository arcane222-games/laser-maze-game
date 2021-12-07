package com.arcane22.lazermazegame.v2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @class GameManagerV2
 *
 * @author Lee Hong Jun (arcane22, hong3883@naver.com)
 * @version 1.0.0
 * @description
 * - Last modified: 2021. 12. 07
 */

public class GameManagerV2 {
    /**
     * @class InnerSingletonInstance
     * @description LazyHolder
     */
    private static class InnerSingletonInstance {
        private static final GameManagerV2 instance = new GameManagerV2();
    }

    /**
     * @constructor GameManagerV2
     * @description Private constructor of GameManagerV2 class
     */
    private GameManagerV2() {}


    /**
     * @method getInstance
     * @description Get singleton instance
     *
     * @return {Singleton} Instance of Singleton class
     */
    public static GameManagerV2 getInstance() {
        return InnerSingletonInstance.instance;
    }
}
