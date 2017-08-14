<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
    <script>
        function Validation()
        {

            var fname = document.forms["customerinfo"]
                ["firstname"].value;
            var lname = document.forms["customerinfo"]
            ["lastname"].value;
            var useremail = document.forms["customerinfo"]
            ["email"].value;
            var number = document.forms["customerinfo"]
            ["phonenumber"].value;
            var userpassword = document.forms["customerinfo"]
            ["password"].value;

            if(fname == "")
            {
                alert("You must enter your first name in order to register.");
                return false;
            }

            if(lname == "")
            {
                alert("You must enter your last name in order to register.");
                return false;
            }
            if(useremail == "")
            {
                alert("You need to enter an email in order to register.");
                return false;
            }
            if(!useremail.includes('@'))
            {
                alert("Sorry... you did not enter a valid email address.");
                return false;
            }

            if(fname.length <= 2 || lname.length <= 2 || useremail.length <= 2)
            {
                alert("Input must be longer than 2 characters")
                return false;
            }
        }


    </script>
    </head>
    <body>




    ${inst}
    <form name = "customerinfo" action="formhandler" onsubmit="return Validation()" method = "post">

        First Name: <input type = "text" name = "firstname"><br>
        Last Name: <input type ="text" name ="lastname"><br>

        <br>

        <input type="radio" name="gender" value="male"> Male<br>
        <input type="radio" name="gender" value="female"> Female<br>

        <br>

    Email: <input type ="text" name = "email"><br>
    Phone Number: <input type = "number" name = "phonenumber"><br>
    Password: <input type = "password" name = "password"required><br>

    <input type = "submit" name = "submit" values ="Submit">

    </form>



</body>
</html>
