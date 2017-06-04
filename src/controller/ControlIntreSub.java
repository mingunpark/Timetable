package controller;

import java.util.List;

import models.Subject;
import view.ControlInput;

public class ControlIntreSub {
	
	private ControlSubject controlSub=new ControlSubject();
	private ControlInput inputCon=new ControlInput();
	private CheckError chkError=new CheckError();
	
	
	public void addInterestedSub(List<Subject> subList,List<Subject> mySub,List<Subject> interestedSub){
			
		Subject subject=new Subject();
		
		String major=inputCon.inputMajor(subList);
		String subNum=inputCon.inputSubNum(subList);
		String divClass=inputCon.inputDivClass(subList);
		int select=0;
		
		
		if(chkError.checkOverlap(mySub,major, subNum)){
			if(chkError.checkOverlap(interestedSub,major, subNum)){
				for(Subject sub : subList){
					
					if(sub.getSubNum().compareTo(subNum)==0 && sub.getDivClass().compareTo(divClass)==0&& sub.getMajor().compareTo(major)==0){
						subject=sub;
						System.out.println("���� ��û ���� �߰� �Ǿ����ϴ�.");
					}
				}
				interestedSub.add(subject);
				
			}else
				System.out.println("�ߺ� �� ���ɰ��� �Դϴ�.");
			

		}else
			System.out.println("������û ��Ͽ� �ִ� �����Դϴ�.");
		
		controlSub.printAll(interestedSub);
		select=inputCon.chooseInsert();
		
		if(select==1){
			int index=inputCon.chooseIndex(interestedSub);
			
			mySub.add(interestedSub.get(index-1));
			interestedSub.remove(interestedSub.get(index-1));	
		}
			
		
					
	}

	public void deleteInterestedSub(List<Subject> interestedSub){
		
		controlSub.printAll(interestedSub);
		
		int index=inputCon.chooseIndex(interestedSub);
		
		interestedSub.remove(interestedSub.get(index-1));
	
		controlSub.printAll(interestedSub);
	}

	

}
