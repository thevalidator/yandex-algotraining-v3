/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.f;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class ConnectivityComponents {

    public static void main(String[] args) {
        try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
            //try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            var input = br.readLine();
            String[] data = input.split(" ");

            Map<Integer, HashSet<Integer>> list = new HashMap<>();

            for (int i = 0; i <= Integer.parseInt(data[0]); i++) {
                list.putIfAbsent(i, new HashSet<>());
            }

            for (int i = 0; i < Integer.parseInt(data[1]); i++) {
                String[] s = br.readLine().split(" ");
                int v = Integer.parseInt(s[0]);
                int r = Integer.parseInt(s[1]);

                HashSet<Integer> set = list.getOrDefault(v, new HashSet<>());
                set.add(r);
                list.putIfAbsent(v, set);

                HashSet<Integer> set2 = list.getOrDefault(r, new HashSet<>());
                set2.add(v);
                list.putIfAbsent(r, set2);
            }

            String res = solution(list);
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solution(Map<Integer, HashSet<Integer>> list) {

        if (list.size() == 1) {
            return "1\n1";
        }

        boolean[] visited = new boolean[list.size()];
        
        int connectivityNumber = 0;
        List<Set<Integer>> connectivityList = new ArrayList<>();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                connectivityNumber++;
                Set<Integer> connectivity = dfs(i, visited, list, connectivityNumber, new HashSet<>());
                connectivityList.add(connectivity);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(connectivityList.size());
        for (Set<Integer> set : connectivityList) {
            sb.append("\n").append(set.size()).append("\n");
            for (Integer i : set) {
                sb.append(i).append(" ");
            }
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }

    private static Set<Integer> dfs(Integer key, 
            boolean[] visited, 
            Map<Integer, HashSet<Integer>> list, 
            int connectivityNumber, 
            Set<Integer> connectivity) {
        
        visited[key] = true;
        connectivity.add(key);
        for (Integer i : list.get(key)) {
            if (!visited[i]) {
                dfs(i, visited, list, connectivityNumber, connectivity);
            }
        }
        
        return connectivity;
    }
}
