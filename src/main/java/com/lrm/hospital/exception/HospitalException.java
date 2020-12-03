package com.lrm.hospital.exception;

/**
 * 〈功能概述〉<br>
 *
 * @className: HospitalException
 * @package: com.lrm.hospital.exception
 * @author: mamingcong
 * @date: 2020/12/3 23:46
 */
public class HospitalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public HospitalException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
