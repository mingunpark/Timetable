package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Subject;
import view.ControlInput;
import view.ViewMenu;

public class ControlSubject {
	

	CheckError chkError=new CheckError();
	ControlInput inputCon = new ControlInput();
	ViewMenu view=new ViewMenu();
	Scanner sc=new Scanner(System.in);
	
	
	public void printAll(List<Subject> subList){
		
		System.out.println("NO\t개설학과전공\t학수번호\t분반\t교과목명\t\t이수구분\t학점/이론/실습\t학년\t주관학과\t\t교수명\t요일 및 강의시간\t강의실\t강의언어");	
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Subject sub : subList){


			if(sub.getTitle().length()>5){
				System.out.println(sub.getIndex()+"\t"+sub.getMajor()+"\t"+sub.getSubNum()+"\t"+sub.getDivClass()+"\t"+sub.getTitle()+"\t"+sub.getType()+"\t"+sub.getScore()+"\t"+sub.getGrade()
								+"\t"+sub.getManageDept()+"\t"+sub.getProfessor()+"\t"+sub.getClassTime()+"\t"+sub.getClassRoom()+"\t"+sub.getLanguage());
			}else{
				System.out.println(sub.getIndex()+"\t"+sub.getMajor()+"\t"+sub.getSubNum()+"\t"+sub.getDivClass()+"\t"+sub.getTitle()+"\t\t"+sub.getType()+"\t"+sub.getScore()+"\t"+sub.getGrade()
								+"\t"+sub.getManageDept()+"\t"+sub.getProfessor()+"\t"+sub.getClassTime()+"\t"+sub.getClassRoom()+"\t"+sub.getLanguage());
			}

		}
		
		System.out.println("계속 진행하시려면 Enter키를 눌러주세요");
		pause();
		
	}
	
	public void addSubject(List<Subject> subList,List<Subject> mySub){
		
		
		Subject subject=new Subject();
		
		String major=inputCon.inputMajor(subList);
		String subNum=inputCon.inputSubNum(subList);
		String divClass=inputCon.inputDivClass(subList);
		
		if(chkError.checkOverlap(mySub,major, subNum)){
			for(Subject sub : subList){
				
				if(sub.getSubNum().compareTo(subNum)==0 && sub.getDivClass().compareTo(divClass)==0&& sub.getMajor().compareTo(major)==0){
					subject=sub;
					System.out.println("수강 신청 과목에 추가 되었습니다.");
				}
			}
			mySub.add(subject);
		}else
			System.out.println("중복 된 수강신청 입니다.");
		printAll(mySub);
		
	}
	
	public void deleteSubject(List<Subject> subList,List<Subject> mySub){
		
		printAll(mySub);
		
		int index=inputCon.chooseIndex(mySub);
		
		mySub.remove(mySub.get(index-1));
	
		printAll(mySub);
		
	}
	
	
	public void makeTimetable(List<Subject> mySub){
		
		String classTime=null;
		int[] chkDay=new int[6];
		String[][] timeTable=new String[20][6];
		String[] overlapClass=new String[5];
		int fillOverlap=0;
		
		timeTable[0][0]="09:00-09:30";
		timeTable[1][0]="09:30-10:00";
		timeTable[2][0]="10:00-10:30";
		timeTable[3][0]="10:30-11:00";
		timeTable[4][0]="11:00-11:30";
		timeTable[5][0]="11:30-12:00";
		timeTable[6][0]="12:00-12:30";
		timeTable[7][0]="12:30-13:00";
		timeTable[8][0]="13:00-13:30";
		timeTable[9][0]="13:30-14:00";
		timeTable[10][0]="14:00-14:30";
		timeTable[11][0]="14:30-15:00";
		timeTable[12][0]="15:00-15:30";
		timeTable[13][0]="15:30-16:00";
		timeTable[14][0]="16:00-16:30";
		timeTable[15][0]="16:30-17:00";
		timeTable[16][0]="17:00-17:30";
		timeTable[17][0]="17:30-18:00";
		timeTable[18][0]="18:00-18:30";
		timeTable[19][0]="18:30-19:00";
		
		for(Subject sub : mySub){
			classTime = sub.getClassTime();
			
			if(classTime.contains("월")){
				chkDay[1]=1;
				classTime=classTime.replace("월","");
			}
			if(classTime.contains("화")){
				chkDay[2]=1;
				classTime=classTime.replace("화","");
			}
			if(classTime.contains("수")){
				chkDay[3]=1;
				classTime=classTime.replace("수","");
			}
			if(classTime.contains("목")){
				chkDay[4]=1;
				classTime=classTime.replace("목","");
			}
			if(classTime.contains("금")){
				chkDay[5]=1;
				classTime=classTime.replace("금","");
			}

			String[] time=classTime.split("-");
			String[] startTime=time[0].split(":");
			String[] endTime=time[1].split(":");
			int startHour=Integer.parseInt(startTime[0]);
			int startMinute=Integer.parseInt(startTime[1]);
			int endHour=Integer.parseInt(endTime[0]);
			int endMinute=Integer.parseInt(endTime[1]);
			
			int calcClass=0;
			int calcPeriod=0;
			
			calcClass=(startHour-9)*2+startMinute/30;
			
			calcPeriod=(endHour-startHour)*2+(endMinute-startMinute)/30;
			
			String temp=sub.getTitle();

			
			for(int i=calcClass;i<calcClass+calcPeriod;i++){
				
				for(int j=1;j<6;j++){
					if(chkDay[j]==1){
						if(timeTable[i][j]!=null){
							
							if(fillOverlap==0){
								overlapClass[fillOverlap]=sub.getTitle();
								fillOverlap++;
							}else{
								if(sub.getTitle().compareTo(overlapClass[fillOverlap-1])==0)
									continue;
								else
									overlapClass[fillOverlap]=sub.getTitle();
							}
								
							
						}else
							timeTable[i][j]=sub.getTitle();
						chkDay[i]=0;
					}
				}
			}
	
		}//for each
		
		view.printTimeTable(timeTable);
		
		for(int i=0;i<5;i++){
			if(overlapClass[i]!=null)
				System.out.println(overlapClass[i]+" 과목의 수강 시간이 다른 과목과 겹칩니다.");
		}
		
	}
	
	
	static void pause() {
		// TODO Auto-generated method stub
		
		try{
			System.in.read();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
