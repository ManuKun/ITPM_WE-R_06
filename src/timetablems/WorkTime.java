
package timetablems;

class WorkTime {
    private int w_id,nof_days;
    private String w_days,w_time,time_slots,st_time;

    public WorkTime(int w_id, int nof_days, String w_days, String w_time, String time_slots, String st_time) {
        this.w_id = w_id;
        this.nof_days = nof_days;
        this.w_days = w_days;
        this.w_time = w_time;
        this.time_slots = time_slots;
        this.st_time = st_time;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getNof_days() {
        return nof_days;
    }

    public void setNof_days(int nof_days) {
        this.nof_days = nof_days;
    }

    public String getW_days() {
        return w_days;
    }

    public void setW_days(String w_days) {
        this.w_days = w_days;
    }

    public String getW_time() {
        return w_time;
    }

    public void setW_time(String w_time) {
        this.w_time = w_time;
    }

    public String getTime_slots() {
        return time_slots;
    }

    public void setTime_slots(String time_slots) {
        this.time_slots = time_slots;
    }

    public String getSt_time() {
        return st_time;
    }

    public void setSt_time(String st_time) {
        this.st_time = st_time;
    }
    
    
    









}
