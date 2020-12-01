package com.lrm.hospital.enums;

import org.springframework.util.StringUtils;


public enum UserType {

    DOCTOR("1", "医生"),
    WORKER("2", "工作人员"),
    NORMAL("3", "普通人");
    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private UserType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UserType get(String code) {
        if (StringUtils.hasLength(code)) {
            for (UserType element : UserType.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }
}
