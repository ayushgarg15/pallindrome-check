import java.util.*;
class pallindrome{

    public static boolean isp(String str, int l ,int r){
        boolean ans = true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return ans;
    }
    public static int check1(String str, int l, int r){   // right
        int ans = 0;
        for(int i=r; i>=l; i--){
            int k = l;
            int m = i;
            if(str.charAt(k)==str.charAt(m)){
                boolean myans = isp(str,k,m);
                if(myans==true){
                    ans = ((i-l)+1);
                    break;
                }
            }
        }
        return ans;
    }

    public static int check2(String str, int l, int r){   // left
        int ans = 0;
        for(int i=l; i<=r; i++){
            int k = i;
            int m = r;

            if(str.charAt(k)==str.charAt(m)){
                boolean myans = isp(str, k, m);
                if(myans==true){
                    ans = ((r-i)+1);
                    break;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String str = scn.next();
        ArrayList<Integer> idx = new ArrayList<>();
        ArrayList<Integer> val = new ArrayList<>(); 
        for(int i=0; i<n; i++){
            idx.add(i);
            int count1 = check1(str, i,n-1);
            int count2 = check2(str, 0, i);
            if(count1>count2){
                val.add(count1);
            }else if(count2>count1){
                val.add(count2);
            }else{
                val.add(count1);
            }
        }

        // System.out.println(idx);
        // System.out.println(val);


        int max = val.get(0);
        for(int i=1; i<val.size(); i++){
            int v = val.get(i);
            if(v>max){
                max = v;
            }
        }


        for(int i=max; i>=1; i--){
            int k = 0;
            while(k<val.size()){
                int v = val.get(k);
                if(v==i){
                    System.out.println(idx.get(k) + " " + i);
                }
                k++;
            }
        }



    }
}