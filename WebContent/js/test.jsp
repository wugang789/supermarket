<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="ddaccordion.js"></script>
<script type="text/javascript">

</script>
<script type="text/javascript">
//Initialize Arrow Side Menu:
ddaccordion.init({
	headerclass: "menuheaders", //Shared CSS class name of headers group
	contentclass: "menucontents", //Shared CSS class name of contents group
	revealtype: "clickgo", //Reveal content when user clicks or onmouseover the header? Valid value: "click", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content.
	onemustopen:false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["unselected", "selected"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["none", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: 500, //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
});
</script>
<style type="text/css">
.arrowsidemenu { width: 180px; margin:0 auto; /*width of menu*/ border-style: solid solid none solid; border-color: #94AA74; border-size: 1px; border-width: 1px; }
.arrowsidemenu div a { /*header bar links*/ font: bold 12px Verdana, Arial, Helvetica, sans-serif; display: block; background: transparent url(arrowgreen.gif) 100% 0; height: 24px; /*Set to height of bg image-padding within link (ie: 32px - 4px - 4px)*/ padding: 4px 0 4px 10px; line-height: 24px; /*Set line-height of bg image-padding within link (ie: 32px - 4px - 4px)*/ text-decoration: none; }
.arrowsidemenu div a:link, .arrowsidemenu div a:visited { color: #26370A; }
.arrowsidemenu div a:hover { background-position: 100% -32px; }
.arrowsidemenu div.unselected a { /*header that's currently not selected*/ color: #6F3700; }
.arrowsidemenu div.selected a { /*header that's currently selected*/ color: blue; background-position: 100% -64px !important; }
.arrowsidemenu ul { list-style-type: none; margin: 0; padding: 0; }
.arrowsidemenu ul li { border-bottom: 1px solid #a1c67b; }
.arrowsidemenu ul li a { /*sub menu links*/ display: block; font: normal 12px Verdana, Arial, Helvetica, sans-serif; text-decoration: none; color: black; padding: 5px 0; padding-left: 10px; border-left: 10px double #a1c67b; }
.arrowsidemenu ul li a:hover { background: #d5e5c1; }
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
</head>
<body>
<div class="arrowsidemenu">
  
  <div class="menuheaders" id="31"><a href="" title="CSS" id="1" onclick="show(1,31,121)">员工信息管理</a></div>
  <ul class="menucontents" id="121">
   
  </ul>
  
  <div class="menuheaders" id="32"><a href="" title="CSS" id="2" onclick="show(2,32,122)">商品信息管理</a></div>
  <ul class="menucontents" id="122">
   
  </ul>
  
  <div class="menuheaders" id="33"><a href="" title="CSS" id="3" onclick="show(3,33,123)">商品采购管理</a></div>
  <ul class="menucontents" id="123">
   
  </ul>
  
  <div class="menuheaders" id="34"><a href="" title="CSS" id="4" onclick="show(4,34,124)">商品销售管理</a></div>
  <ul class="menucontents" id="124">
   
  </ul>
  
  <div class="menuheaders" id="35"><a href="" title="CSS" id="5" onclick="show(5,35,125)">库存管理</a></div>
  <ul class="menucontents" id="125">
   
  </ul>
  
  <div class="menuheaders" id="36"><a href="" title="CSS" id="6" onclick="show(6,36,126)">系统管理</a></div>
  <ul class="menucontents" id="126">
   
  </ul>
  
</div>
</body>
</html>