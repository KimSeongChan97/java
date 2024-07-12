package fortest;

import java.util.Scanner;

public class AddGameSoloTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        int a, b; // 덧셈에 사용할 변수들
        int dab; // 정답을 저장할 변수
        int count = 0; // 맞춘 문제 수를 세는 변수
        String yn; // 게임을 계속할지 여부를 저장하는 변수
        	
        while (true) {
        	a=(int)(Math.random()*90)+10;
        	b=(int)(Math.random()*90)+10;
        	dab=a+b;
        	
        	System.out.print("["+(count+1)+"]"+a+"+"+ b +"=");
        	
        	int answer;
        	while (true) {
        		if(scanner.hasNextInt()) {
        			answer=scanner.nextInt();
        			break;
        		} else {
        			System.out.println("잘못된 입력입니다. 정수를입력해주세요");
        			scanner.next();
        		}
        	}
        	
        	// 정답 확인 및 처리
            if (answer == dab) {
                System.out.println("딩동댕!\n");
                count++;
            } else {
                System.out.println("틀렸다. 정답은 " + dab + "입니다.\n");

                // 틀린 경우 한 번 더 시도할지 물어보기
                while (true) {
                    System.out.print("한 번 더 시도할까요? (Y/N) : ");
                    yn = scanner.next().toUpperCase();
                    if (yn.equals("Y") || yn.equals("N")) {
                        break; // 유효한 입력이면 반복문 탈출
                    } else {
                        System.out.println("Y 또는 N을 입력해주세요.");
                    }
                }
                
                if (yn.equals("N")) {
                    break; // N을 입력하면 게임 종료
                }
            }

            // 5문제를 모두 맞춘 경우 게임 종료
            if (count == 5) {
                break;
            }
        }

        // 게임 결과 출력
        System.out.printf("\n당신은 총 %d 문제를 맞추어서 점수 %d점 입니다.\n", count, count * 20);

        // 게임 재시작 여부 확인
        while (true) {
            System.out.print("또 할래(Y/N) : ");
            yn = scanner.next().toUpperCase();
            if (yn.equals("Y") || yn.equals("N")) {
                break; // 유효한 입력이면 반복문 탈출
            } else {
                System.out.println("Y 또는 N을 입력해주세요.");
            }
        }

        // Y를 입력하면 게임을 재시작, N을 입력하면 프로그램을 종료
        if (yn.equals("Y")) {
            main(args); // 게임 재시작
        } else {
            System.out.println("프로그램을 종료합니다.");
        }

        scanner.close(); // Scanner 객체 닫기
    }
}

/*
[문제] 덧셈 계산 (for, while, 다중 for 사용조건)
- 10 ~ 99 사이의 난수를 2개 발생하여 합을 구하는 프로그램
- 5문제를 제공한다.
- 1문제당 점수 20점씩 처리한다.
- 틀리면 1번 더 기회를 주고, 2번 다 틀리면 답을 알려준다.
- y 또는 n 은 대소문자 상관없이 작성하시오.
- y 또는 Y 또는 n 또는 N 이 입력이 안되면 계속 반복한다.

*변수명 조건
		int a, b;
		int dab; // 답은 'dab'이다.
		int count=0;
		String yn;


[실행결과]
[1] 25 + 36 = 50
틀렸다
[1] 25 + 36 = 59
틀렸다 정답은 xx

[2] 10 + 25 = 35
딩동뎅

[5] 78 + 95 = 89
틀렸다
[5] 78 + 95 = 173
딩동뎅

당신은 총 x 문제를 맞추어서 점수 xx점 입니다.

또 할래(Y/N) : A
또 할래(Y/N) : w
또 할래(Y/N) : n (N)

프로그램을 종료합니다.






*/
