<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form method="POST" action="saveUser" enctype="multipart/form-data">
		<div>
			<label>Name :</label> <input type="text" name="name"
				required="required" />
		</div>

		<div>
			<label>Email ID :</label> <input type="text" name="email_id"
				required="required" />
		</div>

		<div>
			<label>Password :</label> <input type="text" name="password"
				required="required" />
		</div>

		<div>
			<label> Mobile No. :</label> <input type="text" name="mobileno"
				required="required" />
		</div>

		<div>
			<label> Image :</label> <input type="file" name="profileImage" />
		</div>
		
		<div>
			<input type="submit" value="SUBMIT" />
		</div>
	</form>
</body>
</html>