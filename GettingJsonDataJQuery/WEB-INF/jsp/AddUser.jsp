<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<script src="/GettingJsonDataJQuery/js/jquery.js"></script>
<script type="text/javascript">
function doAjaxPost() {  
	  // get the form values  
	  var name = $('#name').val();
	  var education = $('#education').val();
	   
	  $.ajax({  
	    type: "POST",  
	    url: "/GettingJsonDataJQuery/AddUser.htm",  
	    data: "name=" + name + "&education=" + education,  
	    success: function(response){
	      // we have the response 
	      if(response.status == "SUCCESS"){
	    	  $('#info').html("User has been added to the list successfully.<br>"+ 
	    	  "The User Details are as follws : <br> Name : "
	    	  + response.result.name + " <br> Education : " + response.result.education);
	    	  $('#name').val('');
		      $('#education').val('');
	      }else{
	    	  $('#info').html("Sorry, there is some thing wrong with the data provided.");
	      }	      
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  
</script>
</head>
<body>
<h1>Add Users using Ajax ........</h1>
	<table>
		<tr><td>Enter your name : </td><td> <input type="text" id="name"><br/></td></tr>
		<tr><td>Education : </td><td> <input type="text" id="education"><br/></td></tr>
		<tr><td colspan="2"><input type="button" value="Add Users" onclick="doAjaxPost()"><br/></td></tr>
		<tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
	</table>
	<a href="/GettingJsonDataJQuery/ShowUsers.htm">Show All Users</a>
</body>
</html>