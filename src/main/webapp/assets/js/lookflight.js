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
		  
	});
	
	
	 
	  
		 

})
