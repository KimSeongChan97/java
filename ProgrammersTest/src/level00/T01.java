package level00;

import java.util.Scanner;

public class T01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        // 문자열 str 입력 받기
        String str = sc.next();
        
        // 문자열을 대소문자 변환하여 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch); // 알파벳이 아닌 경우 그대로 추가
            }
        }
        
        // 결과 출력
        System.out.println(sb.toString());
        
        sc.close(); // Scanner 객체 닫기
    }
}
        
        