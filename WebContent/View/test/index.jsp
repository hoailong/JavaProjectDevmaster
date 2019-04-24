<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Upload file vs Ajax</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-body">
				<form method="POST" role="form" enctype="multipart/form-data" id="formID">
					<legend>Upload</legend>

					<div class="form-group">
						<label for="file">Chọn file</label> <input id="file" type="file"
							name="sortpic" required="" />
					</div>
					<div class="form-group">
						<button id="upload" class="btn btn-primary">Upload</button>
					</div>
				</form>
				<div class="status alert alert-success"></div>
			</div>
		</div>
	</div>
	<script>
		//xử lý khi có sự kiện click
		$('#upload').on('click', function() {
			//Lấy ra files
			var file_data = $('#file').prop('files')[0];
			//lấy ra kiểu file
			var type = file_data.type;
			//Xét kiểu file được upload
			var match = [ "image/gif", "image/png", "image/jpeg", ];
			alert("type " + type);
			//kiểm tra kiểu file
			if (type == match[0] || type == match[1] || type == match[2]) {

				
				//khởi tạo đối tượng form data
				var form = $('#formID')[0];
				console.log(form);
				var form_data = new FormData(form);
				//thêm files vào trong form data
				form_data.append('file', file_data);
				console.log(form_data);
				//sử dụng ajax post
				 $.ajax({
					url : 'UploadFileServlet', // gửi đến file upload.php 
					dataType : 'text',
					data : form_data,
					type : 'post',
					 beforeSend: function(){
						 alert("bf");
					   },
					success : function(res) {
						$('.status').text(res);
						$('#file').val('');
						
						alert("ok");
					},
					error : function(error) {
						alert("loi");
					}
				}); 
			} else {
				$('.status').text('Chỉ được upload file ảnh');
				$('#file').val('');
				console.log("Chỉ được upload file ảnh");
			}
			return false;
		});
	</script>
</body>
</html>