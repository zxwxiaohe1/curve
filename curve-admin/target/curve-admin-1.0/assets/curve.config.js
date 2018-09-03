// 配置文件
// 服务器的context, 做 ajax 请求的时候, 都加上这个前缀,
// 注意 '/' 都在每段的开头// 这里面可以通过 **同步ajax** 来设置其它的变量
// 在每个页面开头引入这个文件, 便能使用这些变量了
//global var definition
var host = ''
if(config.admin){
    if(config.admin.host){
    	if(config.admin.host){
            host = config.admin.host;
    	}
    }
}
var apiCtx = host;