<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cognizant Application Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
function validate()
{

   if( document.myForm.firstname.value == "" )
   {
      document.getElementById('firstname_error').innerHTML="Please enter your First Name";
      document.myForm.firstname.focus() ;
      document.getElementById("firstname").onkeyup = removeWarning;
      return false;
   }
   
   if( document.myForm.lastname.value == "" )
   {
      document.getElementById('lastname_error').innerHTML="Please enter your Last Name";
      document.myForm.lastname.focus() ;
      document.getElementById("lastname").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.addressline1.value == "" )
   {
      document.getElementById('address_error').innerHTML="Please enter your Address";
      document.myForm.addressline1.focus() ;
      document.getElementById("address").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.city.value == "" )
   {
      document.getElementById('city_error').innerHTML="Please enter your City";
      document.myForm.city.focus() ;
      document.getElementById("city").onkeyup = removeWarning;
      return false;
   }
   if( document.myForm.state.value == "" )
   {
      document.getElementById('state_error').innerHTML="Please enter your State";
      document.myForm.state.focus() ;
      document.getElementById("state").onkeyup = removeWarning;
      return false;
   }
   
   if( document.myForm.zipcode.value == "")
   {
      document.getElementById('zipcode_error').innerHTML="Your Zip Code must be 5 characters </br> Please enter your First Name";
      document.myForm.zipcode.focus() ;
      document.getElementById("zipcode").onkeyup = removeWarning;
      return false;
   }
   if(document.myForm.zipcode.value.length != 5 )
   {
   document.getElementById('zipcode_error').innerHTML="Your Zip Code must be 5 characters";
      document.myForm.zipcode.focus() ;
      document.getElementById("zipcode").onkeyup = removeWarning;
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

 <form method="post" action="ApplicationInformationPage" name="myForm" onsubmit="return(validate());">
 <fieldset class="applicationposition">
 <Legend id="appinfo" style="font-size: 16pt" class="Legend1">Applicant Information</Legend>
         <table>
            
            <tr>
               <td class="firstname1">First Name:</td>
               <td><input type="text" id="firstname" name="firstname" style="width: 200px" class="firstname2"/>
               <span id="firstname_error" class="firstname3"></span>
               </td>
            </tr>
             <tr>
               <td class="middlename1">Middle Name:</td>
               <td><input type="text" id="middlename" name="middlename" style="width: 200px" class="middlename2"/>
               </td>
            </tr>
            <tr>
               <td class="lastname1">Last Name:</td>
               <td><input type="text" id="lastname" name="lastname" style="width: 200px" class="lastname2"/>
               <span id="lastname_error" class="lastname3"></span>
               </td>
            </tr>
            <tr>
               <td class="address1">Address Line 1:</td>
               <td><input type="text" id="address" name="addressline1" style="width: 200px" class="address2"/>
               <span id="address_error" class="address3"></span>
               </td>
            </tr>
             <tr>
               <td class="addressline1">Address Line 2:</td>
               <td><input type="text" id="addressline2" name="addressline2" style="width: 200px" class="addressline2"/>
               </td>
            </tr>
             <tr>
               <td class="city1">City:</td>
               <td><input type="text" id="city" name="city" style="width: 200px" class="city2"/>
               <span id="city_error" class="city3"></span>
               </td>
            </tr>
             <tr>
               <td class="state1">State:</td>
               <td><input type="text" id="state" name="state" style="width: 200px" class="state2"/>
               <span id="state_error" class="state3"></span>
               </td>
            </tr>
             <tr>
               <td class="zipcode1">Zip Code:</td>
               <td><input type="text" id="zipcode" name="zipcode" style="width: 100px" class="zipcode2"/>
               <span id="zipcode_error" class="zipcode3"></span>
               </td>
            </tr>
               <tr>
                    <td><input type="submit" id="next" value="Next" style="width: 100px" class="box2"/></td>
                </tr>
            </table>
            </fieldset>
    </form>
</body>
</html>