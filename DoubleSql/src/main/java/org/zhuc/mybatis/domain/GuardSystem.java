package org.zhuc.mybatis.domain;


import java.util.Date;

public class GuardSystem {
    private Integer sysNo;

    private Integer departId;

    private String employeeId;

    private String employeeName;

    private String cardNo;

    private String serial;

    private String employeeType;

    private Byte employeeSex;

    private String employeePass;

    private Date invalidate;

    private String emplyeeCode;

    private Byte isDelete;

    private String emplyeeLoginPass;

    private String cardId;

    private Integer eeSeq;

    private Integer cardType;

    private Integer cardStatus;

    private String password;

    private String salt;

    private Byte visitStatus;

    private String phone;

    public Integer getSysNo() {
        return sysNo;
    }

    public void setSysNo(Integer sysNo) {
        this.sysNo = sysNo;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType == null ? null : employeeType.trim();
    }

    public Byte getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Byte employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeePass() {
        return employeePass;
    }

    public void setEmployeePass(String employeePass) {
        this.employeePass = employeePass == null ? null : employeePass.trim();
    }

    public Date getInvalidate() {
        return invalidate;
    }

    public void setInvalidate(Date invalidate) {
        this.invalidate = invalidate;
    }

    public String getEmplyeeCode() {
        return emplyeeCode;
    }

    public void setEmplyeeCode(String emplyeeCode) {
        this.emplyeeCode = emplyeeCode == null ? null : emplyeeCode.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getEmplyeeLoginPass() {
        return emplyeeLoginPass;
    }

    public void setEmplyeeLoginPass(String emplyeeLoginPass) {
        this.emplyeeLoginPass = emplyeeLoginPass == null ? null : emplyeeLoginPass.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getEeSeq() {
        return eeSeq;
    }

    public void setEeSeq(Integer eeSeq) {
        this.eeSeq = eeSeq;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Integer cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Byte getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(Byte visitStatus) {
        this.visitStatus = visitStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}