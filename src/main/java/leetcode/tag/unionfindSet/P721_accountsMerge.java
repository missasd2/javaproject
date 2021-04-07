package leetcode.tag.unionfindSet;

import java.util.*;

/**
 * union find sets并查集
 * P721 合并账户
 */
public class P721_accountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for(List<String> account : accounts) {
            // 每条记录的第一个为  名称
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    // 每个邮件 进行计数, 构建用0-N-1 表示的初始化数组
                    emailToIndex.put(email, emailsCount++);
                    // 邮件 到 名称 的映射
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);

        // 开始进行并查操作
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                // 不断进行 链接操作
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            // 找到每个邮件email的根节点
            int index = uf.find(emailToIndex.get(email));
            // 得到每个根节点 对应的所有email
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            // 将属于同一根节点index，的邮件进行聚拢
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            // 排序
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}
