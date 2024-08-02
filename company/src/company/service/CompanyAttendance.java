package company.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

// CompanyAttendance 클래스는 Company 인터페이스를 구현하며, 출퇴근 및 휴가 관리를 담당합니다.
public class CompanyAttendance implements Company {
	
	// Company 인터페이스 타입의 변수 선언 (현재 사용되지 않음)
	Company company = null;

	// CompanyDTO 객체 선언
	CompanyDTO companyDTO = null;
	
	// 생성자: CompanyDTO 객체를 받아 초기화
	public CompanyAttendance(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	// Company 인터페이스의 execute 메서드를 구현
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
		
		// companyDTO 객체에서 이름, 직급, 아이디를 가져옴
		String name = companyDTO.getName();
		String rank = companyDTO.getRank();
		String id = companyDTO.getId();
		
		// companyDTO 객체가 null이 아닌 경우 실행
		if (companyDTO != null) {
			while (true) {
				// 사용자에게 메뉴를 출력
				System.out.println("------------------");
				System.out.println("1. 출근");
				System.out.println("2. 퇴근");
				System.out.println("3. 휴가 설정");
				System.out.println("4. 휴가 상세 정보 보기");
				System.out.println("5. 이전 메뉴");
				System.out.println("------------------");
				System.out.print("번호 입력 : ");
				int n = sc.nextInt(); // 사용자 입력 번호

				if (n == 5) break; // 이전 메뉴로 돌아감
				else if (n == 1) {
					if (companyDAO.isAlreadyCheckedIn(id)) {
						// 이미 출근한 경우 메시지 출력
						System.out.println("이미 출근하셨습니다.");
					} else {
						// 출근 체크
						companyDAO.checkin(id);
						System.out.println("출근하셨습니다.");
					}
				} else if (n == 2) {
					if (companyDAO.isAlreadyCheckedOut(id)) {
						// 이미 퇴근한 경우 메시지 출력
						System.out.println("이미 퇴근하셨습니다.");
					} else {
						// 퇴근 체크
						companyDAO.checkout(id);
					}
				} else if (n == 3) {
					// 출근하지 않은 경우
					if (!companyDAO.isAlreadyCheckedIn(id)) {
						System.out.println("출근 먼저 해주세요");                   	
					} else {
						Date today = new Date(); // 현재 날짜
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String format_Date = dateFormat.format(today); // 현재 날짜를 문자열로 포맷

						String start_day = null; 
						String end_day = null;

						// 휴가 일수를 입력받고, 휴가 시작일과 종료일을 입력받아 유효성 검사 후 설정
						while (true) {
							System.out.print("휴가 일수를 입력하세요: ");
							int days = sc.nextInt();
							sc.nextLine(); // 버퍼 비우기 (nextInt() 후에 남은 개행 문자 제거)

							while (start_day == null) { 
								System.out.print("휴가 시작 날짜(YYYY-MM-DD): ");
								String startDate = sc.nextLine();
								// 휴가 시작 날짜가 오늘 이전일 수 없음
								if (startDate.compareTo(format_Date) < 0) {
									System.out.println("휴가 시작 날짜는 오늘 이전일 수 없습니다.");
								} else {
									start_day = startDate; // 유효한 시작 날짜 설정
								}
							}

							while (end_day == null) { 
								System.out.print("휴가 종료 날짜(YYYY-MM-DD): ");
								String endDate = sc.nextLine();
								// 휴가 종료 날짜가 시작 날짜 이전일 수 없음
								if (endDate.compareTo(start_day) < 0) {
									System.out.println("휴가 종료 날짜는 휴가 시작 날짜보다 이전일 수 없습니다.");
								} else {
									end_day = endDate; // 유효한 종료 날짜 설정
								}
							}

							// 휴가 설정
							companyDAO.setVacation(id, days, start_day, end_day);
							System.out.println("휴가가 등록되었습니다");
							break;
						}
					}
				} else if (n == 4) {
					// 휴가 상세 정보 조회
					companyDAO.getVacationDetails(id);
				} else {
					System.out.println("1 ~ 5 중에서 입력하세요");
					continue;
				}
			}
		}
	}
}
