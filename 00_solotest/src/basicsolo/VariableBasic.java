package basicsolo;

public class VariableBasic {

	public static void main(String[] args) {
		/*1. int (Integer)
		크기: 32비트 (4바이트)
		범위: -2^31 (-2,147,483,648)에서 2^31-1 (2,147,483,647)
		기본값: 0
		설명: int는 정수를 저장하는 데 사용됩니다. 일반적으로 루프 카운터, 배열 인덱스, 정수 계산 등에서 많이 사용됩니다.
		*/
		int a = 100;
		int b = -200;
		int sum = a + b;  // sum은 -100
		
		/*
		2. char (Character)
		크기: 16비트 (2바이트)
		범위: 0에서 65,535 (유니코드 값)
		기본값: '\u0000' (널 문자)
		설명: char는 단일 문자를 저장하는 데 사용됩니다. Java에서 char는 유니코드 문자로 저장되므로 모든 국제 문자를 지원합니다.
		 */
		char letterA = 'A';
		char letterB = 'B';
		char symbol = '@';
		
		/*
		 3. double (Double-precision floating-point)
		크기: 64비트 (8바이트)
		범위: ±4.9e-324에서 ±1.8e308
		정밀도: 15자리까지의 소수점 정밀도
		기본값: 0.0
		설명: double은 실수를 저장하는 데 사용됩니다. 높은 정밀도를 필요로 하는 계산에서 주로 사용됩니다. 
		 */
		double pi = 3.141592653589793;
		double largeNumber = 4.5e100;
		double sum1 = pi + largeNumber;
		/*
		 4. float (Single-precision floating-point)
		크기: 32비트 (4바이트)
		범위: ±1.4e-45에서 ±3.4e38
		정밀도: 7자리까지의 소수점 정밀도
		기본값: 0.0f
		설명: float는 실수를 저장하는 데 사용됩니다. 정밀도가 더 낮고, 메모리 사용이 적으므로 메모리가 제한된 환경에서 사용됩니다.
		 */
		float pi1 = 3.1415927f;
		float smallNumber = 1.4e-45f;
		float sum11 = pi1 + smallNumber;
		/*
		 비교와 선택
		int 는 정수 계산과 관련된 작업에서 가장 일반적으로 사용됩니다. 32비트 크기이므로 대부분의 경우 충분한 범위를 제공합니다.
		char 는 단일 문자를 저장하고 유니코드 값을 사용하여 다양한 문자를 표현할 수 있습니다.
		double 은 높은 정밀도가 요구되는 실수 계산에 적합합니다. 예를 들어, 과학 계산이나 그래픽에서 자주 사용됩니다.
		float 은 메모리가 제한된 환경이나 정밀도가 크게 필요하지 않은 경우에 사용됩니다. 예를 들어, 게임 개발이나 임베디드 시스템에서 사용될 수 있습니다.  
		 */
			
	}

}