<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                // alert("button click");
                $.ajax({
                    // url:"returnVoid-ajax.do",
                    url:"returnStudentJson.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
                        //resp从服务器端返回的是json格式的字符串 {"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象，赋值给resp形参
                        alert(resp.name + "   "+resp.age);
                    }
                })
            })

        });
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString-View.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>

    <p>处理器方法返回String表示视图完整路径</p>
    <form action="returnString-View2.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <button id="btn">发起ajax请求</button>


</body>
</html>