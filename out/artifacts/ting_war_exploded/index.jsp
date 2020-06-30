<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/11
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>登录 - Ting域主持人平台 - 后台管理</title>
    <%@include file="/head.jsp"%>
    <script type="text/javascript">
      $(function () {
          $("#adminLoginButton").click(function () {
              $("#adminLoginForm").submit();
          })

      })
    </script>
  </head>
  <body>
    <div style="margin: auto;width:400px;margin-top: 20px">
      <form action="${pageContext.request.contextPath}/admin/login" method="post" id="adminLoginForm">
      <div class="easyui-panel" title="Ting域主持人平台-后台管理系统" style="width:400px;padding:50px 60px;text-align: center">
        <c:if test="${flag=='1'}">
          <span style="color: red">登录名或密码错误</span>
        </c:if>
        <c:remove var="flag" scope="session"></c:remove>
        <div style="margin-bottom:20px">
          <input class="easyui-textbox" prompt="请输入用户名" name="aname" iconWidth="28" style="width:100%;height:34px;padding:10px;">
        </div>
        <div style="margin-bottom:20px">
          <input id="pass" class="easyui-passwordbox" prompt="请输入用户密码" name="apwd" iconWidth="28" style="width:100%;height:34px;padding:10px">
        </div>
        <a href="javascript:void(0);"class="easyui-linkbutton" id="adminLoginButton" style="text-align: center;width: 150px">登录</a>
      </div>
      </form>
      <div id="viewer"></div>

      <script type="text/javascript">
          $('#pass').passwordbox({
              inputEvents: $.extend({}, $.fn.passwordbox.defaults.inputEvents, {
                  keypress: function(e){
                      var char = String.fromCharCode(e.which);
                      $('#viewer').html(char).fadeIn(200, function(){
                          $(this).fadeOut();
                      });
                  }
              })
          })
      </script>
      <style>
        #viewer{
          position: relative;
          padding: 0 60px;
          top: -70px;
          font-size: 54px;
          line-height: 60px;
        }
      </style>
    </div>
  </body>
</html>
