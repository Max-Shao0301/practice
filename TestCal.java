
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestCal {
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

        calMonthWage(list);
    }

    public static double calDayWage(Employee employee) {
        double seconds = Duration.between(employee.getCheckin(), employee.getCheckout()).toSeconds();
        double workedHour = seconds / 3600;
        double hourRate = employee.getHourRate();
        double normalWorkedHour = 8;
        double overtime = workedHour - normalWorkedHour;
        double dayWage = 0;
        if(workedHour > normalWorkedHour) {
            dayWage = (normalWorkedHour * hourRate) + (overtime * hourRate * 1.5);
        } else {
            dayWage = workedHour * hourRate;
        }
        return dayWage;
    }

    public static void calMonthWage(List<Employee> list) {
        Map<String, Double> monthWageMap = new HashMap<>();
        for(Employee employee : list) {
            String name = employee.getName();
            double salary = calDayWage(employee);
            if(monthWageMap.containsKey(name)) {
                monthWageMap.put(name, salary + monthWageMap.get(name));
            } else {
                monthWageMap.put(name, salary);
            }
        }
        // 使用entrySet()遍歷
        for(Map.Entry<String, Double> entry : monthWageMap.entrySet()){
            System.out.printf("name: %s ,monthSalary: %.2f \n",  entry.getKey(), entry.getValue());
        }

        // 使用keySet()遍歷
        for(String key: monthWageMap.keySet()) {
            System.out.printf("name: %s ,monthSalary: %.2f \n", key, monthWageMap.get(key) );
        }

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
