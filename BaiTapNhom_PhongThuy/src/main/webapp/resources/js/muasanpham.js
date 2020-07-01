$(document).ready(function() {
	$("#muahang").on('click',function(event) {
		event.preventDefault();
		$.ajax({
			contentType:'application/json;charset=UTF-8',
			url : 'mua',
			type : 'post',
			success : function(data, textStatus, jqXHR) {
				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("Có lỗi xảy ra thử lại");
			},
			processData : false,
		})
	});
})