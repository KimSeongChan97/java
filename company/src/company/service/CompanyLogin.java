package company.service;

import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

// CompanyLogin 클래스는 Company 인터페이스를 구현하며, 로그인 기능을 담당합니다.
public class CompanyLogin implements Company{

    // 사용자 입력을 받기 위한 Scanner 객체 생성
    Scanner sc = new Scanner(System.in);
    
    // Company 인터페이스 타입의 변수 선언 (현재 사용되지 않음)
    Company company = null;
    
    // 정보가 담긴 CompanyDTO 객체 생성
    CompanyDTO companyDTO = new CompanyDTO();
    
    // CompanyDAO의 싱글톤 인스턴스 가져오기
    CompanyDAO companyDAO = CompanyDAO.getInstance();
    
    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        System.out.println("[로그인]"); // 로그인 메시지 출력
        System.out.println("---------------------");
        
        // 사용자로부터 아이디와 비밀번호를 입력받음
        System.out.print("아이디 : ");
        String id = sc.next();
        System.out.print("비밀번호 : ");
        String pw = sc.next();
        System.out.println("---------------------");
        
        // 입력받은 아이디와 비밀번호로 로그인 시도
        companyDTO = companyDAO.login(id, pw);
        
        // 로그인 실패 시 (아이디 또는 비밀번호가 맞지 않는 경우)
        if(companyDTO.getId() == null || companyDTO.getPw() == null) {
            System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
        } else {
            // 로그인 성공 시
            String name = companyDTO.getName(); // 로그인한 사용자의 이름
            String rank = companyDTO.getRank(); // 로그인한 사용자의 직급
            
            System.out.println(name + "님이 로그인 하였습니다.");
            
            // 직급에 따라 다른 클래스 인스턴스를 생성하여 execute 메서드를 호출
            if(rank.equals("0")) {
                company = new Company_Admin(companyDTO); // 관리자용 클래스
            } else if(rank.equals("1")) {
                company = new Company_Emp(companyDTO); // 직원용 클래스
            }
            company.execute(); // 해당 클래스의 execute 메서드 호출
        }
    }
}
