package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

import static service.Status.*;

public class TeamService {
    static private int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;
    private int architectTotal = 0;
    private int designerTotal = 0;
    private int programmerTotal = 0;

    public Programmer[] getTeam() {
        Programmer[] curr_team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            curr_team[i] = team[i];
        }
        return curr_team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("团队人数已满");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该员工不是开发人员");
        }
        Programmer p = (Programmer) e;
        if (p.getStatus() == BUSY) {
            throw new TeamException("该员工已是某团队成员");
        }
        if (p.getStatus() == VOCATION) {
            throw new TeamException("该员工正在休假");
        }
        for (int i = 0; i < total; i++) {
            if (e.getId() == team[i].getId()) {
                throw new TeamException("该员工已在团队");
            }
        }
        // 注意: 一定要按架构师->设计师->程序员的顺序进行,且使用if-else
        // 因为: 因为架构师既是设计师也是程序员的子类,在使用instanceof判断时都会返回true
        if (getProgrammerType(e) == 1) {
            if (architectTotal >= 1) {
                throw new TeamException("团队中至多只能有一个架构师");
            }
            architectTotal++;
        } else if (getProgrammerType(e) == 0) {
            if (designerTotal >= 2) {
                throw new TeamException("团队中至多只能有两个设计师");
            }
            designerTotal++;
        } else {
            if (programmerTotal >= 3) {
                throw new TeamException("团队中至多只能有三个程序员");
            }
            programmerTotal++;
        }
        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(BUSY);
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getId() == memberId) {
                team[i].setStatus(FREE);
                if (getProgrammerType(team[i]) == 1) {
                    architectTotal--;
                } else if (getProgrammerType(team[i]) == 0){
                    designerTotal--;
                } else {
                    programmerTotal--;
                }
                break;
            }
        }
        if (i == total) {
            throw new TeamException("待删除员工不存在");
        }

        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }

        team[--total] = null;
    }

    public int getProgrammerType(Employee e) {
        Programmer p = (Programmer) e;
        if (p instanceof Architect) {
            return 1;
        } else if (p instanceof Designer) {
            return 0;
        } else {
            return -1;
        }
    }

}
