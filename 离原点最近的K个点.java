import java.util.Arrays;
import java.util.Comparator;

class CloseOriginPoints {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0] + o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,k);
    }
}
