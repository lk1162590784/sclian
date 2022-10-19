package bean;

import java.util.ArrayList;
import java.util.List;

public class Dept {
    private String id;
    private String cpname;    //部门名称
    private String cpcompany;    //部门负责人
    private String cplian;   //电话号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public String getCpcompany() {
        return cpcompany;
    }

    public void setCpcompany(String cpcompany) {
        this.cpcompany = cpcompany;
    }

    public String getCplian() {
        return cplian;
    }

    public void setCplian(String cplian) {
        this.cplian = cplian;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", cpname='" + cpname + '\'' +
                ", cpcompany='" + cpcompany + '\'' +
                ", cplian='" + cplian + '\'' +
                '}';
    }
}