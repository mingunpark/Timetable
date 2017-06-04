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
				
		System.out.println("메뉴를 선택해주세요 : ");
		mode=sc.next();
		

		String confirmMode=chkError.checkMain(mode);
		
				
		return Integer.parseInt(confirmMode);
	}
	

	public String inputMajor(List<Subject> subList){
		
		
		do{
			System.out.println("개설학과전공을 입력하세요 : ");
			major=sc.nextLine();
		
		}while(!chkError.checkMajor(subList,major));	
		
		
		return major;
	}
	

	public String inputSubNum(List<Subject> subList){
	
		
		do{
			System.out.println("학수번호를 입력하세요 : ");
			subNum=sc.nextLine();
		
		}while(!chkError.checkSubNum(subList,major,subNum));
		
		
		return subNum;
	}
	
	public String inputDivClass(List<Subject> subList){
		
		String divClass;
		
		do{
			System.out.println("분반을 입력하세요 : ");
			divClass=sc.nextLine();
		
		}while(!chkError.checkDivClass(subList,subNum, divClass));
		
		return divClass;
	}
	
	public int chooseInsert(){
		
				
		System.out.println("1.관심과목 -> 수강신청목록      2. 그대로 둔다.  ");
		String isInsert=sc.next();
		
		String confirmInsert=chkError.checkInsert(isInsert);
	
		return Integer.parseInt(confirmInsert);
	}
	
	
	public int chooseIndex(List<Subject> interestedSub){
		
		
		System.out.println("해당 과목의 번호를 입력해주세요.(위에서부터 1번)");
		String index=sc.next();
		
		String confirmIndex=chkError.checkIndex(interestedSub,index);
	
		return Integer.parseInt(confirmIndex);
	}
	
	
	
	
	
	
				

}
