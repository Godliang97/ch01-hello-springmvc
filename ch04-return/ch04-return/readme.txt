ch04-return:处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward
2.string：表示视图，可以逻辑名称，也可以是完整视图路径
3.void:不能表示数据，也不能表示视图。
    在处理ajax的时候，可以使用void返回值。通过HttpServletResponse输出数据。响应ajax请求。
    ajax请求服务器端返回的就是数据，和视图无关。
4.Object：例如String，Integer，Map，List等等都是对象，
    对象有属性，属性就是数据。所以返回Object表示数据，和视图无关。
    可以使用对象表示的数据，响应ajax请求


    现在做ajax，主要使用json的数据格式。实现步骤：
        1.加入处理json的工具库的依赖，springmvc默认使用的jackson
        2.在springmvc配置文件之间加入 <mvc:annotation-driven> 注解驱动
        3.在处理器方法的上面加入@ResponseBody注解


注意：
    在提交请求参数时，get请求方式中文没有乱码
    使用post方式提交请求，中文有乱码，需要使用过滤器处理乱码的问题

过滤器可以自动定义，也可使用框架中提供的过滤器 CharacterEncodingFilter


实现步骤：
1.新建web maven工程
2.加入依赖
    spring-webmvc依赖，间接把spring的依赖加入到项目
    jsp，servlet依赖

3.重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1）DispatcherServlet叫做中央调度器，是一个servlet，它的父类是继承HttpServlet
    2）DispatcherServlet页叫前端控制器(front controller)
    3）DispatcherServlet负责接收用户提交的请求，调用其它的控制器对象，
        并把请求的处理结果显示给用户

4.创建一个发起请求的页面 index.jsp

5.创建控制器(处理器)类
    1）在类的上面加入@Controller注解，创建对象，并加入到springmvc容器中
    2）在类中的方法上面加入@RequestrianMapping注解

6.创建一个作为结果的jsp，显示请求的处理结果。

7.创建springmvc的配置文件（spring的配置文件一样）
    1）声明组件扫描器，指定@Contorller注解所在的包名
    2）声明视图解析器，帮助处理视图的