<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css" tppabs="http://res.layui.com/layui/dist/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>基本演示</legend>
</fieldset>
<div class="layui-btn-container">
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="getChecked">获取选中节点数据</button>
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="setChecked">勾选指定节点</button>
  <button type="button" class="layui-btn layui-btn-sm" lay-demo="reload">重载实例</button>
</div>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>食品行业产业链</legend>
</fieldset>

<div id="test5" class="demo-tree"></div>

<script src="layui/layui.js" charset="utf-8"></script>
<script src="layui/jquery.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
  function getData(){
    var data = [];
    $.ajax({
      url: "${pageContext.request.contextPath}/DataServlet",    //后台数据请求地址
      type: "post",
      async:false,
      success: function(resut){
        data = resut;
        window.alert(data);
      }
    });
    return data;
  }
  layui.use(['tree', 'util'], function(){
    var tree = layui.tree
            ,layer = layui.layer
            ,util = layui.util

            //模拟数据
            ,data = getData()

    //按钮事件
    util.event('lay-demo', {
      getChecked: function(othis){
        var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据

        layer.alert(JSON.stringify(checkedData), {shade:0});
        console.log(checkedData);
      }
      ,setChecked: function(){
        tree.setChecked('demoId1', [12, 16]); //勾选指定节点
      }
      ,reload: function(){
        //重载实例
        tree.reload('demoId1', {

        });

      }
    });

    //手风琴模式
    tree.render({
      elem: '#test4'
      ,data: [{
        title: '优秀'
        ,children: [{
          title: '80 ~ 90'
        },{
          title: '90 ~ 100'
        }]
      },{
        title: '良好'
        ,children: [{
          title: '70 ~ 80'
        },{
          title: '60 ~ 70'
        }]
      },{
        title: '要努力奥'
        ,children: [{
          title: '0 ~ 60'
        }]
      }]
      ,accordion: true
    });

    //点击节点新窗口跳转
    tree.render({
      elem: '#test5'
      ,data: data
      ,isJump: true  //link 为参数匹配
    });

  });
</script>

</body>
</html>