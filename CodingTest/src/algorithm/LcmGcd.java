package algorithm;

public class LcmGcd {
	
	/*
	 * 최소 공배수(유클리드 호제법)
	 */
	public static void main(String[] args) {
		int[] numbers = {21, 5, 3};
		int result = numbers[0];
		for(int i=1; i<numbers.length; i++) {
			result = lcm(result, numbers[i]);
		}
		
	}
	
	/*
	 * 최소 공배수
	 */
	public static int lcm(int a, int b) {
		return Math.abs(a*b) / gcd(a, b);
	}
	
	
	/*
	 * 최대 공약수
	 */
	public static int gcd(int a, int b) {
		while(b!= 0) {
			int tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
}

