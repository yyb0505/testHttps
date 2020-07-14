<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a  href="index"><h1><img src="../images/logo.png" alt=" "/> Shutter</h1></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="hover-effect" id="loginText"><a href="login">登录</a></li>
                <li class="hover-effect" id="registerText"><a href="index.html">注册</a></li>
                <li class="hover-effect"><a href="index">图库</a></li>
                <li class="hover-effect"><a href="contact.jsp">联系我们</a></li>
            </ul>
        </div>
    </div>
</nav>
<script>
    let userInfo = '${userInfo}';
    let userFlag = false;
    if(userInfo != "" && userInfo != null){
        userInfo = JSON.parse('${userInfo}');
        userFlag = true;
        $("#loginText,#registerText").remove();
        $("#navbar ul").prepend('<li class="hover-effect"><a href="index.html">欢迎您,'+userInfo.userName+'</a></li><li class="hover-effect"><a href="releaseContentPage">发表动态</a></li>');
    }
</script>