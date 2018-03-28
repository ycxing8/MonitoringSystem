package com.seu.monitor.config;

import com.seu.monitor.entity.User;

public class UserConfig {
    public final static String USER_NAME = "userName";
    public final static String USER_POWER ="userPower";

    public final static String ADMIN = "admin";
    public final static String SPECIAL_USER = "special";
    public final static String NORMAL_USER = "normal";
    public final static String NONE_USER = "none";

    public final static Integer ADMIN_INTEGER = 0;
    public final static Integer SPECIAL_USER_INTEGER = 1;
    public final static Integer NORMAL_USER_INTEGER = 2;

    public final static String ALL_MACHINE = "all";
    //user can control machine which identifier in user's machineIdentifiers.
    // Each machine identifier use ";" to flag the end.

    public final static String getUserPowerByInteger(Integer powerInteger){
        if(powerInteger == ADMIN_INTEGER){
            return ADMIN;
        }else if(powerInteger == SPECIAL_USER_INTEGER){
            return SPECIAL_USER;
        }else if(powerInteger == NORMAL_USER_INTEGER){
            return NORMAL_USER;
        }
        return NONE_USER;
    }

    public final static Boolean verifyUserPower(String power, String needPower){
        if(needPower.equals(ADMIN)){
            if(power.equals(ADMIN)){
                return true;
            }
        }else if(needPower.equals(SPECIAL_USER)){
            if(power.equals(ADMIN)||
                    power.equals(SPECIAL_USER)){
                return true;
            }
        }else if(needPower.equals(NORMAL_USER)){
            if(power.equals(ADMIN)||
                    power.equals(SPECIAL_USER)||
                    power.equals(NORMAL_USER)){
                return true;
            }
        }
        return false;
    }

}
