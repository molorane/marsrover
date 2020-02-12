package com.game.marsrover.domain;

public class Plateau {

    /****
     * variable size is declared static to allow all calling applications to access
     * the same size
     */

    public static volatile int size;
    private static volatile Plateau instance;

    private Plateau() {
        size = 10; // Give the plateau a default size of 10
    }

    /*
     * An implementation of double checked locking of Plateau. Intention is to
     * minimize cost of synchronization and improve performance, by only locking
     * critical section of code, the code which creates instance of Plateau class.
     * By the way this is still broken, if we don't make _instance volatile,as
     * another thread can see a half initialized instance of Plateau.
     */

    public static Plateau getInstance() {
        if (instance == null) {
            synchronized (Plateau.class) {
                if (instance == null) {
                    instance = new Plateau();
                }
            }
        }
        return instance;
    }

    /*
     * This definitely thread-safe and only creates one instance of Singleton on
     * concurrent environment but unnecessarily expensive due to cost of
     * synchronization at every call.
     */

    public static synchronized Plateau getInstanceTS() {
        if (instance == null) {
            instance = new Plateau();
        }
        return instance;
    }

    public static void setPlateauSize(int newSize) {
        synchronized (Plateau.class) {
            size = newSize;
        }
    }

    public static int getPlateauSize() {
        return size;
    }
}
