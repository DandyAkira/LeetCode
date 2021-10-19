import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class GetRainWater {
    public static int trap(int[] height) {
        int water = 0;
        int h = 1;
        int max = 0;
        for(int i:height){
            max = Math.max(max, i);
        }
        while(h<=max){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<height.length; i++){
                if(height[i]>=h){
                    list.add(i);
                }
            }
            if(list.size()>1){
                int i = 0;
                int j = 1;
                while(j<list.size()){
                    water += (list.get(j) - list.get(i) - 1);
                    i++;
                    j++;
                }
            }
            h++;
        }
        return water;
    }
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
