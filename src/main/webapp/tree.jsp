<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>导航树</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<style type="text/css">@import url('components/dtree/dtree.css');</style>
	<script type="text/javascript">var dtreeIconBasePath = "components/dtree";</script>
	<script language="javascript" src="components/dtree/dtree.js"></script>
</head>
<body>
<script type="text/javascript"> 
var treeMenu = [
    { level:1, name:"菜单管理"},
    { level:2, name:"新增菜单", ico:"images/icon_default.gif",link:"menu"},
    { level:2, name:"菜单列表", ico:"images/icon_default.gif",link:"menulist"},
    { level:2, name:"导入菜单", ico:"images/icon_default.gif",link:"menu/importexcle"},
//     { level:2, name:"菜单查询接口", ico:"images/icon_default.gif",link:"queryMenu?storeId=1"},
    { level:1, name:"菜单类型管理"},
    { level:2, name:"新增菜单类型", ico:"images/icon_default.gif",link:"menutype/menutype"},
    { level:2, name:"菜单类型列表", ico:"images/icon_default.gif",link:"menutype/menutypelist"},
//     { level:2, name:"类型列表接口", ico:"images/icon_default.gif",link:"queryMenuType?storeId=1"},
//     { level:1, name:"操作员管理"},
//     { level:2, name:"新增操作员", ico:"images/icon_default.gif",link:"operater/operater"},
//     { level:2, name:"操作员列表", ico:"images/icon_default.gif",link:"operater/operaterlist"},
//     { level:2, name:"操作员接口", ico:"images/icon_default.gif",link:"queryAllOperater?storeId=1"},
//     { level:1, name:"餐桌管理"},
//     { level:2, name:"新增餐桌", ico:"images/icon_default.gif",link:"table/table"},
//     { level:2, name:"餐桌列表", ico:"images/icon_default.gif",link:"table/tablelist"},
//     { level:2, name:"餐桌列表接口", ico:"images/icon_default.gif",link:"table?storeId=1"},
    { level:1, name:"订单管理"},
    { level:2, name:"订单结算", ico:"images/icon_default.gif",link:"querycurrentorder"},
    { level:2, name:"查询某桌全部订单", ico:"images/icon_default.gif",link:"order/queryallorderbytable"},
    { level:2, name:"查询全部订单", ico:"images/icon_default.gif",link:"order/allorder"},
//     { level:2, name:"添加订单接口", ico:"images/icon_default.gif",link:"addorder?dishes=1:,2:2,3:3&&table=1&&headcount=10&&operaterIds=1001"},
//     { level:2, name:"查询当前订单接口", ico:"images/icon_default.gif",link:"queryordervo?table=1"},
//     { level:2, name:"订单加菜接口", ico:"images/icon_default.gif",link:"updateorder?dishes=5:1&&orderId=101&&headcount=15&&operaterIds=1002"},
    { level:1, name:"数据统计"},
    { level:2, name:"今日销售额", ico:"images/icon_default.gif",link:"todaycount"},
    { level:2, name:"销售额走势图", ico:"images/icon_default.gif",link:"data/data"},
	/*{ level:1, name:"用户管理"},
	{ level:2, name:"用户列表", ico:"images/icon_default.gif",link:"user_list.html"},
	{ level:2, name:"角色管理"},
	{ level:3, name:"角色列表", ico:"images/icon_default.gif",link:"role_list.html"},
	{ level:3, name:"用户角色", ico:"images/icon_default.gif",link:"ur_list.html"},
	{ level:1, name:"信息管理"},
	{ level:2, name:"新闻管理", ico:"images/icon_default.gif",link:"news_list.html"},
	{ level:2, name:"公告管理", ico:"images/icon_default.gif",link:"bulletin_list.html"},
	{ level:1, name:"系统邮件", ico:"images/icon_default.gif"},
	{ level:1, name:"网络文件", ico:"images/icon_default.gif",link:"complaint_list.html"}*/
];
</script>
<style>
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#menuControll{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0 10px;
	font-size:14px;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
</style>
<div id="menuControll">
菜单控制:【<a href="#" onclick="tree.openAll();this.blur();return false;" style="color:#333333;text-decoration:none">展开</a>】
【<a href="#" onclick="tree.closeAll();this.blur();return false;" style="color:#333333;text-decoration:none">折叠</a>】
</div>
<div class="dtree" style="margin:10px;">
<script type="text/javascript"> 
//建立新树
tree = new dTree('tree');
tree.config.target = "MainFrame";
tree.config.useCookies = false;
var selNum = -1;
var link = "";
//根目录
tree.add(0,-1,'管理中心', null, null, null, '', '');
var count = 0;
var pLevelIdArray = new Array();
pLevelIdArray[1] = 0;
var currLevel = 1;
for (var i=0; i<treeMenu.length; i++) {
	var item = treeMenu[i];
	var itemLevel = item.level;
	pLevelIdArray[itemLevel+1] = ++count;
	if (item.link!=null && item.link!="") {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link);
		}
	} else {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, null, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name);
		}
	}
	if (item.select) {
		selNum = count;
		link = item.link;
	}
}
document.write(tree);
tree.openAll();
if (selNum != -1) {
	tree.openTo(selNum,true);
	top.document.frames["MainFrame"].location.href=link;
}
</script>
</div>
</body>
</html>