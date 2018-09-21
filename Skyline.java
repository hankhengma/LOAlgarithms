import java.util.*;
import java.lang.*;

public class Skyline {
    private static class Building implements Comparable<Building> {
        int xCor;
        int height;
        boolean isStart;
        Building(int xCor, int height, boolean isStart) {
            this.xCor = xCor;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Building b) {
            if (this.xCor != b.xCor) {
                return this.xCor - b.xCor;
            } else {
                // is xCor is same
                // for start point, the higher one should be picked first;
                // for end point, the lower one should be picked first;
                return (this.isStart ? -this.height : this.height) - (b.isStart ? -b.height : b.height);
            }

        }
    }

    public static void main(String[] args) {
        Skyline sol = new Skyline();
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> res1 = sol.getSkyline(buildings1);
        sol.printList(res1);
        System.out.println();
        int[][] buildings2 = {{1,2,1},{2,3,2}};
        List<int[]> res2 = sol.getSkyline(buildings2);
        sol.printList(res2);
        System.out.println();
        int[][] buildings3 = {{1,2,1},{1,3,3}};
        List<int[]> res3 = sol.getSkyline(buildings3);
        sol.printList(res3);
        System.out.println();
        int[][] buildings4 = {{2,3,1},{1,3,3}};
        List<int[]> res4 = sol.getSkyline(buildings4);
        sol.printList(res4);
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }

        Building[] buildingMap = convertToBuilding(buildings);
        Arrays.sort(buildingMap);
        PriorityQueue<Integer> max = new PriorityQueue<>(buildings.length * 2, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1 > int2 ? -1 : int1 == int2 ? 0 : 1;
            }
        });
        int preMax = 0;
        max.offer(0);
        getSkylineHelper(buildingMap, preMax, max, res);
        return res;
    }

    private void getSkylineHelper(Building[] buildingMap, int preMax, PriorityQueue<Integer> max, List<int[]> res) {


        for (Building buildingPoint : buildingMap) {
            if (buildingPoint.isStart) {
                max.offer(buildingPoint.height);
                if (buildingPoint.height > preMax) {
                    res.add(new int[]{buildingPoint.xCor, buildingPoint.height});
                    preMax = Math.max(preMax, buildingPoint.height);
                }
            } else {
                preMax = max.peek();
                max.remove(buildingPoint.height);
                if (preMax != max.peek()) {
                    res.add(new int[]{buildingPoint.xCor, max.peek()});
                    preMax = Math.min(preMax, max.peek());
                }
            }
        }
    }

    private Building[] convertToBuilding(int[][] buildings) {
        final int START_INDEX = 0;
        final int END_INDEX = 1;
        final int HEIGHT_INDEX = 2;

        Building[] buildingMap = new Building[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            buildingMap[index] = new Building(building[START_INDEX], building[HEIGHT_INDEX], true);
            buildingMap[index + 1] = new Building(building[END_INDEX], building[HEIGHT_INDEX], false);
            index += 2;
        }
        return buildingMap;
    }

    private void printList(List<int[]> list) {
        for (int[] l : list) {
            System.out.print(Arrays.toString(l));
        }
    }
}