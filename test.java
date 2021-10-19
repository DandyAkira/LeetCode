import java.util.*;
class User{
    int value;
    ArrayList<Integer> values = new ArrayList<>();
}
public class test {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        while(top<down && left<right){
            for(int y=left; y<=right; y++){res.add(matrix[top][y]);}
            for(int x=top+1; x<=down; x++){res.add(matrix[x][right]);}
            for(int y=right-1; y>=left; y--){res.add(matrix[down][y]);}
            for(int x=down-1; x>=top+1; x--){res.add(matrix[x][left]);}
            top++;
            left++;
            right--;
            down--;
        }
        return res;
    }

    public static void main(String[] args) {
        double[] a = new double[3];
        a[1] = 1;
        System.out.println(a[1]);

    }
}