## 本项目仿造美团外卖制作的课程设计，仅供个人使用

> 后续更新请关注[ahaostillcoding/Takeaway: 仿美团外卖安卓课程设计 (github.com)](https://github.com/ahaostillcoding/Takeaway)****

## 已实现功能

### 1.连接数据库登录

> 本地测试连接文件放在utils文件夹下

​	登录界面和java文件写在了activity_main.xml和mainactivity.java中	

​	连接数据库实现方法是用fastapi写的连接mysql接口，fastapi和mysql数据库在服务器上，安卓端通过HttpURLConnection方式访问接口。

​	目前就写了两个接口，一个添加账户密码数据，一个查询所有用户密码。

​	****

![image-20231211193930300](https://typoranote-picture.oss-cn-guangzhou.aliyuncs.com/typora%E5%9B%BE%E7%89%87/image-20231211193930300.png)

![image-20231211193952317](https://typoranote-picture.oss-cn-guangzhou.aliyuncs.com/typora%E5%9B%BE%E7%89%87/image-20231211193952317.png)

### 2.简单的店家页面

​	用listview写的一个店家列表，数据是本地写死的。点击后可以跳转到详细界面，详细界面还没写完，只用intent传递了点击的列的信息和一个返回键通过intent返回主页面。详细页xml和java都没完成

![image-20231211194424042](https://typoranote-picture.oss-cn-guangzhou.aliyuncs.com/typora%E5%9B%BE%E7%89%87/image-20231211194424042.png)

店家页面文件是ShopActivity.java activity_shop.xml(主布局文件)  shop_item.xml(listview布局文件)

## 尚未完成功能

### 1.底部导航栏

​	写了个底部导航栏navigation_bar.xml和navigation_bar.java。采用的方法是RadioGroup + ViewPager 实现。但是只能实现简单的页面切换，但是切换页面后不能触发对应页面的java代码。我切换到店家页面后不能触发shopactivity.java中实现listview的数据初始化，就显示不出来了。

应该还需要使用fragment来实现，改了一部分还没改好。



![image-20231211160836194](https://typoranote-picture.oss-cn-guangzhou.aliyuncs.com/typora%E5%9B%BE%E7%89%87/image-20231211160836194.png)

### 2.详细店家页面

​	只写了intent传递数据，和一个返回键返回店家页面

![image-20231211194755790](https://typoranote-picture.oss-cn-guangzhou.aliyuncs.com/typora%E5%9B%BE%E7%89%87/image-20231211194755790.png)
