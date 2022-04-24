package com.jjcraft.ttoi.util;

public class HelperMethods {

    public void HelperMethods() {
    }

    public static <object> boolean arrayContainsObject(object[] array, object obj) {
        for(int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                return (true);
            }
        }
        return(false);
    }
}
