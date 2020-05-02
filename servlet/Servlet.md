## Servlet

Servlet，全称Java Servlet。是用Java编写的服务器端程序。其主要功能在于交互式地浏览和修改数据，生成动态Web内容。

> ``` javax.servlet.Servlet ``` 主要有<strong>init()、getServletConfig()、service()、getServletInfo()、destroy()</strong>方法。
>
> * init()是Servlet实例加载后执行的方法；
> * getServletConfig()方法Returns a {@link ServletConfig} object, which contains initialization and startup parameters for this servlet.
> * service()方法 Called by the servlet container to allow the servlet to respond to a request. 没请求一次都会执行这个方法；这个是**最重要**的方法
> * getServletInfo()方法Returns information about the servlet；
> * destroy()方法是在Servlet销毁的时候执行。

