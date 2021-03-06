##maven注意事项
maven由于约定大于配置，可能遇到写的配置文件无法被导出或生效的问题，解决方案：
```xml
<!-- 在build中手动配置resouress，将含有配置文件的路径放入-->
<!--在build中配置resources，来防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>


```
如果失败，记得刷新，还不行就把true换成false

##mybatis三个主要对象
1.SqlSessionFactoryBuilder

    这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。
     你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但最好还是不要一直保留着它，以保证所有的 XML 解析资源可以被释放给更重要的事情。
2.SqlSessionFactory（单例）

    SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复
    创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏习惯”。因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或
    者静态单例模式。
3.SqlSession（每个线程对应一个，不可共享（因为不安全））

    每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例
    的引用放在一个类的静态域，甚至一个类的实例变量也不行。 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。 如果你现在正
    在使用一种 Web 框架，考虑将 SqlSession 放在一个和 HTTP 请求相似的作用域中。 换句话说，每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应后，就关闭它。 这个关闭操作很重要，为了确保每次都能执行关闭操作，你应该把这个关闭操作放到 finally 块中。

###注意点：
    在xml中，所有标签都可以规定其顺序，当有规定存在时，必须按规定的顺序插入标签！！！


作用域和生命周期类别是至关重要的，因为错误的使用会导致非常严重的并发问题。

SqlSessionFactoryBuilder:

一旦创建了 SqlSessionFactory，就不再需要它了 。
局部变量
SqlSessionFactory：

就是数据库连接池。
一旦被创建就应该在应用的运行期间一直存在 ，没有任何理由丢弃它或重新创建另一个实例 。 多次重建 SqlSessionFactory 被视为一种代码“坏习惯”。
因此 SqlSessionFactory 的最佳作用域是应用作用域。
最简单的就是使用单例模式或者静态单例模式。
SqlSession：

每个线程都应该有它自己的 SqlSession 实例。
连接到连接池的请求！
SqlSession 的实例不是线程安全的，因此是不能被共享的 ，所以它的最佳的作用域是请求或方法作用域。
用完之后赶紧关闭，否则资源被占用。

##关于@Param()注解
    1.基本类型的参数或者String类型的参数,需要加上
    2.引用类型不需要加
    3.如果只有一个基本类型的话,可以忽略,但是建议加上
    4.在sql语句中引用的就是@Param("uid")中设定的属性名!
