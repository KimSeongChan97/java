package fortest;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		// 삼중 for 문에서 break와 continue 사용 예제
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (k == 2) {
                        continue; // k가 2일 때 현재 반복을 건너뛰고 다음 k값으로 넘어갑니다.
                    }
                    if (i == 2 && j == 2 && k == 3) {
                        break outerLoop; // 특정 조건이 만족되면 모든 반복문을 종료합니다.
                    }
                    System.out.println("i = " + i + ", j = " + j + ", k = " + k);
                }
                System.out.println("End of inner loop");
            }
            System.out.println("End of middle loop");
        }
        System.out.println("End of outer loop");
        
        System.out.println();

        int dan, i, j;
        
        for (dan = 2; dan <= 9; dan += 3) {  // 단을 2부터 9까지 3씩 증가
        	for (i = 1; i <= 9; i++) { // 각 단의 곱하는 수를 1부터 9까지 반복
        		for (j = dan; j < dan + 3; j++) { // 각 단을 3개씩 묶어 출력
        			if ( j <= 9 ) { // 9단까지 출력하도록 조건을 설정
        				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
        			} // 9단까지 출력하도록 조건을 설정
        		}
        		System.out.println(); // 한 줄이 끝날 때마다 줄 바꿈 ( 1~9 곱하고 난 후 )
        	}
        	System.out.println(); // 각 단의 묶음이 끝날 때마다 줄 바꿈 ( 3개의 단이 끝나고 난 후 )
        }
        
        
        int aCount = 0; // 'A'의 개수를 세기 위한 변수
        int lineCount = 0; // 한 줄에 10개씩 출력하기 위한 변수

        // 난수 100개 발생 및 출력
        for (int k = 0; k < 100; k++) {
            // A(65) ~ Z(90) 사이의 난수 발생
            char randomChar = (char) ('A' + Math.random() * 26);

            // 발생한 난수를 출력
            System.out.print(randomChar + "  ");

            // 'A'의 개수 세기
            if (randomChar == 'A') {
                aCount++;
            }

            // 한 줄에 10개씩 출력
            lineCount++;
            if (lineCount % 10 == 0) {
                System.out.println();
            }
        }

        // 'A'의 개수 출력
        System.out.println("\nA의 개수 = " + aCount);
        
        
        System.out.println();
        
        
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        while (true) { // 무한 루프 시작, 사용자가 x를 0으로 입력할 때까지 반복
            // x 입력 받기
            System.out.print("x : ");
            int x = scanner.nextInt();
            
            if (x == 0) { // x가 0이면 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // y 입력 받기
            int y;
            while (true) { // y가 음수가 아닌 값이 입력될 때까지 반복
                System.out.print("y : ");
                y = scanner.nextInt();
                if (y >= 0) {
                    break;
                }
                System.out.println("y는 음수가 될 수 없습니다. 다시 입력하세요.");
            }

            // x의 y승 계산
            int result = 1;
            for (int m = 0; m < y; m++) {
                result *= x;
            }

            // 결과 출력
            System.out.println(x + "의 " + y + "승은 " + result + "\n");
        }

        scanner.close(); // Scanner 객체 닫기
        
        
        
        
        
	}

}