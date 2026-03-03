import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Set<Integer> set = new HashSet<>();
			boolean ok = true;

			for (int num : arr) {
				if (num < 1 || num > N) { // 범위 벗어나면 순열 아님
					ok = false;
					break;
				}
				set.add(num);
			}

			if (set.size() != N)
				ok = false; // 중복 있으면 size가 N이 아님
			
			String answer = ok ? "Yes" : "No";

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb);

		} // test
	}// main
}