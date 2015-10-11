package sungjuk;

import java.util.Scanner;

public class SungJukManager {

	static final int MAX_COUNT = 100; //최대 100명까지 저장
	static String[] nameList = new String[MAX_COUNT];
	static String[] studentIdList = new String[MAX_COUNT];
	static int[] jumsuList = new int[MAX_COUNT];
	static int count = 0; //현재 배열에 저장되어 있는 데이터의 수(학생의 수)
	static int index = -1; //찾은 학생의 인덱스를 저장
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

	private static void deleteData() {
		//index 번째 다음 항목부터 count 보다 작을 때까지 앞으로 하나씩 옮김
		//count--
		//index = -1 // 초기화
	}

	private static void updateData() {
		//index 번째 학생 정보 수정
		System.out.print("이름(" + nameList[index] + ") : ");
		nameList[index] = scan.next();
	}

	private static void searchData() {
		System.out.println("찾을 학생의 학번을 입력하세요: ");
		String studentId = scan.next().trim();
		for(int i=0; i<count; i++) {
			if(studentIdList[i].equals(studentId)) {
				index = i;
				break;
			}
		}
		System.out.println("학생 찾기를 종료했습니다.");
		if(index >= 0) {
			System.out.println("\t" + nameList[index] + 
					           "\t" + studentIdList[index] +
					           "\t" + jumsuList[index]);
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
		nameList[count] = scan.next();
		System.out.print("학번 : ");
		studentIdList[count] = scan.next();
		System.out.print("점수 : ");
		jumsuList[count] = scan.nextInt();
		count++;
		System.out.println(count + "명 데이터가 존재합니다.");
	}
	public static void printList() {
		System.out.println("==============L I S T==============");
		System.out.println("\t이름 \t학번 \t점수");
		int sum=0;
		for(int i=0; i<count; i++) {
			System.out.println("\t" + nameList[i] + 
							   "\t" + studentIdList[i] + 
							   "\t" + jumsuList[i]);
			sum += jumsuList[i];
		}
		double avg=sum/(double)count;
		System.out.println("-----------------------------------");
		System.out.println("\t합계 : " + sum + "\t\t평균 : " + avg);
		System.out.println("===================================");
	}
}

