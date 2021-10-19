package domain;

public class Students {
    private String sid;
    private String sname;
    private String sbirth;

    public Students() {
    }

    public Students(String sid, String sname, String sbirth) {
        this.sid = sid;
        this.sname = sname;
        this.sbirth = sbirth;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSbirth() {
        return sbirth;
    }

    public void setSbirth(String sbirth) {
        this.sbirth = sbirth;
    }
}
