class Solution {
//     public int uniquePaths(int m, int n) {
//         int distance = m+n-2;
//         int mDup = Math.max(m,n) - 1;
//         int nDup = Math.min(m,n) - 1;

//         Long result = dupFactorial(distance, mDup, nDup);
//         return result.intValue();
//     }

//     private long dupFactorial(int f, int mDup, int nDup) {
//         long result = 1;

//         for (int i = 0; i < (f-mDup) ; i++ ) {
//             result *= (f-i);
//         }

//         for (int i = nDup; i >= 1 ; i-- ) {
//             result /= i;
//         }

//         return result;
//     }
    
    public int uniquePaths(int m, int n) {
        Map<String, Integer> countCache = new HashMap<>(Map.of("0_0", 1, "0_1", 1, "1_0", 1, "1_1", 2));
        return getUniqPathCount(m, n, 1, 1, countCache);
    }
    
    private int getUniqPathCount(int m, int n, int x, int y, Map<String, Integer> countCache) {
        int xDist = m-x;
        int yDist = n-y;

        String cacheKey = String.format("%d_%d", xDist, yDist);
        if (countCache.get(cacheKey) != null) {
            return countCache.get(cacheKey);
        }

        int rightCount = 0;
        int downCount = 0;

        if (xDist > 2) {
            rightCount = getUniqPathCount(m, n, x + 1, y, countCache);
        } else if (xDist == 2) {
            rightCount = yDist + 1;
        } else if (xDist == 1) {
            rightCount = 1;
        }

        if (yDist > 2) {
            downCount = getUniqPathCount(m, n, x, y + 1, countCache);
        } else if (yDist == 2) {
            downCount = xDist + 1;
        } else if (yDist == 1) {
            downCount = 1;
        }

        int totalCount = rightCount + downCount;
        countCache.put(cacheKey, totalCount);
        return totalCount;

    }
}