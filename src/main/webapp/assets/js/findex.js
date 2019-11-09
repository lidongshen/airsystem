layui.use('table',function() {
		var table = layui.table;
		table.render({
				elem : '#demo',
				height : 500,
				url : 'fseach',
				page : true,
				toolbar : '#toolbarDemo',
				cellMinWidth : 80,
				method : 'post',
				cols : [ [ // 表头
						{
							type : 'numbers'
						},
						{
							type : 'checkbox'
						},
						{
							field : 'fId',
							title : 'ID',
							sort : true,
							unresize : true,
						},
						{
							field : 'fName',
							title : '飞机名称',
							unresize : true,
							width:180
						},
						{
							field : 'fFromcity',
							title : '始发地',
						},
						{
							field : 'fTocity',
							title : '目的地',
							unresize : true,
						},
						{
							field : 'fMoney',
							title : '价钱',
							sort : true,
							unresize : true,
						},
						{
							field : 'fSeatnum',
							title : '座位数',
							unresize : true,
							sort : true,
						},
						{
							field : 'fStarttime',
							title : '起飞时间',
							sort : true,
							unresize : true,
							templet : '<div>{{ layui.util.toDateString(d.fStartdate,"HH:mm:ss") }}</div>'
						},
						{
							field : 'fEndtime',
							title : '到达时间',
							sort : true,
							unresize : true,
							templet : '<div>{{ layui.util.toDateString(d.fEnddate,"HH:mm:ss") }}</div>'
						}, {
							title : '操作',
							fixed:'right',
							toolbar : '#barDemo',
							unresize : true,
							width : 200,
							
						} ] ],
				parseData : function(res) { // res 即为原始返回的数据
					return {
						"code" : 0, // 解析接口状态
						"msg" : "", // 解析提示文本
						"count" : res.total, // 解析数据长度
						"data" : res.data
					// 解析数据列表
					};
				}
			});

	table.on('tool(flight)', function(obj) {
		var data = obj.data; // 获得当前行数据
		var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的event 参数对应的值）
		var tr = obj.tr; // 获得当前行 tr 的 DOM 对象（如果有的话）
		if (layEvent === 'del') { // 删除
			layer.confirm('您确认删除本次航班吗？', {shade: [0.8, '#393D49'], shadeClose:true,},function(index) {
				// 向服务端发送删除指令
				$.ajax({
					url:'del',
					data:{'fId' : data.fId},
					type:'post',
					success:function(e){
						console.log(e)
						if(e=='ok'){
							layer.msg('删除成功', {
								  icon: 1,
								  shadeClose:true,
								  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
								},function(){
									obj.del();
									table.reload('demo', {
										url: 'fseach'
									}); 
							});
						}else{
							layer.msg('删除失败', {
								  icon: 2,
								  titl:false,
								  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
							}); 
						}
					}
				})
				layer.close(index);
			});
		} else if (layEvent === 'detail') { // 查看
			layer.open({
				  type: 2,
				  title:'航班信息',
				  content: 'lookflight',
				  shade: [0.8, '#393D49'],
				  shadeClose:true,
				  move:false,
				  anim:2,
				  area: ['850px','400px'],
				  resize:false,
				  zIndex: layer.zIndex, //重点1
				  success: function(layero){
				    layer.setTop(layero); //重点2
				  }
			});  
		}else if(layEvent === 'edit'){
			 layer.msg('编辑');
		}
	});
	
	table.on('toolbar(flight)', function(obj){
		  var checkStatus = table.checkStatus(obj.config.id);
		  switch(obj.event){
		    case 'add':
		    	layer.open({
					  type: 2,
					  title:'航班信息',
					  content: 'lookflight',
					  shade: [0.8, '#393D49'],
					  shadeClose:true,
					  move:false,
					  anim:2,
					  area: ['850px','400px'],
					  resize:false,
					  zIndex: layer.zIndex, //重点1
					  success: function(layero){
					    layer.setTop(layero); //重点2
					  }
				});  
		    break;
		    case 'delete':
		      layer.msg('删除');
		    break;
		  };
	});
	
	table.on('checkbox(flight)', function(obj){
		  console.log(obj.checked); //当前是否选中状态
		  console.log(obj.data); //选中行的相关数据
		  console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
	});
});

	  
