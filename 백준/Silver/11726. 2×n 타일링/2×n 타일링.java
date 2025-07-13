import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[1001];
        s[1] = 1;
        s[2] = 2;
        
        for (int i = 3; i < 1001; i++) {
            s[i] = (s[i - 2] + s[i - 1])%10007;
        }
        System.out.println(s[n]);
    }
}