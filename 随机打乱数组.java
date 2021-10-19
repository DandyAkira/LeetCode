import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class ShuffleArray {
    public int[] origin;
    public ShuffleArray(int[] nums){
        origin = nums;
    }

    public int[] shuffle(){
        int[] result = new int[origin.length];
        int[] refer = new int[origin.length];
        Map<Integer, Integer> index = new HashMap<>();
        Random r = new Random();
        for (int i = 0; i< refer.length; i++){
            refer[i] = r.nextInt();
            index.put(refer[i],i);
        }
        Arrays.sort(refer);
        for(int i = 0; i< refer.length; i++){
            result[i] = origin[index.get(refer[i])];
        }
        return result;
    }


}
