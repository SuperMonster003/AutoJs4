<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <img src="https://s1.imagehub.cc/images/2025/09/12/80399dc27245a36ea8cadd63b0d26148.png" alt="autojs4-banner_800×224" border="0" width="704" />
  </p>

  <p>Android 平台支持无障碍服务的 JavaScript 自动化工具</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs4/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs4?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs4/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs4?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs4/commit/8de11699b608be1c1f49f0f10e2e2826f8c77978"><img alt="Created" src="https://img.shields.io/date/1681227960?color=2e7d32&label=Created"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <br>
    <a href="https://github.com/mozilla/rhino"><img alt="Rhino" src="https://img.shields.io/badge/Rhino-1.7.7.2-485579"/></a>
    <a href="https://www.jetbrains.com/?from=AutoJs4"><img alt="JetBrains supporter" src="https://img.shields.io/badge/Supporter-JetBrains-AA2786"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs4/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs4?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 简介

******

[Auto.js](https://github.com/hyb1996/Auto.js) 是一款 Android 平台支持 [无障碍服务](https://developer.android.com/guide/topics/ui/accessibility/service?hl=zh-cn) 的 JavaScript 自动化工具软件.

Auto.js 由 [hyb1996](https://github.com/hyb1996) 于 `2017/01/27` 初次发布, 于 `2020/03/13` 停止维护, 最终版本名称为 `4.1.1 Alpha2`, 构建版本号为 `461`.

AutoJs4 在 Auto.js 最终项目的基础上, 于 `2023/04/11` 进行二次开发, 继续保持开源免费.

******

### 功能

******

* 可用作 JavaScript IDE (代码补全/变量重命名/代码格式化)
* 支持基于 [无障碍服务](https://developer.android.com/reference/android/accessibilityservice/AccessibilityService) 的自动化操作
* 支持浮动按钮快捷操作 (脚本录制及运行/查看包名及活动/布局分析)
* 支持选择器 API 并提供控件遍历/获取信息/控件操作 (类似 [UiAutomator](https://developer.android.com/training/testing/ui-automator))
* 支持布局界面分析 (类似 Android Studio 的 LayoutInspector)
* 支持录制功能及录制回放
* 支持屏幕截图/保存截图/图片找色/图片匹配
* 支持 [E4X](https://zh.wikipedia.org/wiki/E4X) (ECMAScript for XML) 编写界面
* 支持将脚本文件或项目打包为 APK 文件
* 支持利用 Root 权限扩展功能 (屏幕点击/滑动/录制/Shell)
* 支持作为 Tasker 插件使用
* 支持与 VSCode 连接并进行桌面开发 (需要 [AutoJs4-VSCode-Extension](https://github.com/SuperMonster003/AutoJs4-VSCode-Extension) 插件)

******

### 环境

******

- Android 操作系统
- [API](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) [19](https://developer.android.com/reference/android/os/Build.VERSION_CODES#KITKAT) ([4.4](https://zh.wikipedia.org/wiki/Android_KitKat)) [[KITKAT](https://developer.android.com/reference/android/os/Build.VERSION_CODES#KITKAT)] 及以上

******

### 版本历史

******

# v4.4.0

###### 2026/03/15

* `优化` 主页不再显示强制更新对话框
* `优化` 应用支持 arm64-v8a CPU 架构设备安装
* `优化` 部分依赖或本地库版本调整 _[`CHANGELOG.md`](https://github.com/SuperMonster003/AutoJs4/blob/master/app/src/main/assets/doc/CHANGELOG.md#v440)_

##### 更多版本历史可参阅

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs4/blob/master/app/src/main/assets/doc/CHANGELOG.md)

******

### 许可

******

基于 [Mozilla Public License Version 2.0](https://github.com/SuperMonster003/AutoJs4/blob/master/LICENSE) 并附加以下条款:

非商业性使用 - 不得将此项目及衍生项目的源代码和二进制产品用于任何商业和盈利用途
