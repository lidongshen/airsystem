layui.use('table', function() {
	var table = layui.table;

	table.render({
		elem : '#demo',
		height : 312,
		url:'fseach',
		page:true,
		cellMinWidth : 80,
		method:'post',
		cols : [ [ // 表头
		{
			type : 'numbers'
		}, {
			type : 'checkbox'
		}, {
			field : 'fId',
			title : 'ID',
			width : 80,
			sort : true,
			unresize : true,
		}, {
			field : 'fName',
			title : '飞机名称',
			unresize : true,
			width : 110,
		}, {
			field : 'fFromcity',
			title : '始发地',
			width : 100,
		}, {
			field : 'fTocity',
			title : '目的地',
			unresize : true,
			width : 100,
		}, {
			field : 'fMoney',
			title : '价钱',
			sort : true,
			unresize : true,
		}, {
			field : 'fSeatnum',
			title : '座位数',
			unresize : true,
			sort : true
		}, {
			field : 'fStarttime',
			title : '起飞时间',
			sort : true,
			unresize : true,
			width : 160,
			templet: '#dateTpl'
		}, {
			field : 'fEndtime',
			title : '到达时间',
			sort : true,
			unresize : true,
			width : 200,
			templet: '#dateTpl'
		}, {
			fixed : 'right',
			title : '操作',
			toolbar : '#barDemo',
			unresize : true,
			width : 150
		} ] ],
		parseData: function(res){ //res 即为原始返回的数据
			console.log(res)
		    return {
		        "code": 0, //解析接口状态
		        "msg":"", //解析提示文本
		        "count": 3, //解析数据长度
		        "data": res//解析数据列表
		      };
		    }
		
		 
		
	});

});