class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int numSquares(int n) {
        if (n == 0) return 0;
        if (cache.get(n) != null) return cache.get(n);
        
        int minSquares = n;
        int maxElement = ((Double) Math.floor(Math.sqrt(n))).intValue();

        for (int i = maxElement ; i > 0 ; i--) {
            int diff = n - (i * i);
            int subMinSquareCount = numSquares(diff);
            int candidateCount = subMinSquareCount + 1;

            if (minSquares > candidateCount) {
                minSquares = candidateCount;
            }
        }

        cache.put(n, minSquares);
        return minSquares;
    }
}