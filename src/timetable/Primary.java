package timetable;

import java.util.ArrayList;
import java.util.List;

import controller.ControlIntreSub;
import controller.ControlSubject;
import controller.IOdata;
import models.Subject;
import view.ViewMenu;

public class Primary {
	
	private final String ALLPATH = "src/Sejong.xlsx";
	private final String MYPATH = "src/myTimetable.xlsx";
	
	private ViewMenu view=new ViewMenu();
	private IOdata subjectInfo = new IOdata();
	private ControlSubject controlSub=new ControlSubject();
	private ControlIntreSub controlIntSub=new ControlIntreSub();
	private List<Subject> sejongSub = subjectInfo.bringData(ALLPATH);
	
	private List<Subject> mySubject = subjectInfo.bringData(MYPATH);
	private List<Subject> interestedSubject = new ArrayList<Subject>();
	
	
	
	public void run(){
		
		int menu=0;

		
		
		while(true){
			menu=view.printMain();
			
			
			switch(menu){
			case 1:
				controlSub.printAll(sejongSub);
				break;
			case 2:
				controlSub.addSubject(sejongSub,mySubject);
				break;
			case 3:
				controlSub.deleteSubject(sejongSub, mySubject);
				break;
			case 4:
				controlIntSub.addInterestedSub(sejongSub, mySubject, interestedSubject);
				break;
			case 5:
				controlIntSub.deleteInterestedSub(interestedSubject);
				
				break;
			case 6:
				controlSub.makeTimetable(mySubject);
				break;
			case 7:
				controlSub.printAll(interestedSubject);
				break;
			case 8:
				subjectInfo.storeData(mySubject);
				break;
			case 9:
				System.exit(0);
				break;
	
			}
		}
		
	}
	
	
	public List<Subject> getSubList(){
		return sejongSub;
	}

}
