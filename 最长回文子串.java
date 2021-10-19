class LongestPalindromicSubstring {
    public static String GetPalindromicSub(String s){
        String res = s.substring(0,1);
        int i = 0, k = 0;
        while(i<s.length()-1){

                int j = 1;
                while(j <= i && j+i<s.length()){
                    if(s.charAt(i-j) == s.charAt(i+j)){
                        j++;
                    }
                    else{
                        break;
                    }
                }
                j--;
                String substring = s.substring(i - j, i + j + 1);
                if(substring.length() > res.length()){
                    res = substring;
                }

            i++;
        }

        while(k<s.length()-1){
            int j=1;
            if(s.charAt(k) == s.charAt(k+1)){
                while(j<=k && j+k+1<s.length()){
                    if(s.charAt(k-j) == s.charAt(k+j+1)){
                        j++;
                    }
                    else{
                        break;
                    }
                }
                j--;
                String substring = s.substring(k - j, k + j + 2);
                if(substring.length() > res.length()){
                    res = substring;
                }
            }
            k++;
        }
        return res;
    }

    public static String GetMaxPalSub(String s){
        if(s.length() == 0){
            return null;
        }
        else{
            String res = "";
            int[][] dp = new int[s.length()][s.length()];
            int max = 0;
            for(int j=0; j<s.length(); j++){
                dp[j][j] = 1;
                for(int i=0; i<j; i++){
                    if((dp[i+1][j-1] == 1 && s.charAt(i)==s.charAt(j))||((j-i)==1 && s.charAt(i)==s.charAt(j))){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 0;
                    }
                    if(dp[i][j] == 1 && (j-i+1)>max){
                        max = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(GetMaxPalSub("abbcbbad"));
    }
}
