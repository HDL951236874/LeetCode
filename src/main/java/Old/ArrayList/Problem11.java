package Old.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        int tallest = 0;
        for(int i =0;i<height.length;i++){
            if(height[i]>tallest&&max<height[i]*(height.length-1-i)){
                tallest = height[i];
                for(int j=i;j<height.length;j++){
                    int v = (j-i)*Math.min(height[i],height[j]);
                    if (v>max){
                        max = v;
                    }
                }
            }
        }
        return max;
    }
    public int maxArea2(int[] height){
        if (height.length==2){
            return Math.min(height[0],height[1]);
        }
        int res1 = maxArea2(Arrays.copyOfRange(height,0,height.length-1));
        int res2 = maxArea2(Arrays.copyOfRange(height,1,height.length));
        int res3 = Math.min(height[0],height[height.length-1])*(height.length-1);
        return res3>(res1>res2? res1:res2)? res3:res1>res2? res1:res2;
    }

    public int maxArea3(int[] height){
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            int v = Math.min(height[l],height[r])*(r-l);
            if (v>max){
                max = v;
            }
            if(height[l]<height[r]){
                int set = height[l];
                while(height[l]<=set&&l<r){
                    l++;
                }
            }else if(height[l]>height[r]){
                int set = height[r];
                while (height[r]<=set&&l<r){
                    r--;
                }
            }else {
                int set = height[l];
                while(height[l]<=set&&l<r){
                    l++;
                }
                while(height[r]<=set&&l<r){
                    r--;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Problem11 p = new Problem11();
        System.out.println(p.maxArea3(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
