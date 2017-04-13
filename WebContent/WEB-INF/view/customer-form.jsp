<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Customer Registration Form</title>
</head>
<style>
.error {
	color: red
}
</style>
<body>

	
<div class="container-fluid">
		<i> Fill out the form. Asterisk (*) means required.</i> <br>
</div>		
			<div class="form-group">
				<form:form action="processForm" modelAttribute="customer">
			</div>

			<div class="form-group">
				First name:
				<form:input path="firstName" />
			</div>

			<br>
			<div class="form-group">
				Last name(*):
				<form:input path="lastName" />


				<form:errors path="lastName" cssClass="error" />
			</div>
			<br>

			<div class="form-group">
				Free Passes:
				<form:input path="freePasses" />

				<form:errors path="freePasses" cssClass="error" />
			</div>
			<br>
			
			<div class="form-group">
				Postal Code:
				<form:input path="postalCode" />

				<form:errors path="postalCode" cssClass="error" />
			</div>
			<br>
			
			<div class="form-group">
				Course Code:
				<form:input path="courseCode" />

				<form:errors path="courseCode" cssClass="error" />
			</div>
			<br>
			
			
			<input type="submit" value ="Submit">
			</form:form>

			
	
</body>





</html>