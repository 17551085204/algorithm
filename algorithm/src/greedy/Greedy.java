/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/18
*/

package greedy;
//import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String[] args) {
        // 创建广播电台集合
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");hashSet1.add("上海");hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");hashSet2.add("北京");hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");hashSet3.add("上海");hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");hashSet5.add("大连");
        // 加入map中
        broadcast.put("k1",hashSet1);broadcast.put("k2",hashSet2);
        broadcast.put("k3",hashSet3);broadcast.put("k4",hashSet4);
        broadcast.put("k5",hashSet5);

        // 存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京"); allAreas.add("上海"); allAreas.add("天津");
        allAreas.add("广州"); allAreas.add("深圳"); allAreas.add("成都");
        allAreas.add("杭州"); allAreas.add("大连");

        // 创建一个list,存放选择的电台集合
       ArrayList<String> selects= new ArrayList<>();
       // 定义一个临时集合，保存在遍历过程中，存放遍历过程中电台覆盖地区与当前
        // 还没有覆盖地区的交集
         HashSet<String> tempSet = new HashSet<>();
        // 定义MaxKey,在一次遍历过程中，能够覆盖最大为覆盖地区对应的电台的key
        String maxKey=null;
        // 如果maxKey不为空，将其加入selects中
        while (allAreas.size()!=0){
            maxKey=null; // 下一次循环做准备
            // 遍历broadcast,取出key
            for(String key:broadcast.keySet()){
                tempSet.clear();
                HashSet<String> areas = broadcast.get(key);
                tempSet.addAll(areas);
                // 计算2个集合之间的交集
                tempSet.retainAll(allAreas);
                if(tempSet.size()>0&&(maxKey==null||tempSet.size()>broadcast.get(maxKey).size())){
                    maxKey=key;
                }

            }
            if(maxKey!=null){
                selects.add(maxKey);
                // 从allAreas中去掉maxKey对应的
                allAreas.removeAll(broadcast.get(maxKey));
            }

        }

        System.out.println("选择的："+selects);


    }




}
