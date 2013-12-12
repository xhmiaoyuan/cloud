
<!DOCTYPE    html    PUBLIC    "-//W3C//DTD     XHTML    1.0    Transitional//EN"
"http://www.w3.org/tr/xhtmll/DTD/xhtmll-transtional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<body>
	<div id="formwrapper">
		<h3>User register</h3>
		<form action="RegisterController" method="post" name="apForm"
			id="apForm">
			<fieldset>
				Register
				<div>
					<label for="Name">Username</label> <input type="text" name="name"
						id="Name" size="20" maxlendth="30" /> <br />
				</div>
				<div>
					<label for="Email">Email</label> <input type="text" name="email"
						id="Email" size="20" maxlength="150" /> <br />
				</div>
				<div>
					<label for="password">password</label> <input type="password"
						name="password" size="18" maxlength="15" /><br />
				</div>
				<div>
					<select name="country" id="selectAge">
						<option value="Bangladesh">Bangladesh</option>
						<option value="Cambodia">Cambodia</option>
						<option value="Malaysia">Malaysia</option>
						<option value="Japan">Japan</option>
						<option value="The USA">The USA</option>
						<option value="The UK">The UK</option>
						<option value="Thailand">Thailand</option>
						<option value="France">France</option>
						<option value="Belgium">Belgium</option>
						<option value="Germany">Germany</option>
						<option value="China">China</option>

					</select>
				</div>
				<div class="enter">
					<input name="create" type="submit" class="button" value="Submit" />
					<input name="Submit" type="reset" class="button" value="Reset" />
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>