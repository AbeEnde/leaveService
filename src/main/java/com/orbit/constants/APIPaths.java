package com.orbit.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class APIPaths {

    public static final String VERSION = "v1";
    public static final String APP_ROOT_PATH = "/api/" + VERSION + "/";


    public static final String EMPLOYEE_MAPPING = APP_ROOT_PATH + "employee";
    public static final String ADD_EMPLOYEE = "/addEmployee";
    public static final String GET_LEAVE_BALANCE = "/leavebalance/{id}";
    public static final String UPDATE_LEAVE_BALANCE = "/{id}";


    public static final String HOLIDAY_MAPPING = APP_ROOT_PATH + "holiday";
    public static final String GET_HOLIDAY = "/{id}";
    public static final String ALL_HOLIDAY = "/";
    public static final String DELETE_HOLIDAY = "/{id}";
    public static final String UPDATE_HOLIDAY = "/{id}";


    public static final String LEAVE_MAPPING = APP_ROOT_PATH + "leave";
    public static final String GET_LEAVE = "/{id}";
    public static final String ALL_LEAVE = "/";
    public static final String ALL_LEAVE_BY_STATUS = "/leavebystatus";
    public static final String ALL_LEAVE_BY_MANAGER_ID = "/leavebymanagerid";
    public static final String ALL_LEAVE_BY_STATUS_MANAGER = "/leavebystatusformanager";
    public static final String LEAVE_COUNT_BY_STATUS = "/leavecountbystatusformanager";
    public static final String LEAVE_BY_EMPLOYEE_ID = "/leavebyemployeeid";
    public static final String UPDATE_LEAVE = "/";
    public static final String DELETE_LEAVE = "/{id}";


    public static final String LEAVE_TYPE_MAPPING = APP_ROOT_PATH + "leave-type";
    public static final String GET_LEAVE_TYPE = "/{id}";
    public static final String DELETE_LEAVE_TYPE = "/{id}";
    public static final String UPDATE_LEAVE_TYPE = "/{id}";


    public static final String NOTIFICATION_MAPPING = APP_ROOT_PATH;
    public static final String NOTIFY = "/notify";

}
