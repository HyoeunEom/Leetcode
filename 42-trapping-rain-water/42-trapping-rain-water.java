class Solution {
    public int trap(int[] height) {
        int leftHeight = 0;
        int leftHeightIndex = 0;

        int[] filledHeight = new int[height.length];
        Arrays.fill(filledHeight, 0);

        for (int i = 0 ; i < height.length ; i++ ) {
            int h = height[i];
            if (h > 0) {
                if (leftHeight > 0) {
                    int waterHeight = Math.min(h, leftHeight);
                    filledHeight = fill(filledHeight, waterHeight, leftHeightIndex+1, i);
                }

                if (h >= leftHeight) {
                    leftHeight = h;
                    leftHeightIndex = i;
                }

                filledHeight[i] = h;
            }
        }

        int filledWater = 0;
        for (int i = 0 ; i < height.length ; i++ ) {
            filledWater += (filledHeight[i] - height[i]);
        }

        return filledWater;
    }

    private int[] fill(int[] filledHeight, int waterHeight, int from, int to) {
        for (int i = from; i < to ; i++ ) {
            filledHeight[i] = Math.max(filledHeight[i], waterHeight);
        }
        return filledHeight;
    }
}