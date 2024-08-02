package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

// Company_Emp 클래스는 Company 인터페이스를 구현하며, 사원의 기능을 담당합니다.
public class Company_Emp implements Company{
    
    // 사용자 입력을 받기 위한 Scanner 객체 생성
    Scanner sc = new Scanner(System.in);
    
    // CompanyDAO의 싱글톤 인스턴스 가져오기
    CompanyDAO companyDAO = CompanyDAO.getInstance();
    
    // Company 인터페이스 타입의 변수 선언 (동적 바인딩을 위해 사용)
    Company company = null;
    
    // 현재 로그인된 사원의 정보를 담을 CompanyDTO 객체 선언
    CompanyDTO companyDTO = null;
    
    // 생성자: CompanyDTO 객체를 받아 초기화
    public Company_Emp(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
    
    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        // 무한 루프를 돌며 사용자에게 메뉴를 출력하고, 선택된 기능을 실행
        while(true) {
            System.out.println("------------------");
            System.out.println("[사원 페이지]");
            System.out.println("------------------");
            System.out.println("1. 출결체크 및 휴가설정");
            System.out.println("2. 출퇴근 기록 조회");
            System.out.println("3. 퇴사");
            System.out.println("4. 로그아웃");
            System.out.println("------------------");
            System.out.print("번호 입력 : ");
            int num = sc.nextInt(); // 사용자 입력 번호
            
            // 사용자가 4번을 선택한 경우 로그아웃 처리
            if(num == 4) {
                System.out.println("로그아웃 되었습니다");
                return;
            }
            // 사용자가 1번을 선택한 경우 출결체크 및 휴가설정 기능 실행
            else if(num == 1) {
                company = new CompanyAttendance(companyDTO);
            }
            // 사용자가 2번을 선택한 경우 출퇴근 기록 조회 기능 실행
            else if(num == 2) {
                company = new CompanyAttendanceLog(companyDTO);
            }
            // 사용자가 3번을 선택한 경우 퇴사 기능 실행
            else if(num == 3) {
                company = new CompanyLeave(companyDTO);
                company.execute(); // 퇴사 기능 실행
                companyDTO = null; // 퇴사한 사원의 정보를 null 값으로 초기화
            }
            
            // 퇴사된 경우 반복문 종료
            if(companyDTO == null) {
                return;
            }
            // 선택된 기능 실행
            company.execute();
        }
    }
}
