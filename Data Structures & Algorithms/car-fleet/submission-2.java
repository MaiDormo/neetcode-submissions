class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
    
        Integer[] index = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (i, j) -> Integer.compare(position[i], position[j]));

        int[] sortedPos = new int[position.length];
        int[] sortedSpeed = new int[position.length];
        for (int i = 0; i < position.length; i++) {
            sortedPos[i] = position[index[i]];
            sortedSpeed[i] = speed[index[i]];
        }        
        
        double[] endTime = new double[sortedPos.length];
        for (int i = 0; i < sortedPos.length; i++) {
            // System.out.println("endtime: " + (target - sortedPos[i]) / (double)sortedSpeed[i]);
            endTime[i] = (target - sortedPos[i]) / (double)sortedSpeed[i];
        }

        double maxCurr = 0;
        int counter = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            // System.out.println("endtime: " + endTime[i] + ", maxCurr: " + maxCurr);
            if (endTime[i] > maxCurr) {
                counter++;
                maxCurr = endTime[i];
            }
        }

        return counter;
    }
}

/*
so, in example 2 we have target 10:
- p: 7 s: 1 -> 10 - 7 = 3, 3 / 1 -> 3.
- p: 4 s: 2 -> 10 - 4 = 6, 6 / 2 -> 3.
- p: 1 s: 2 -> 10 - 1 = 9, 9 / 2 -> 4.5.
- p: 0 s: 1 -> 10 - 0 = 10, 10 / 1 -> 10.
*/