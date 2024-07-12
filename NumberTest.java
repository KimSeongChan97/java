class NumberTest {	
	public static void main(String[] args){
		System.out.println(25 + 3);
		System.out.println("25" + "3"); //문자열의 더하기는 결합의 의미
		System.out.println("25 + 3");
		System.out.println("25 + 3 = " + 25 + 3);
		System.out.println("25 + 3 = " + (25 + 3));
		System.out.println();
		System.out.println("26 + 3 = " + (26 + 3));
		System.out.println("26 - 3 = " + (26 - 3));
		System.out.println("26 * 3 = " + (26 * 3));
		System.out.println("26 / 3 = " + (26 / 3));
		System.out.println("26 / 3 = " + String.format("%4.2f", (26. / 3))); //소수 이하 2째자리
		System.out.println("26 / 3 = " + String.format("%.2f", (26. / 3)));
	}
}