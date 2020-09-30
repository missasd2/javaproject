package exam.genshuixue.test1;

/**
 * 账户合并
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个帐户列表，每个元素accounts [i]是一个字符串列表，其中第一个元素accounts [i] [0]是账户名称，其余元素是这个帐户的电子邮件。 现在，我们想合并这些帐户。 如果两个帐户有相同的电子邮件地址，则这两个帐户肯定属于同一个人。 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为两个不同的人可能会使用相同的名称。 一个人可以拥有任意数量的账户，但他的所有帐户肯定具有相同的名称。 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按字典序排序后的电子邮件。 帐户本身可以按任何顺序返回。
 *
 *
 *
 * 输入描述
 * [
 *
 *     ["John", "johnsmith@mail.com", "john00@mail.com"],
 *
 *     ["John", "johnnybravo@mail.com"],
 *
 *     ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 *
 *     ["Mary", "mary@mail.com"]
 *
 * ]
 *
 * 输出描述
 * [
 *
 *     ["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 *
 *     ["John", "johnnybravo@mail.com"],
 *
 *     ["Mary", "mary@mail.com"]
 *
 * ]
 *
 * 解释:
 *
 * 第一个第三个John是同一个人的账户，因为这两个账户有相同的邮箱："johnsmith@mail.com".
 *
 * 剩下的两个账户分别是不同的人。因为他们没有和别的账户有相同的邮箱。
 *
 *
 * 样例输入
 * 4
 * John,johnsmith@mail.com,john00@mail.com
 * John,johnnybravo@mail.com
 * John,johnsmith@mail.com,john_newyork@mail.com
 * Mary,mary@mail.com
 * 样例输出
 * John,john00@mail.com,john_newyork@mail.com,johnsmith@mail.com
 * John,johnnybravo@mail.com
 * Mary,mary@mail.com
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
        int n = accounts.size();
        List<List<String>> res = new LinkedList<>();
        //
        for(int i = 0; i < n-1; i++){
            List<String> list1 = accounts.get(i);
            List<String> list2 = accounts.get(i+1);
            if(helper(list1, list2)){

            }

        }
        return res;


    }
    // 判断两个list是否属于同一个账户
    static boolean helper(List<String> list1, List<String>list2){
        if(!(list1.get(0).equals(list2.get(0)))){
            return false;
        }else{
            list1.remove(0);
            list2.remove(0);
            for(String s : list1){
                if(list2.contains(s)) return true;
            }
        }
        return false;
    }
    // 将两个list合并
    static List<String> merge(List<String> list1, List<String>list2){
        Set<String> tmp = new HashSet<String>();
        for(int i = 1; i < list1.size(); i++){
            tmp.add(list1.get(i));
        }
        for(int i = 1; i < list2.size(); i++){
            tmp.add(list1.get(i));
        }
        List<String> res = new LinkedList<>();
        res.add(list1.get(0));
        for(String s : tmp){
            res.add(s);
        }
        return res;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _count = Integer.parseInt(in.nextLine());

        int _i = 0;
        List<List<String>> _accounts = new ArrayList<List<String>>();
        while (_i++ < _count) {
            String _line = in.nextLine();
            String[] _item = _line.split(",");
            _accounts.add(Arrays.asList(_item));
        }

        List<List<String>> res = mergeAccount(_accounts);

        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                String aName1 = String.join(",", o1);
                String aName2 = String.join(",", o2);
                return aName1.compareTo(aName2);
            }

        });

        for (int res_i = 0; res_i < res.size(); res_i++) {
            List<String> resItem = res.get(res_i);
            System.out.println(String.join(",", resItem));
        }
    }
}

