<<<<<<< HEAD
javas
############################# 创建线程三种方式对比： runnable与callable接口：可以继承其他类，可以只用一个target，因此可共享资源
=======
# javas
#############################
创建线程三种方式对比：
  runnable与callable接口：可以继承其他类，可以只用一个target，因此可共享资源
>>>>>>> c56ebb3dcfd48d77a983b0eb117851517fdf6d04
# 
后台线程：
#
    1、当前台线程全部结束，后台线程结束。
    2、必须在start()方法调用之前
    3、前台线程创建的子线程为前台线程，后台为后台
#
tcpsocket.numThread内容
#
    考虑到阻塞的情况，所以在服务端为每个socket都创建一个线程，避免因为一个BufferedReader.readLine()之类
    的原因阻塞，导致全部阻塞。
    在socket客户端也用了两个线程，一个用来输入，一个用来读取。
  
#
    MultiDown 多线程下载资源，使用URL类获取资源
    URL对象可以openStream，创建一个inputStream。根据线程数与资源的长度划分资源，使用多线程的时候对inputStream做一个跳转，则
    每个线程只下载自己那一部分。