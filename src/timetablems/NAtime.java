/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

/**
 *
 * @author Akila
 */
public class NAtime {
    
    private int na_id;
    private String lecName,stgroup,subGroup,sessionSign,day,room,startTime,endTime;

    public NAtime(int na_id, String lecName, String stgroup, String subGroup, String sessionSign, String day, String room, String startTime, String endTime) {
        this.na_id = na_id;
        this.lecName = lecName;
        this.stgroup = stgroup;
        this.subGroup = subGroup;
        this.sessionSign = sessionSign;
        this.day = day;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNa_id() {
        return na_id;
    }

    public void setNa_id(int na_id) {
        this.na_id = na_id;
    }

    public String getLecName() {
        return lecName;
    }

    public void setLecName(String lecName) {
        this.lecName = lecName;
    }

    public String getStgroup() {
        return stgroup;
    }

    public void setStgroup(String stgroup) {
        this.stgroup = stgroup;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getSessionSign() {
        return sessionSign;
    }

    public void setSessionSign(String sessionSign) {
        this.sessionSign = sessionSign;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
    
    
    
}
