# QALogUtil 
使用地址：https://jitpack.io/#qiangzhouliang/QALogUtil
# 1 如何引入自己的项目
## 1.1 将JitPack存储库添加到您的构建文件中
将其添加到存储库末尾的root（项目） build.gradle中：
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
## 1.2 添加依赖项
lastestVersion = [![](https://jitpack.io/v/qiangzhouliang/QALogUtil.svg)](https://jitpack.io/#qiangzhouliang/QALogUtil)
```
dependencies {
	  implementation 'com.github.qiangzhouliang:QALogUtil:$lastestVersion'
}
```
# 2 如何使用
## 2.1 初始化日志级别
默认输出所有日志
```
QALogUtil.initLogLevel(QALogUtil.QALogLevel.LEVEL_DEBUG)
```
## 2.2 使用
```
QALogUtil.i("我是 info")
QALogUtil.v("我是 v")
QALogUtil.w("我是 warring")
QALogUtil.e("我是错误信息")
QALogUtil.logErrAll("我是全部信息")
```
# 3 版本更新说明
## 3.1 1.0.0 版本
Android 输出log日志工具类封装