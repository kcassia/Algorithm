package leetcode.Week1.Trapping_rain_water;


import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class JI_Solution {
    public int trap(int[] height) {
        int first = getHeightIndex(height);

        return right(first, height) + left(first, height);

    }

    public int right(int maxIndex, int[] height) {
        if (maxIndex == height.length)
            return 0;
        int[] temp = Arrays.copyOfRange(height, maxIndex + 1, height.length);
        int second = getHeightIndex(temp) + maxIndex + 1;
        return getRightRain(maxIndex, second, height) + right(second, height);
    }

    public int getRightRain(int left, int right, int[] height) {
        int ret = 0;
        for (int i = left + 1; i < right; i++) {
            ret += height[right] - height[i];
        }
        return ret;
    }

    public int left(int maxIndex, int[] height) {
        if (maxIndex == 0)
            return 0;
        int second = getHeightIndex(copyOfRange(height, 0, maxIndex));
        return getLeftRain(second, maxIndex, height) + left(second, height);
    }

    public int getLeftRain(int left, int right, int[] height) {
        int ret = 0;
        for (int i = left + 1; i < right; i++) {
            ret += height[left] - height[i];
        }
        return ret;
    }

    public int getHeightIndex(int[] height) {
        int index = 0;
        int h = 0;
        for (int i = 0; i < height.length; i++) {
            if (h < height[i]) {
                index = i;
                h = height[i];
            }
        }
        return index;
    }
}
