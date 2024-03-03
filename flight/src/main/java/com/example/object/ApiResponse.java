package com.example.object;

public class ApiResponse {
    private String message;
    private Object data;

    public ApiResponse(String success, Object o) {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
