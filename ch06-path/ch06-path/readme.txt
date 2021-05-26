ch06-path：解决jsp页面中的路径问题，用“/” 还是不用

地址分类：
    1.绝对地址：带有协议名称的是绝对地址
    2.相对地址：没有协议开头的  相对地址不能独立使用，必须有一个参考地址。
               通过参考地址+相对地址本身才能指定资源。

    3.参考地址
        1）在你的页面中，访问地址不加“/”
        访问的是：http://localhost:8080/cho6-path/index.jsp
        路径：http://localhost:8080/ch06-path/
        资源:index.jsp

        在index.jsp发起 user/some.do 请求，访问地址变为 http://localhost:8080/ch06-path/user/some.do
        当你的地址 没有 / 开头，例如 uesr/some.do，当你点击链接时，访问地址是当前页面的地址 加上 链接的地址
        http://localhost:8080/ch06-path/ + user/some.do

        **********************************************************************
        index.jsp 访问user/some.do, 返回后现在的地址：http://localhost:8080/ch06_path/user/some.do
        路径：http://localhost:8080/ch06_path/user/
        资源；some.do

        在index.jsp 在点击 user/some.do  就变为 http://localhost:8080/ch06_path/user/user/some.do

        解决方案：
        1.加入${pageContext.request.contextPath}
        2.加入一个base标签，是html语言中的标签。表示当前页面中访问地址的基地址。
            你的页面中所有 没有“/”开头的地址，都是以base标签中的地址为参考地址
            使用base中的地址 + user/some.do 组成访问地址
        ***********************************************************************

        2）在你的页面中，访问地址加 “/”
          访问的是：http://localhost:8080/ch06-path/index.jsp
          路径：http://localhost:8080/ch06-path/
          资源：index.jsp

          点击 /user/some.do 访问地址变为 http://localhost:8080/user/some.do
          参考地址是 你的服务器地址，也就是 http://localhost:8080

          如果你的资源不能访问，加入EL表达式 ${pageContext.request.contextPath}



