package sungjuk;

import java.util.Scanner;

/**
 * 
 * @author 허진경
 * @since 2015.05.02
 * @version 1.0
 */
public class SungJukManagerV2 {

	/**
	 * 배열에 저장되는 데이터의 최대 수
	 */
	static final int MAX_COUNT = 100; //최대 100명까지 저장
	
	/**
	 * 학생정보를 저장하는 배열
	 */
	static Student[] studentList = new Student[MAX_COUNT];
//	static String[] nameList = new String[MAX_COUNT];
//	static String[] studentIdList = new String[MAX_COUNT];
//	static int[] jumsuList = new int[MAX_COUNT];
	
	/**
	 * 현재 배열에 저장되어 있는 데이터의 수(학생의 수)
	 */
	static int count = 0;
	
	/**
	 * 찾은 학생의 인덱스를 저장
	 */
	static int index = -1;
	
	/**
	 * 기본입력장치로부터 메뉴 또는 데이터를 입력받기 위한 객체
	 */
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			printMenu();
			switch(scan.next().charAt(0)) {
			case 'i':
			case 'I':
				getData(); //biz()
				break;
			case 'l':
			case 'L':
				printList();
				break;
			case 's':
			case 'S':
				searchData();
				break;
			case 'u':
			case 'U':
				updateData();
				break;
			case 'd':
			case 'D':
				deleteData();
				break;
			case 'q':
			case 'Q':
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				return;
//				System.exit(0);
			}
		}

	}

	/**
	 * 데이터 삭제
	 */
	private static void deleteData() {
		//index 번째 다음 항목부터 count 보다 작을 때까지 앞으로 하나씩 옮김
		//count--
		//index = -1 // 초기화
		System.out.print(studentList[index].name + "학생의 정보를 삭제하겠습니까?(Y/N) : ");
		if(scan.next().charAt(0) =='Y') {
			for(int i=index; i<count-1; i++) {
				studentList[i] = studentList[i+1];
//				nameList[i] = nameList[i+1];
//				studentIdList[i] = studentIdList[i+1];
//				jumsuList[i] = jumsuList[i+1];
			}
			count--;
			index = -1;
		}else {
			System.out.println("삭제를 취소합니다.");
		}
	}

	private static void updateData() {
		//index 번째 학생 정보 수정
		System.out.print("이름(" + studentList[index].name + ") : ");
		studentList[index].name = scan.next();
		System.out.print("학번(" + studentList[index].studentId + ") : ");
		studentList[index].studentId = scan.next();
		System.out.print("점수(" + studentList[index].jumsu + ") : ");
		studentList[index].jumsu = scan.nextInt();
	}

	private static void searchData() {
		System.out.println("찾을 학생의 학번을 입력하세요: ");
		String studentId = scan.next().trim();
		for(int i=0; i<count; i++) {
			if(studentList[i].studentId.equals(studentId)) {
				index = i;
				break;
			}
		}
		System.out.println("학생 찾기를 종료했습니다.");
		if(index >= 0) {
			System.out.println(studentList[index]);
		}else {
			System.out.println("검색된 학생 정보가 없습니다.");
		}
	}

	public static void printMenu() {
		System.out.println("메뉴를 선택하세요.======================");
		System.out.print("(I)nsert, (L)ist, (Q)uit, (S)earch, (U)pdate, (D)elete : ");
	}
	public static void getData() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("학번 : ");
		String studentId = scan.next();
		System.out.print("점수 : ");
		int jumsu = scan.nextInt();
		Student student = new Student(name, studentId, jumsu);
		studentList[count] = student;
		count++;
		System.out.println(count + "명 데이터가 존재합니다.");
	}
	public static void printList() {
		System.out.println("==============L I S T==============");
		System.out.println("\t이름 \t학번 \t점수");
		int sum=0;
		for(int i=0; i<count; i++) {
			System.out.println(studentList[i].toString());
			sum += studentList[i].jumsu;
		}
		double avg=sum/(double)count;
		System.out.println("-----------------------------------");
		System.out.println("\t합계 : " + sum + "\t\t평균 : " + avg);
		System.out.println("===================================");
	}
}
