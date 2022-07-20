<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
        </blockquote>
        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>Zzx若依后台管理框架</h2>
        <p>zzx平时学习若依系统测试框架
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>


              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.8.3 - 2022-06-27">
              <ol>
                <li>新增缓存列表菜单功能</li>
                <li>代码生成树表新增(展开/折叠)</li>
                <li>Excel注解支持color字体颜色</li>
                <li>新增Anonymous匿名访问不鉴权注解</li>
                <li>用户头像上传限制只能为图片格式</li>
                <li>接口使用泛型使其看到响应属性字段</li>
                <li>检查定时任务bean所在包名是否为白名单配置</li>
                <li>添加页签openPage支持传递参数</li>
                <li>用户缓存信息添加部门ancestors祖级列表</li>
                <li>升级element-ui到最新版本2.15.8</li>
                <li>升级oshi到最新版本6.1.6</li>
                <li>升级druid到最新版本1.2.11</li>
                <li>升级fastjson到最新版2.0.8</li>
                <li>升级spring-boot到最新版本2.5.14</li>
                <li>降级jsencrypt版本兼容IE浏览器</li>
                <li>删除多余的salt字段</li>
                <li>新增获取不带后缀文件名称方法</li>
                <li>新增获取配置文件中的属性值方法</li>
                <li>新增内容编码/解码方便插件集成使用</li>
                <li>字典类型必须以字母开头，且只能为（小写字母，数字，下滑线）</li>
                <li>优化设置分页参数默认值</li>
                <li>优化对空字符串参数处理的过滤</li>
                <li>优化显示顺序orderNum类型为整型</li>
                <li>优化表单构建按钮不显示正则校验</li>
                <li>优化字典数据回显样式下拉框显示值</li>
                <li>优化R响应成功状态码与全局保持一致</li>
                <li>优化druid开启wall过滤器出现的异常问题</li>
                <li>优化用户管理左侧树型组件增加选中高亮保持</li>
                <li>优化新增用户与角色信息&用户与岗位信息逻辑</li>
                <li>优化默认不启用压缩文件缓存防止node_modules过大</li>
                <li>修复字典数据显示不全问题</li>
                <li>修复操作日志查询类型条件为0时会查到所有数据</li>
                <li>修复Excel注解prompt/combo同时使用不生效问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.2 - 2022-04-01">
              <ol>
                <li>前端支持设置是否需要防止数据重复提交</li>
                <li>开启TopNav没有子菜单情况隐藏侧边栏</li>
                <li>侧边栏菜单名称过长悬停显示标题</li>
                <li>用户访问控制时校验数据权限，防止越权</li>
                <li>导出Excel时屏蔽公式，防止CSV注入风险</li>
                <li>组件ImagePreview支持多图预览显示</li>
                <li>组件ImageUpload支持多图同时选择上传</li>
                <li>组件FileUpload支持多文件同时选择上传</li>
                <li>服务监控新增运行参数信息显示</li>
                <li>定时任务目标字符串过滤特殊字符</li>
                <li>定时任务目标字符串验证包名白名单</li>
                <li>代码生成列表图片支持预览</li>
                <li>代码生成编辑修改打开新页签</li>
                <li>代码生成新增Java类型Boolean</li>
                <li>代码生成子表支持日期/字典配置</li>
                <li>代码生成同步保留必填/类型选项</li>
                <li>升级oshi到最新版本6.1.2</li>
                <li>升级fastjson到最新版1.2.80</li>
                <li>升级pagehelper到最新版1.4.1</li>
                <li>升级spring-boot到最新版本2.5.11</li>
                <li>升级spring-boot-mybatis到最新版2.2.2</li>
                <li>添加遗漏的分页参数合理化属性</li>
                <li>修改npm即将过期的注册源地址</li>
                <li>修复分页组件请求两次问题</li>
                <li>修复通用文件下载接口跨域问题</li>
                <li>修复Xss注解字段值为空时的异常问题</li>
                <li>修复选项卡点击右键刷新丢失参数问题</li>
                <li>修复表单清除元素位置未垂直居中问题</li>
                <li>修复服务监控中运行参数显示条件错误</li>
                <li>修复导入Excel时字典字段类型为Long转义为空问题</li>
                <li>修复登录超时刷新页面跳转登录页面还提示重新登录问题</li>
                <li>优化加载字典缓存数据</li>
                <li>优化IP地址获取到多个的问题</li>
                <li>优化任务队列满时任务拒绝策略</li>
                <li>优化文件上传兼容Weblogic环境</li>
                <li>优化定时任务默认保存到内存中执行</li>
                <li>优化部门修改缩放后出现的错位问题</li>
                <li>优化Excel格式化不同类型的日期对象</li>
                <li>优化菜单表关键字导致的插件报错问题</li>
                <li>优化Oracle用户头像列为空时不显示问题</li>
                <li>优化页面若未匹配到字典标签则返回原字典值</li>
                <li>优化修复登录失效后多次请求提示多次弹窗问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2019-10-08">
              <ol>
                <li>若依前后端分离系统正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.3",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

