# droolslab
* 这里介绍了Drools的简单使用方法

## 下一步的目标
* 下一步开始探索如何使用在drools workbench中的编辑好的规则
* 实验在drools官方文档中提到的7种编辑规则的方式（Table 4）
  * 
  | 手段(asset)      | 优势 | 编辑工具         | 手撕 |
  | ---------------- | ---- | ---------------- | ---- |
  | DMN模型          |      | Business Central | done |
  | 引导决策表       |      |                  |      |
  | 电子表格决策表   |      |                  |      |
  | 引导规则         |      |                  | done |
  | 引导规则模版     |      |                  |      |
  | DRL规则          |      |                  | done |
  | 预测模型标志语言 |      |                  |      |



## 构建项目

* 有部分依赖并不存在于maven的中央仓库中，我们需要从[Redhat EA Repository](https://mvnrepository.com/repos/redhat-earlyaccess)下载我们需要的依赖，需要修改一下pom文件，或者直接修改maven的setting配置文件。

  这里选择在pom文件中添加如下配置

  ```xml
  <repositories>
          <repository>
              <id>redhat.release</id>
              <url>https://maven.repository.redhat.com/earlyaccess/all/</url>
              <releases>
                  <enabled>true</enabled>
              </releases>
              <snapshots>
                  <enabled>true</enabled>
                  <updatePolicy>always</updatePolicy>
                  <checksumPolicy>fail</checksumPolicy>
              </snapshots>
          </repository>
  </repositories>
  ```

  如果发现还是存在依赖错误的情况，可以参考https://www.cnblogs.com/cralor/p/9092971.html，并在maven本地仓库删除报错的响应包。

  如果更新索引极慢，可以尝试https://blog.csdn.net/zqbwangexiunian/article/details/111398343这篇文件的需求。