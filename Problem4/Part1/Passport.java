class Passport {
    private int byr;
    private int iyr;
    private int eyr;
    private int hgt;
    private String hcl;
    private String ecl;
    private long pid;
    private int cid;

    Passport() {
        byr = 0;
        iyr = 0;
        eyr = 0;
        hgt = 0;
        hcl = "";
        ecl = "";
        pid = 0;
        cid = 0;
    }

    public int getByr() {
        return byr;
    }

    public void setByr(int byr) {
        this.byr = byr;
    }

    public int getIyr() {
        return iyr;
    }

    public void setIyr(int iyr) {
        this.iyr = iyr;
    }

    public int getEyr() {
        return eyr;
    }

    public void setEyr(int eyr) {
        this.eyr = eyr;
    }

    public int getHgt() {
        return hgt;
    }

    public void setHgt(int hgt) {
        this.hgt = hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Passport{" + "byr=" + byr + ", iyr=" + iyr + ", eyr=" + eyr + ", hgt=" + hgt + ", hcl='" + hcl + '\''
                + ", ecl='" + ecl + '\'' + ", pid=" + pid + ", cid=" + cid + '}';
    }

}