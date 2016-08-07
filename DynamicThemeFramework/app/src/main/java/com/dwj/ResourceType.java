package com.dwj;

/**
 * Created by Administrator on 2016/8/7.
 */
public enum ResourceType {

    STRING("String"),

    COLOR("Color"),

    DRAWABLE("Drawable");

    private String value;

    private ResourceType(String value){
        this.value = value;
    }

    public static ResourceType getResourceType(String value){
        if(value.equalsIgnoreCase(STRING.value)){
            return STRING;
        }else if(value.equalsIgnoreCase(COLOR.value)){
            return COLOR;
        }else if(value.equalsIgnoreCase(DRAWABLE.value)){
            return DRAWABLE;
        }

        throw new IllegalArgumentException("Not Support ResourceType");
    }

}
