<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cognizant Income Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
function validate1()
{

   if( document.myForm.firstname.value == "" )
   {
      document.getElementById('firstname_error').innerHTML="Please enter your SSN Number";
      document.myForm.firstname.focus() ;
      document.getElementById("firstname").onkeyup = removeWarning;
      return false;
   }
   
   if( document.myForm.middlename.value == "" )
   {
      document.getElementById('middlename_error').innerHTML="Please select Income Mode";
      document.myForm.middlename.focus() ;
      document.getElementById("middlename").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.lastname.value == "" )
   {
      document.getElementById('lastname_error').innerHTML="Please enter your Annual Income";
      document.myForm.lastname.focus() ;
      document.getElementById("lastname").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.houserentown.value == "" )
   {
      document.getElementById('address_error').innerHTML="Please select House Mode";
      document.myForm.houserentown.focus() ;
      document.getElementById("address").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.city.value == "" )
   {
      document.getElementById('city_error').innerHTML="Please enter your Rent";
      document.myForm.city.focus() ;
      document.getElementById("city").onkeyup = removeWarning;
      return false;
   }
   return( true );
}

function removeWarning() {
document.getElementById(this.id + "_error").innerHTML = "";
}


</script>
</head>
<body bgcolor="#408080">

<img class="imageposition" src="http://www.pmbl-ng.com/images/about.jpg" style="width:100px;height:100px;">

 <form method="post" action="IncomePage" name="myForm" onsubmit="return(validate1());">
 <fieldset class="applicationposition">
 <Legend id="incpage" style="font-size: 16pt" class="Legend1">Income Information</Legend>
         <table>
            
            <tr>
               <td class="firstname1">SSN Number:</td>
               <td><input type="text" id="firstname" name="ssnnumber" style="width: 200px" class="firstname2"/>
               <span id="firstname_error" class="firstname4"></span>
               </td>
            </tr>
             <tr>
               <td class="middlename1">Mode of Income:</td>
               <td><select name="modeofincome" id="middlename" style="width: 200px" class="middlename2">
               		<option value="Salaried">Salaried</option>
					<option value="Business">Business</option>
					<option value="SelfEmployment">SelfEmployment</option>
					<option value="Other">Other</option>
					</select>
               <span id="middlename_error" class="middlename3"></span>
               </td>
            </tr>
            <tr>
               <td class="lastname1">Annual Income:</td>
               <td><input type="text" id="lastname" name="annualincome" style="width: 200px" class="lastname2"/>
               <span id="lastname_error" class="lastname4"></span>
               </td>
            </tr>
            <tr>
               <td class="address1">House Rent/Own:</td>
               <td><select name="houserentown" id="address" style="width: 200px" class="address2">
					<option value="Rent">Rent</option>
					<option value="Own">Own</option>
					</select> 
               <span id="address_error" class="address3"></span>
               </td>
            </tr>
             <tr>
               <td class="addressline1">Rent/Lease Amount:</td>
               <td><input type="text" id="city" name="rentleaseamount" style="width: 200px" class="addressline2"/>
               <span id="city_error" class="city4"></span>
               </td>
            </tr>
                <tr>
                    <td><input type="submit" id="next1" value="Next" style="width: 100px" class="box4"/></td>
                </tr>
                 <tr>
                    <td><input type="button" id="previous" value="Previous" style="width: 100px" class="box3" onclick="javascript:history.go(-1)"/></td>
                </tr>
            </table>
            </fieldset>
    </form>
</body>
</html>