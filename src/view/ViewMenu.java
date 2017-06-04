package view;

import java.util.List;

public class ViewMenu {
	
	ControlInput control=new ControlInput();
	
	public int printMain(){
		
		int menu;
		
		System.out.println("=================타임테이블=================");
		System.out.println("1. 강의 목록 조희");
		System.out.println("2. 강의 추가");
		System.out.println("3. 강의 삭제");
		System.out.println("4. 관심과목추가");
		System.out.println("5. 관심과목삭제");
		System.out.println("6. 시간표출력");
		System.out.println("7. 관심과목출력");
		System.out.println("8. 파일 저장");
		System.out.println("9. 종료");
		
		menu=control.chooseMain();
		
		return menu;
	}
	
	public void printTimeTable(String[][] timetable){
		
		System.out.println("교시\t\t월요일\t\t\t화요일\t\t\t수요일\t\t\t목요일\t\t\t금요일");
		for(int i=0;i<20;i++){

			System.out.print(i+"교시"+timetable[i][0]+"\t");

			for(int j=1;j<6;j++){
				if(timetable[i][j]!=null)
					System.out.print("|"+timetable[i][j]+"\t\t");
				else
					System.out.print("|\t\t\t");
				
			}
			
			System.out.println("");

		}
		
		
		
	}
	
	

}
