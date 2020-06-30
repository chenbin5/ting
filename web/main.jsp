<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ting域主持人平台-后台管理系统</title>
    <%@include file="/head.jsp" %>
    <script type="text/javascript">
        $(function() {
            $("#menuTree").tree({
                'onClick': function (node) { // 增加单击事件
                    var attrMap = node.attributes;
                    console.log(attrMap)
                    // attrMap中有url数据，代表需要页面跳转。
                    if (attrMap.url) { // 当前节点是否存在URL扩展属性。
                        // 判断当前节点对应的选项卡是否存在。
                        if ($("#mainView").tabs('exists', node.text)) {
                            // 选中需要操作的选项卡
                            $("#mainView").tabs('select', node.text);
                        } else {
                            // 开启一个新的选项卡
                            $("#mainView").tabs('add', {
                                'title': node.text,
                                'closable': true,
                                // 使用href请求获取的页面视图，相当于把目标页面的输出结果设置到当前页面的选项卡div中。
                                'href': attrMap.url
                            });
                        }
                    } else {
                        // 没有任何操作
                    }
                }
            })
        });
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:60px">
    <div class="easyui-layout" data-options="border: false" style="height: 58px; width: 100%;">
        <div data-options="region: 'center'" style="text-align: center;background-image: url('http://www.divcss5.com/uploads/allimg/191127/1630554L5-0.jpg')">
            <h2>Ting域主持人平台-后台管理系统</h2>
        </div>
        <div data-options="region:'east'"  style="width: 180px; text-align: right">
            <div style="margin-top: 10px">欢迎${admin.aname}登录。<a class="easyui-linkbutton" href="index.jsp">退出</a></div>
        </div>
    </div>
</div>
<div data-options="region:'west',split:false,title:'菜单'" title="West" style="width:15%;">
    <ul id="menuTree" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/menu/getMenusByParent',method:'get',animate:true,lines:true"></ul>
</div>
<div data-options="region:'center',title:'Ting域主持人平台-后台管理工作区'">
    <div id="mainView" class="easyui-tabs" data-options="fit: true">
        <div title="工作区">工作台</div>
    </div>
</div>
</div>
</body>
</html>

