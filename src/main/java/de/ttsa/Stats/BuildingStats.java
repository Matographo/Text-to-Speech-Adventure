package de.ttsa.Stats;

import java.util.ArrayList;

public class BuildingStats {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    public static long gameBuildTime = 0;

    public static long gameLoadTime = 0;

    public static long roomTime = 0;
    public static long ifTime = 0;
    public static long loopTime = 0;
    public static long actionTime = 0;

    public static long totalRoomTime = 0;
    public static long totalIfTime = 0;
    public static long totalLoopTime = 0;
    public static long totalActionTime = 0;

    public static ArrayList<Long> roomBuildTime = new ArrayList<>();
    public static ArrayList<Long> ifBuildTime = new ArrayList<>();
    public static ArrayList<Long> loopBuildTime = new ArrayList<>();
    public static ArrayList<Long> actionBuildTime = new ArrayList<>();



// ---------------------------------------------- Calc ------------------------------------------------- //



    public static void calc() {
        roomTime = 0;
        ifTime = 0;
        loopTime = 0;
        actionTime = 0;

        roomBuildTime.forEach((time) -> roomTime += time);
        ifBuildTime.forEach((time) -> ifTime += time);
        loopBuildTime.forEach((time) -> loopTime += time);
        actionBuildTime.forEach((time) -> actionTime += time);

        totalRoomTime = roomTime;
        totalIfTime = ifTime;
        totalLoopTime = loopTime;
        totalActionTime = actionTime;

        if (roomBuildTime.size() > 0 && roomTime > 0)
            roomTime = roomTime / roomBuildTime.size();
        if (ifBuildTime.size() > 0 && ifTime > 0)
            ifTime = ifTime / ifBuildTime.size();
        if (loopBuildTime.size() > 0 && loopTime > 0)
            loopTime = loopTime / loopBuildTime.size();
        if (actionBuildTime.size() > 0 && actionTime > 0)
            actionTime = actionTime / actionBuildTime.size();
    }


// ---------------------------------------------- Printer ------------------------------------------------- //



    public static void print() {
        calc();

        System.out.println("Game build time: " + gameBuildTime + "ms");
        System.out.println("Game load time: " + gameLoadTime + "ms");
        System.out.println("Room build time: " + roomTime + "ms");
        System.out.println("If build time: " + ifTime + "ms");
        System.out.println("Loop build time: " + loopTime + "ms");
        System.out.println("Action build time: " + actionTime + "ms");
        System.out.println("Total room build time: " + totalRoomTime + "ms for " + roomBuildTime.size() + " rooms");
        System.out.println("Total if build time: " + totalIfTime + "ms for " + ifBuildTime.size() + " ifs");
        System.out.println("Total loop build time: " + totalLoopTime + "ms for " + loopBuildTime.size() + " loops");
        System.out.println("Total action build time: " + totalActionTime + "ms for " + actionBuildTime.size() + " actions");
    }

}
