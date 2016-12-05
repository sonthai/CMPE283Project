package com.dashboard.utils;



import java.util.*;


public class Utils {
    public static List<String> constructQuery(Set<String> fields, String delim, boolean isWhereClause) {
        List<String> list = new ArrayList<>();
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        if (delim == null) {
            keys.append("(");
            values.append("(");
        }
        for (String field: fields) {
            if (keys.length() > 1) {
                if (!isWhereClause) {
                    keys.append(",");
                } else {
                    keys.append(" AND ");
                }
                if (delim == null) {
                    values.append(",");
                }
            }
            keys.append(field);
            if (delim == null) {
                values.append(":").append(field);
            } else {
                keys.append(delim).append(":").append(field);
            }

        }
        if (delim == null) {
            keys.append(")");
            values.append(")");
        }
        list.add(keys.toString());
        list.add(values.toString());

        return list;
    }

    public static Map<String, Object> setUpInstanceData(Map<String, Object> map) {
        map.put("dateCreated", new Date());
        map.put("dateReleased", new Date());
        map.put("status", "running");

        String flavor = (String) map.get("flavor");
        if (flavor.equalsIgnoreCase("tiny")) {
            map.put("memory", 512);
            map.put("cpu", 1);
        } else if (flavor.equalsIgnoreCase("small")) {
            map.put("memory", 2048);
            map.put("cpu", 1);
        } else {
            map.put("memory", 4096);
            map.put("cpu", 2);
        }

        return  map;
    }
}
