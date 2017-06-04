package controller;

import java.util.ArrayList;
import java.util.List;

import models.Subject;

public class CheckError {
	
	
	
	public String checkMain(String mode){
		
		do{
			try{
				if(Integer.parseInt(mode)>=1 && Integer.parseInt(mode)<=9){
					return mode;
				}else
					throw new Exception();
				
			}catch(Exception e){
				
				System.out.println("잘 못 입력하셨습니다.");
			}
		}while(true);
		
		
		
	}
	
	public String checkInsert(String mode){
		
		do{
			try{
				if(Integer.parseInt(mode)>=1 && Integer.parseInt(mode)<=2){
					return mode;
				}else
					throw new Exception();
				
			}catch(Exception e){
				
				System.out.println("잘 못 입력하셨습니다.");
			}
		}while(true);
		
		
		
	}
	
	public String checkIndex(List<Subject> interestedSub, String mode){
		
		do{
			try{
				if(Integer.parseInt(mode)>=1 && Integer.parseInt(mode)<=interestedSub.size()){
					return mode;
				}else
					throw new Exception();
				
			}catch(Exception e){
				
				System.out.println("잘 못 입력하셨습니다.");
			}
		}while(true);
		
		
		
	}
	
	public boolean checkMajor(List<Subject> subList,String major)
	{

		int flag=0;
		
		
		try{
			if(major!=null){
				
				for(Subject sub : subList){
					if(sub.getMajor().compareTo(major)==0){
						
						flag=1;
					}
				}
			}
			
			if(flag==1){
				return true;
			}else
				throw new Exception();
				
		}catch(Exception e){
			System.out.println("해당 전공이 존재 하지 않습니다");
			return false;
		}
		
	}
	
	public boolean checkSubNum(List<Subject> subList,String major,String subnum)
	{

		int chkNum=0;
		try{
			if(subnum!=null){
				
				for(Subject sub : subList){
					if(sub.getMajor().compareTo(major)==0 && sub.getSubNum().compareTo(subnum)==0){
						chkNum=1;
					}
				}
			}
			
			if(chkNum==1){
				return true;
			}else
				throw new Exception();
				
		}catch(Exception e){
			System.out.println("해당 학수번호가 존재 하지않습니다.");
			return false;
		}
		
	}
	
	public boolean checkDivClass(List<Subject> subList,String subnum,String divClass)
	{

		int chkClass=0;
		try{
			if(divClass!=null){
				
				for(Subject sub : subList){
					if(sub.getSubNum().compareTo(subnum)==0 && sub.getDivClass().compareTo(divClass)==0){
						chkClass=1;
					}
				}
			}
			
			if(chkClass==1){
				return true;
			}else
				throw new Exception();
				
		}catch(Exception e){
			System.out.println("해당 분반이 존재 하지 않습니다");
			return false;
		}
		
	}
	
	
	
	public boolean checkOverlap(List<Subject> already,String major,String subNum){
		int checkBit=0;
	

		for(Subject sub : already){
			if(sub.getSubNum().compareTo(subNum)==0&& sub.getMajor().compareTo(major)==0)
				checkBit++;
		}
		
		if(checkBit>0){
			return false;
		}else
			return true;
	
	}
	

}
