package view;

import java.util.List;
import java.util.Scanner;

import controller.CheckError;
import models.Subject;

public class ControlInput {
	
	
	private String mode;
	private Scanner sc=new Scanner(System.in);
	private CheckError chkError=new CheckError();
	private String subNum;
	private String major;
	
	public int chooseMain(){
				
		System.out.println("�޴��� �������ּ��� : ");
		mode=sc.next();
		

		String confirmMode=chkError.checkMain(mode);
		
				
		return Integer.parseInt(confirmMode);
	}
	

	public String inputMajor(List<Subject> subList){
		
		
		do{
			System.out.println("�����а������� �Է��ϼ��� : ");
			major=sc.nextLine();
		
		}while(!chkError.checkMajor(subList,major));	
		
		
		return major;
	}
	

	public String inputSubNum(List<Subject> subList){
	
		
		do{
			System.out.println("�м���ȣ�� �Է��ϼ��� : ");
			subNum=sc.nextLine();
		
		}while(!chkError.checkSubNum(subList,major,subNum));
		
		
		return subNum;
	}
	
	public String inputDivClass(List<Subject> subList){
		
		String divClass;
		
		do{
			System.out.println("�й��� �Է��ϼ��� : ");
			divClass=sc.nextLine();
		
		}while(!chkError.checkDivClass(subList,subNum, divClass));
		
		return divClass;
	}
	
	public int chooseInsert(){
		
				
		System.out.println("1.���ɰ��� -> ������û���      2. �״�� �д�.  ");
		String isInsert=sc.next();
		
		String confirmInsert=chkError.checkInsert(isInsert);
	
		return Integer.parseInt(confirmInsert);
	}
	
	
	public int chooseIndex(List<Subject> interestedSub){
		
		
		System.out.println("�ش� ������ ��ȣ�� �Է����ּ���.(���������� 1��)");
		String index=sc.next();
		
		String confirmIndex=chkError.checkIndex(interestedSub,index);
	
		return Integer.parseInt(confirmIndex);
	}
	
	
	
	
	
	
				

}
