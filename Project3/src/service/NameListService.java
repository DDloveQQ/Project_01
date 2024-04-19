package service;

import domain.*;

import java.util.Arrays;

import static service.Data.*;

public class NameListService {

    private Employee[] employees;

    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            // 获取通用的属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            switch (Integer.parseInt(EMPLOYEES[i][0])){
                case EMPLOYEE -> {
                    employees[i] = new Employee(id, name, age, salary);
                }
                case PROGRAMMER -> {
                    Equipment equipment = CreatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                }
                case DESIGNER -> {
                    Equipment equipment = CreatEquipment(i);
                    double bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                }
                case ARCHITECT -> {
                    Equipment equipment = CreatEquipment(i);
                    double bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                }
            }
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到指定的员工");
    }

    private Equipment CreatEquipment(int index) {
        String equ = EQUIPMENTS[index][0];
        // 提取公共部分以提高复用性
        String modelAndName = EQUIPMENTS[index][1];
        String displayAndPriceAndType = EQUIPMENTS[index][2];

        switch (Integer.parseInt(equ)) {
            case PC -> {
                return new PC(modelAndName, displayAndPriceAndType);
            }
            case NOTEBOOK -> {
                return new NoteBook(modelAndName, Double.parseDouble(displayAndPriceAndType));
            }
            case PRINTER -> {
                return new Printer(modelAndName, displayAndPriceAndType);
            }
        }
        return null;
    }

    public static void main(String[] args){
        try {
            NameListService nameListService = new NameListService();
            Employee employee =  nameListService.getEmployee(5);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
