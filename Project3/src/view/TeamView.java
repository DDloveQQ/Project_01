package view;

import domain.Employee;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    private NameListService listSrv = new NameListService();
    private TeamService teamSrv = new TeamService();

    public void enterMainMenu() {
        boolean endFlag = false;
        char key = 0;

        while (!endFlag) {
            listAllEmployees();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            switch (key){
                case '1' -> getTeam();
                case '2' -> addMember();
                case '3' -> deleteMember();
                case '4' -> {
                    System.out.println("是否退出程序 Y/N");
                    char choice = TSUtility.readConfirmSelection();
                    if (choice == 'Y') {
                        endFlag = true;
                    }
                }
            }
        }
    }
    private void listAllEmployees() {
        System.out.println("\n-------------------------------优尚开发团队调度系统--------------------------------");
        Employee[] employees = listSrv.getAllEmployees();
        if (employees.length == 0) {
            System.out.println("单位没有雇员记录");
        } else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t\t领用设备");
        }
        for (int i = 0 ; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("--------------------------------------------------------------------------------\n");
    }
    private void getTeam() {
        if (teamSrv.getTeam().length == 0) {
            System.out.println("团队中没有成员");
            TSUtility.readReturn();
        } else {
            System.out.println("T/ID\t姓名\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t\t领用设备");
            for (int i = 0; i < teamSrv.getTeam().length; i++) {
                System.out.println(teamSrv.getTeam()[i].getDetailsForTeam());
            }
            TSUtility.readReturn();
        }
    }
    private void addMember() {
        try {
            System.out.println("请输入要添加至团队的成员ID");
            int memberId = TSUtility.readInt();
            teamSrv.addMember(listSrv.getEmployee(memberId));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
            TSUtility.readReturn();
        }
    }
    private void deleteMember() {
        try {
            System.out.println("请输入要从团队中删除的成员ID");
            int memberId = TSUtility.readInt();
            teamSrv.removeMember(memberId);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
            TSUtility.readReturn();
        }
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
