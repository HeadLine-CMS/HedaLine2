function filmType(type){
	if (type!=null){
		$.ajax({
			url:"filmType.jsp",
			type:"post",
			data:{"param":type},
			success:function(res){
				$('#home').html(res);
			},
			error:function(){alert('error');}
		});
	}
}