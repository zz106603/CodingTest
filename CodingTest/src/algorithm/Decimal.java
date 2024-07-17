package algorithm;

import java.util.Arrays;

public class Decimal {
	public static void main(String args[]) {
		int n = 100;
		
		boolean prime = isPrime(n);
		
		boolean[] prime2 = isPrime2(n);
		for(int i=2; i<=n; i++) {
			if(prime2[i]) {
				System.out.println("소수");
			}
		}
	}
	
	/*
	 * 소수 구하기
	 */
	public static boolean isPrime(int n) {
		if(n < 2) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 특정 숫자까지의 소수 모두 구하기(에느토스테네스의 체)
	 */
	public static boolean[] isPrime2(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i<=n; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=n; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		return isPrime;
		
	}
}
