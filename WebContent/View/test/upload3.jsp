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
		<img alt="Image" scr="" id="target" width="auto" height="150px"/>
		<br /><br />
		<input type="button" value="Upload" id="btnUpload"/>
	</form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script> 	
	<script>
		function checkValidTypeFile() {
			var file = document.querySelector("input[type=file]").files[0];

			var allowed_file_types = ['image/png', 'image/gif', 'image/jpeg', 'image/pjpeg']; //allowed file types
			
			if (allowed_file_types.indexOf(file.type) === -1) {
				return false;
			}
			else {
				return true;
			}
		}
		
		function loadImage() {
			
			if(checkValidTypeFile()) {
				var target = document.querySelector("img");
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
				alert("file khong hop le!");
			}
		}
		
		$('#btnUpload').click(function(e){
			e.preventDefault();
			if(checkValidTypeFile()) {
				var form_data = new FormData('#upload_form'); //Creates new FormData object
				var post_url = $('#upload_form').attr("action");
				console.log(form_data);
				// jQuery Ajax to Post form data
 				$.ajax({
					url: post_url,
					type: "POST",
					data: form_data,
	                processData: false,
					contentType: false,
					mimeType: "multipart/form-data"
				});
			}
			else {
				console.log("file ko hop le!");
			}
		});
	</script>
</body>
</html>