package CoreVolumeTow.chp1_fileStream.p1;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {
    private static void writeData(Employee[] employees, PrintWriter out){
        out.println(employees.length);
        for (Employee e: employees){
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in){
        int n = in.nextInt();
        in.nextLine(); //

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }


    public static void writeEmployee(PrintWriter out, Employee e){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.println(e.getName() + "|" + e.getSalary() + "|"
            + calendar.get(Calendar.YEAR) + "|"
                + (calendar.get(Calendar.MONTH) + 1)
                + "|"
                + calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    /**
     * 从一个buffered reader中读入employee数据
     * @param in
     * @return
     */
    public static Employee readEmployee(Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);
        return new Employee(name, salary, year, month, day);

    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try {
            // save all employee records to the file employee.dat
            String dataPath = TextFileTest.class.getResource("").getPath()
                    + "employee.dat";
            PrintWriter out = new PrintWriter(dataPath);
            writeData(staff, out);
            out.close();

            // retrieve all records into a new array
            Scanner in = new Scanner(new FileReader(dataPath));
            Employee[] newStaff = readData(in);
            in.close();

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
