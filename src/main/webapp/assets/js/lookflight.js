$(function(){
	
	layui.use(['laydate','form'], function(){
		  var form = layui.form;
		  var laydate = layui.laydate;
		  laydate.render({
			  elem:'#fEnddate',
			  type:'datetime',
			  format:'yyyy-MM-dd HH:mm:ss',
			  trigger: 'click',
			  theme:'molv'
		  });
		  laydate.render({
			  elem:'#fStartdate',
			  type:'datetime',
			  format:'yyyy-MM-dd HH:mm:ss',
			  trigger: 'click',
			  theme:'molv',
		  });
		  
		  
		  /*form.val("flight1", { 
		  "fId": 1
		  ,"fName": "女"
		  ,"fMoney": 3
		  ,"fSeatnum": 123
		  ,"fFromcity": 'fd'
		  ,"fTocity": "我爱layui"
		  ,"fStartdate":"132"
		  ,"fEnddate":'123'
		});*/
		  
	});
	
	
	 
	  
		 

})
