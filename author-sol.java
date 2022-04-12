import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			//count the number of 5s and 0s
			int c0 = 0, c5 = 0;
			for(int i = 0; i < n; i++) {
				if(a[i] == 0) {
					c0++;
				}
				else {
					c5++;
				}
			}
			//calculate the number of 5s to be used
			c5 = (int) Math.floor(c5 / 9) * 9;
			if(c0 == 0) {
				//this implies that no number can be made divisible by 10
				out.println(-1);
			}
			else if(c5 == 0) {
				//this implies that the only number that can be made divisible by 90 is 0
				out.println(0);
			}
			else {
				//group the number of 5s and 9s into groups of 9
				//there are going to be floor(c5 / 9) groups that are filled with 5s
				//we can use all of the 5s from all of the groups to get a multiple of 9
				for(int i = 0; i < c5; i++) {
					out.print(5);
				}
				for(int i = 0; i < c0; i++) {
					out.print(0);
				}
				out.println();
			}
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
