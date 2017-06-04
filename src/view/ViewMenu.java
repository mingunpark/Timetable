package view;

import java.util.List;

public class ViewMenu {
	
	ControlInput control=new ControlInput();
	
	public int printMain(){
		
		int menu;
		
		System.out.println("=================Ÿ�����̺�=================");
		System.out.println("1. ���� ��� ����");
		System.out.println("2. ���� �߰�");
		System.out.println("3. ���� ����");
		System.out.println("4. ���ɰ����߰�");
		System.out.println("5. ���ɰ������");
		System.out.println("6. �ð�ǥ���");
		System.out.println("7. ���ɰ������");
		System.out.println("8. ���� ����");
		System.out.println("9. ����");
		
		menu=control.chooseMain();
		
		return menu;
	}
	
	public void printTimeTable(String[][] timetable){
		
		System.out.println("����\t\t������\t\t\tȭ����\t\t\t������\t\t\t�����\t\t\t�ݿ���");
		for(int i=0;i<20;i++){

			System.out.print(i+"����"+timetable[i][0]+"\t");

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
