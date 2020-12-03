package com.lrm.hospital.enums;

import org.springframework.util.StringUtils;

/**
 * 〈功能概述〉<br>
 *
 * @className: BookDetailStatus
 * @package: com.lrm.hospital.enums
 * @author: mamingcong
 * @date: 2020/12/3 23:49
 */
public enum  BookDetailStatus {

    WAITING("1", "待就诊"),
    HAS("2", "已就诊");
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

    private BookDetailStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static BookDetailStatus get(String code) {
        if (StringUtils.hasLength(code)) {
            for (BookDetailStatus element : BookDetailStatus.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }
}
