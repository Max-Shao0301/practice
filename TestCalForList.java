package testcollection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CalWageForList {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
	    list.add(new Employee(1L, LocalDateTime.of(2025,5,1,9,0),
	            LocalDateTime.of(2025,5,1,18,0), "Max", 30.0));
	    list.add(new Employee(2L, LocalDateTime.of(2025,5,2,9,0),
	            LocalDateTime.of(2025,5,2,18,50), "Max", 30.0));
	    list.add(new Employee(4L, LocalDateTime.of(2025,5,3,9,0),
	            LocalDateTime.of(2025,5,3,18,20), "Max", 30.0));
	    list.add(new Employee(5L, LocalDateTime.of(2025,5,3,9,0),
	            LocalDateTime.of(2025,5,3,18,00), "John", 30.0));
	    list.add(new Employee(6L, LocalDateTime.of(2025,5,4,9,0),
	            LocalDateTime.of(2025,5,4,18,00), "John", 30.0));
	    list.add(new Employee(7L, LocalDateTime.of(2025,5,4,9,0),
	            LocalDateTime.of(2025,5,4,18,50), "John", 30.0));
	    list.add(new Employee(8L, LocalDateTime.of(2025,5,4,9,0),
	            LocalDateTime.of(2025,5,4,18,50), "Amy", 50.0));
	    calTotalWage(list);
	}
	public static double calDayWage(Employee emp) {
		double hourRate = emp.getHourRate();
		double normalHours = 8;
		double seconds = Duration.between(emp.getCheckin(), emp.getCheckout()).toSeconds();
		double workedHours = seconds / 3600;
		double overtime = workedHours - normalHours;
		if(workedHours > normalHours) {
			return (normalHours * hourRate) + (overtime * hourRate * 1.5); 
		} else {
			return workedHours * hourRate;
		}
	}
	
	public static void calTotalWage(List<Employee> emp) {
		List<WageList> list = new ArrayList<>();
		for(Employee e : emp) {
			String name = e.getName();
			Double salary = calDayWage(e);
			boolean find = false;
			for(WageList wage : list) {
				if(wage.getName().equals(name)) {
					wage.setSalary(wage.getSalary() + salary);
					find = true;
					break;
				}
			}
			if(!find) {
				list.add(new WageList(name, salary));
			}
		}
		for(WageList wage : list) {
			System.out.printf("name: %s , salary: %.2f \n", wage.getName(), wage.getSalary());
		}
	}
	
}
class WageList {
	private String name;
	private double salary;
	
	public WageList(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}

class Employee {
	private long id;
	private LocalDateTime checkin;
	private LocalDateTime checkout;
	private String name;
	private double hourRate;
	public Employee(long id, LocalDateTime checkin, LocalDateTime checkout, String name, double hourRate) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.name = name;
		this.hourRate = hourRate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}
	public LocalDateTime getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHourRate() {
		return hourRate;
	}
	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}
}	
