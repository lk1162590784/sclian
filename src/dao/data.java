package dao;

import bean.Dept;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class data {
    public JSONArray getdata() {
        List<HashMap<String, Object>> result = new ArrayList<>();
        ArrayList<String> lian = new ArrayList<>();
        Jdbc jdbc = new Jdbc();
//        String lian = "生物医药产业链";
        cplian cplian = new cplian();
        lian = cplian.getlian();
        for (int i = 0; i < lian.size(); i++) {
            List<HashMap<String, Object>> result1 = new ArrayList<>();
            HashMap<String, Object> map = new HashMap<>();
            System.out.println(lian.get(i));
            List<Dept> dept1 = new ArrayList<>();
            dept1=jdbc.getdata(lian.get(i));
            System.out.println(dept1);
            for (Dept d : dept1) {
            List<HashMap<String, Object>> result3 = new ArrayList<>();
            HashMap<String, Object> map1 = new HashMap<>();
            HashMap<String, Object> map3 = new HashMap<>();
            String url = "http://gxt.hebei.gov.cn/main/portal/cylgyDetail?id=";
            String url1;
            System.out.println(d.getId());
            map3.put("title",d.getCpcompany());
            map3.put("spread",true);
            result3.add(map3);
            map1.put("children",result3);
            map1.put("id", d.getId());
            map1.put("spread", true);
            map1.put("title", d.getCpname());
            url1 = url + d.getId();
            map1.put("href", url1);
            result1.add(map1);
                System.out.println(result1);
//            map.put("children",  result1);
            //设置是否展开
            //下级菜单
            //这里可以根据自己需求判断节点默认选中
        /*if(m.getParent() != null || m.getChildren().size() == 0){
            map.put("checked", true);    //设置为选中状态
        }*/
        }
            map.put("children", result1);
            map.put("title", lian.get(i));
            result.add(map);
        }
        System.out.println(result);

        JSONArray json = new JSONArray();
        json= JSONArray.parseArray(JSONObject.toJSONString(result));
        System.out.println("...................................................");
        System.out.println(json.toString());
        return json;

    }
    public static String getType(Object o){
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

    public static void main(String[] args) {
        data data = new data();
        data.getdata();
    }



}
