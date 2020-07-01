$(document).ready(
		function() {
			$("#tinh").on(
					'change',
					function(event) {
						var b = $("#tinh option:selected").val();
						var Huyen = {};
						Huyen.id = b;
						$.ajax({
							contentType : 'application/json;charset=UTF-8',
							url : 'getHuyen',
							type : 'post',
							data : JSON.stringify(Huyen),
							success : function(response) {
								var c = response.split(",");
								console.log(c);
								$('#huyen option').remove();
								$.each(c, function(index, value) {
									var tach = value.split(":");
									jQuery('#huyen').append(
											$("<option></option>").attr(
													"value", tach[0]).text(
													tach[1]));
								});

							},
							error : function(result) {
								console.log(result);
							},
							processData : false

						})
					});

			$("#huyen").on(
					'change',
					function(event) {
						var b = $("#huyen option:selected").val();
						var Xa = {};
						Xa.quanhuyenid = b;
						$.ajax({
							contentType : 'application/json;charset=UTF-8',
							url : 'getXa',
							type : 'POST',
							data : JSON.stringify(Xa),
							success : function(response) {
								var c = response.split(",");
								console.log(c);
								$('#xa option').remove();
								$.each(c, function(index, value) {
									jQuery('#xa').append(
											$("<option></option>").attr(
													"value", index).text(
													c[index]));
								});

							},
							error : function(result) {
								console.log(result);
							},
							processData : false

						})
					});

			$("#themdc").on('click', function(event) {
				event.preventDefault();
				var thanhpho = $("#tinh option:selected").text();
				var quan = $("#huyen option:selected").text();
				var phuong = $("#xa option:selected").text();
				var duong = $("#duong").val();
				var sonha = $("#nha").val();
				var DiaChi = {};
				DiaChi.thanhpho = thanhpho;
				DiaChi.quan = quan;
				DiaChi.phuong = phuong;
				DiaChi.duong = duong;
				DiaChi.sonha = sonha;
				$.ajax({
					contentType : 'application/json;charset=UTF-8',
					url : 'themDiaChi',
					type : 'POST',
					data : JSON.stringify(DiaChi),
					success : function(response) {
						console.log(response);
						swal({
							icon: "success",
						    title: "Thêm địa chỉ thành công",
						    text: "",
						    type: "success"
						}).then(function() {
						    window.location = "shipping";
						});
					},
					error : function(result) {
						console.log(result);
					},
					processData : false

				})
				
			});
			
			
			$(".btn-giao").on('click', function(event) {
				var value =  $(event.target).attr('value');
				$('<form action="payment" method="post"><input type="hidden" name="name" value='+value+'></input></form>').appendTo('body').submit().remove();
				
			});
		})