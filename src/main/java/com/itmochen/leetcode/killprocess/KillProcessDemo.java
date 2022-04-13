package com.itmochen.leetcode.killprocess;

import java.util.*;

/**
 *
 * 每个进程都有一个唯一的 PID(进程id) 和 PPID(父进程id)。
 * 每个进程只有一个父进程，但可能有一个或多个子进程，这就像一个树形结构。
 * 并且只有一个进程的PPID是0，这意味着这个进程没有父进程。所有的pid都是不同的正整数。
 *
 * 我们使用两个整数列表来表示进程列表，其中第一个列表包含每个进程的PID，第二个列表包含对应的PPID。
 *
 * 现在给定这两个列表，以及一个你要终止(kill)的进程的ID，返回将在最后被终止的进程的PID列表。（当一个进程被终止时，它的所有子进程将被终止。返回的列表没有顺序要求）
 *
 *
 * 输入: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
 * 输出: [5, 10]
 * 解释: 终止进程5同样会终止进程10.
 *      3
 *    /   \
 *   1     5
 *        /
 *       10
 *
 * 输入: PID = [1, 2, 3], PPID = [0, 1, 1], killID = 2
 * 输出: [2]
 *
 *       1
 *     /   \
 *    2     3
 *
 * @Author: fan
 * @Date: 2021/11/15 14:39
 * @Version: 1.0
 **/
public class KillProcessDemo {

    /**
     * O(n): 791ms
     * S(n): 21.52MB
     *
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> killId = new ArrayList<Integer>();
        // Write your code here
        if (kill == 0) {
            return Collections.emptyList();
        }
        for (int i = 0; i < ppid.size(); i++) {
            if (kill == pid.get(i)) {
                killId.add(pid.get(i));
            }
            // kill 进程在父进程列表中，找出对应子进程
            if (kill == ppid.get(i)) {
                // 递归查找子进程是否存在子进程
                killId.addAll(killProcess(pid, ppid, pid.get(i)));
            }
        }

        return killId;
    }


    public static void main(String[] args) {
//        System.out.println(new KillProcessDemo().killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
        System.out.println(new KillProcessDemo().killProcess(Arrays.asList(1, 2, 3), Arrays.asList(0, 1, 1), 1));
    }
}
