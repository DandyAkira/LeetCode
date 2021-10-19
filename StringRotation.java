public class StringRotation {
    public static boolean GetRotate(String a, String b){
        String doubela = a+a;
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        else{
            return doubela.contains(b);
        }
    }

    public static void main(String[] args) {
        System.out.println(GetRotate("abcd","cdab"));
    }
}
