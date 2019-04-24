<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload multiple file</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" id="upload_form">
		<input type="file" name="file" id="file" onchange="loadImage()"/>
		<br />
		<img alt="Image" src="" id="target" width="auto" height="150px"/>
		<br /><br />
		<input type="button" value="Upload" id="btnUpload"/>
	</form>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script> -->   
    
	<jsp:include page="../../admin/common/tablibsfooter.jsp"></jsp:include>
	<script>
		function checkValidTypeFile() {
			var file = document.querySelector("input[type=file]").files[0];
			var allowed_file_types = ['image/png', 'image/gif', 'image/jpeg', 'image/pjpeg']; //allowed file types
			if (allowed_file_types.indexOf(file.type) === -1) {
				return false;
			}
			return true;
		}
	
		function loadImage() {
			var target = document.querySelector("img");
			if(checkValidTypeFile()) {
				var file = document.querySelector("input[type=file]").files[0];
				var reader = new FileReader();

				reader.onloadend = function() {
					target.src = reader.result;
				};

				if(file) {
					reader.readAsDataURL(file);
				} else {
					target.src = "";
				}
			}
			else {
				alert("File không hợp lệ!");
				target.src = "";
			}
		}
		
		$('#btnUpload').click(function(e){
			e.preventDefault();
			if(checkValidTypeFile()) {
				var form = $("#upload_form")[0];
				var form_data = new FormData(form); //Creates new FormData object
				var post_url = "<%=request.getContextPath()%>/uploadfile";
				 //jQuery Ajax to Post form data
				$.ajax({
					url: post_url,
					type: "POST",
					data: form_data,
					contentType: false,
	                processData: false,
					mimeType: "multipart/form-data"
				}).done(function (res) { 
	            	console.log("upload image success");
	            });
			} else {
				console.log("file ko hop le!");
			}
		});
	</script>
</body>
</html>