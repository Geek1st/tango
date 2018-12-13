# tango

##


## 命名规则
`Controller层：`是用简单的命名告诉前台该方法  
`Mapper`层：按照mybatis默认约定，将使用`mapper`而不是`dao`，实际作用是一样的，只是名称发生了变化。

## 代码生成工具
项目使用mybatis generator来生成代码，你也可以使用其他工具或者mybatis generator第三方图形化工具。配置文件位叫做`generatorConfig.xml`，你可以使用eclipse的mybatis generator插件去执行他，或者通过maven来运行。更多关于mybatis generator的使用方式，点击查看[官方文档](http://www.mybatis.org/generator/)
### generatorConfig
默认采用`MIXEDMAPPER`方式生成代码，即注解和XML混合使用，不推荐使用sqlprovider与example方式来写DAO层代码。system包下的业务较为简单，所以使用注解方式，可读性较高，并且减少文件映射。