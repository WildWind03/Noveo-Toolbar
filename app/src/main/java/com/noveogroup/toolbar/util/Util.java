package com.noveogroup.toolbar.util;

import java.util.List;

public class Util {
    private final static int COUNT_OF_DEPARTMENTS = 60;
    public static final String DEPARTMENT_OF_IT_TEXT = "Department of IT";
    public static final String DEAPARTMENT_OF_FOREIGN_LANGUAGES_TEXT = "Deaprtment of foreign languages";
    public static final String DEPARTMENT_OF_PHYSICS_TEXT = "Department of physics";
    public static final String DEPARTMENT_OF_MATHEMATICS_TEXT = "Department of mathematics";
    public static final String DEPARTMENT_OF_NATURE_SCIENCES_TEXT = "Department of nature sciences";
    public static final String DEPARTMENT_OF_ECONOMICS_TEXT = "Department of economics";
    public static final String DEPARTMENT_TEXT = "Department ";

    private Util() {

    }

    public static void fillList(List<String> list) {
        list.add(DEPARTMENT_OF_IT_TEXT);
        list.add(DEAPARTMENT_OF_FOREIGN_LANGUAGES_TEXT);
        list.add(DEPARTMENT_OF_PHYSICS_TEXT);
        list.add(DEPARTMENT_OF_MATHEMATICS_TEXT);
        list.add(DEPARTMENT_OF_NATURE_SCIENCES_TEXT);
        list.add(DEPARTMENT_OF_ECONOMICS_TEXT);

        for (int k = 0; k < COUNT_OF_DEPARTMENTS; ++k) {
            list.add(DEPARTMENT_TEXT + k);
        }
    }
}
