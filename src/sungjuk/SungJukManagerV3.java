package sungjuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author 허진경
 * @since 2015.05.10
 * @version 1.0
 */
public class SungJukManagerV3 {

	/**
	 * 배열에 저장되는 데이터의 최대 수
	 */
//	static final int MAX_COUNT = 100; //최대 100명까지 저장
	
	/**
	 * 학생정보를 저장하는 배열
	 */
//	static Student[] studentList = new Student[MAX_COUNT];
//	static String[] nameList = new String[MAX_COUNT];
//	static String[] studentIdList = new String[MAX_COUNT];
//	static int[] jumsuList = new int[MAX_COUNT];
	static List<Student> studentList = new ArrayList<Student>();
	
	/**
	 * 현재 배열에 저장되어 있는 데이터의 수(학생의 수)
	 */
//	static int count = 0; //studentList.size();
	
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
		//studentList[index] ->studentList.get(index)
		System.out.print(studentList.get(index).name + "학생의 정보를 삭제하겠습니까?(Y/N) : ");
		if(scan.next().charAt(0) =='Y') {
			studentList.remove(index);
//			for(int i=index; i<count-1; i++) {
//				studentList[i] = studentList[i+1];
////				nameList[i] = nameList[i+1];
////				studentIdList[i] = studentIdList[i+1];
////				jumsuList[i] = jumsuList[i+1];
//			}
//			count--;
			index = -1;
		}else {
			System.out.println("삭제를 취소합니다.");
		}
	}

	private static void updateData() {
		//index 번째 학생 정보 수정
		//studentList[index] -> studentList.get(index)
		System.out.print("이름(" + studentList.get(index).name + ") : ");
		studentList.get(index).name = scan.next();
		System.out.print("학번(" + studentList.get(index).studentId + ") : ");
		studentList.get(index).studentId = scan.next();
		System.out.print("점수(" + studentList.get(index).jumsu + ") : ");
		studentList.get(index).jumsu = scan.nextInt();
	}

	private static void searchData() {
		System.out.println("찾을 학생의 학번을 입력하세요: ");
		String studentId = scan.next().trim();
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).studentId.equals(studentId)) {
				index = i;
				break;
			}
		}
		System.out.println("학생 찾기를 종료했습니다.");
		if(index >= 0) {
			System.out.println(studentList.get(index));
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
//		studentList[count] = student;
//		count++;
		studentList.add(student);
		System.out.println(studentList.size() + "명 데이터가 존재합니다.");
	}
	public static void printList() {
		System.out.println("==============L I S T==============");
		System.out.println("\t이름 \t학번 \t점수");
		int sum=0;
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).toString());
			sum += studentList.get(i).jumsu;
		}
		double avg=sum/(double)studentList.size();
		System.out.println("-----------------------------------");
		System.out.println("\t합계 : " + sum + "\t\t평균 : " + avg);
		System.out.println("===================================");
	}
}
//stduentList[i]  -> studentList.get(i)
//삭제시 remove(i)
//추가시 add(student)
//배열에 저장된 데이터의 수 -> size()