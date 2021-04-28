package com.day7;

import java.util.ArrayList;
import java.util.HashMap;


import com.day7assignments.EmployeeWageComputationProblem;

interface EmployeeWage {
	 
	 void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs);
	 ArrayList<Integer> wageCalculator(CompanyInfo cI);
	 void getByName(String name);
}

class CompanyInfo {
	//Variables
	public final String company;
	public final int wage_per_hr;
	public final int working_days_per_month;
	public final int max_working_hrs;
	private int totalWage;
	public ArrayList<Integer> dailyWage;
	
	public CompanyInfo(String company,int wage_per_hr,int working_days_per_month,int max_working_hrs) {
		this.company = company;
		this.wage_per_hr = wage_per_hr;
		this.working_days_per_month = working_days_per_month;
		this.max_working_hrs = max_working_hrs;
	}

	public int getTotalWage() {
		return totalWage;
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}

	public ArrayList<Integer> getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(ArrayList<Integer> dailyWage) {
		this.dailyWage = dailyWage;
	}
	
	@Override
	public String toString() {
		return "CompanyInfo [totalWage=" + totalWage + ", dailyWage=" + dailyWage + "]";
	}
	
}

public class EmployeeWageComputation implements EmployeeWage {
	
	public final int IS_PRESENT = 1;
	public final int IS_FULL_TIME = 1;
	
	ArrayList<CompanyInfo>  totalWageofDiffEmp = new  ArrayList<CompanyInfo>();
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	
	CompanyInfo wcc;
	CompanyInfo cI;
	
	ArrayList<Integer> al2;

	@Override
	public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs) {
		wcc = new CompanyInfo( company, wage_per_hr,  working_days_per_month,  max_working_hrs);
		totalWageofDiffEmp.add(wcc);
		
		for(int i = 0; i <= totalWageofDiffEmp.size()-1; i++) {
			cI = totalWageofDiffEmp.get(0);
			//System.out.println(cI);
			
			al2 = wageCalculator(cI);
			int totalWage = al2.get(al2.size()-1);
			wcc.setDailyWage(al2);
			wcc.setTotalWage(totalWage);
			map.put(company, totalWage);
		}
		
		
	}

	@Override
	public ArrayList<Integer> wageCalculator(CompanyInfo cI) {
		
		int checkPresence;
		int checkEmpType;
		int empDailyWage = 0;
		int dayOfMonth = 0;
		int totalWage;
		int workingHrs = 0;
		int totalWorkedHrs = 0;
		
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		
		while (dayOfMonth <= cI.working_days_per_month && totalWorkedHrs <= cI.max_working_hrs)
		{
			checkPresence = (int) (Math.random() * 10) % 2; // Presence check
			checkEmpType = (int) (Math.random() * 10) % 2; // Work Type check
			dayOfMonth++;
			switch (checkPresence)
			{
				case IS_PRESENT:
					switch (checkEmpType)
					{
						case IS_FULL_TIME:
							workingHrs = 8;
							totalWorkedHrs += workingHrs;
							break;
						default:
							workingHrs = 4;
							totalWorkedHrs += workingHrs;
					}
					break;
				default:
					totalWorkedHrs += 0;
			}

			empDailyWage = cI.wage_per_hr * workingHrs;
			al1.add(empDailyWage);

			totalWage = (cI.wage_per_hr * totalWorkedHrs);

			al1.add(totalWage);
		}
		return al1;
	}

	@Override
	public void getByName(String name) {
		
		System.out.println("total wage from get method: "+wcc.getTotalWage());
		System.out.println("total wage from map: "+map.get(name));
    }
	public static void main(String[] args)
	{
		EmployeeWage company1 = new EmployeeWageComputation();
		EmployeeWage company2 = new EmployeeWageComputation();
		EmployeeWage company3 = new EmployeeWageComputation();
		EmployeeWage company4 = new EmployeeWageComputation();

		company1.company("company1",20, 20, 100);
		company2.company("company2",25, 15, 150);
		company3.company("company3", 20, 20, 100);
		company4.company("company4", 25, 15, 150);

		company2.getByName("company2");
		company3.getByName("company3");
	}
}
