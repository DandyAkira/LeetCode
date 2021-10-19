class MostWater {
    public static int GetMostWater(int[] a){
        int res = 0;
        int i=0, j=a.length-1;
        int water;
        while(i<j){
            if(a[i]<=a[j]){
                water = a[i]*(j-i);
                if(water>res){res = water;}
                i++;
            }
            else{
                water = a[j]*(j-i);
                if(water>res){res = water;}
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(GetMostWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
