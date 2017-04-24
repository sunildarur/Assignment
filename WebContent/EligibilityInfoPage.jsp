<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cognizant Eligibility Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
function validate2()
{

   if( document.myForm.firstname.value == "" )
   {
      document.getElementById('firstname_error').innerHTML="Please select Account Type";
      document.myForm.firstname.focus() ;
      document.getElementById("firstname").onkeyup = removeWarning;
      return false;
   }
   
   if( document.myForm.middlename.value == "" )
   {
      document.getElementById('middlename_error').innerHTML="Please provide Initial Deposit";
      document.myForm.middlename.focus() ;
      document.getElementById("middlename").onkeyup = removeWarning;
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

 <form method="post" action="EligibilityInfoPage" name="myForm" onsubmit="return(validate2());">
 <fieldset class="applicationposition">
 <Legend style="font-size: 16pt" class="Legend1">Eligibility Information</Legend>
         <table>
            
            <tr>
               <td class="firstname1">Account Type:</td>
               <td><select name="accounttype" id="firstname" style="width: 200px" class="firstname2">
               		<option value="CHECKING ACCOUNT">CHECKING ACCOUNT</option>
					<option value="SAVINGS ACCOUNT">SAVINGS ACCOUNT</option>
					<option value="IRA">IRA</option>
					<option value="MONEY MARKET">MONEY MARKET</option>
					</select>
               <span id="firstname_error" class="firstname4"></span>
               </td>
            </tr>
             <tr>
               <td class="middlename1">Initial Deposit:</td>
               <td><input type="text" id="middlename" name="initialdeposit" style="width: 200px" class="middlename2"/>
               <span id="middlename_error" class="middlename3"></span>
               </td>
            </tr>
            <tr>
               <td class="lastname1">Direct Deposit of $500 min monthly:</td>
               <td><input type="radio" name="directdeposit" value="1" class="yesbutton1" checked="checked"/></td>
               <td class="yesbuttonvalue1">Yes</td>
               <td><input type="radio" name="directdeposit" value="0" class="nobutton1"/></td>
               <td class="nobuttonvalue1">No</td>
            </tr>
            <tr>
               <td class="address1">Debit Card Type(VISA/Master/AMEX):</td>
               <td><select name="debitcard" id="address" style="width: 200px" class="address2">
					<option value="VISA">VISA</option>
					<option value="Master">Master</option>
					<option value="AMEX">AMEX</option>
					</select> 
               <span id="address_error" class="address3"></span>
               </td>
            </tr>
             <tr>
               <td class="addressline1">Loan Amount Required (in $):</td>
               <td><select name="loanamount" id="city" style="width: 200px" class="addressline2">
					<option value="5000">5000</option>
					<option value="10000">10000</option>
					<option value="15000">15000</option>
					<option value="25000">25000</option>
					</select> 
               <span id="city_error" class="city4"></span>
               </td>
             </tr>
             <tr>
               <td class="city1">Credit Score:</td>
               <td><select name="creditscore" id="state" style="width: 200px" class="city2">
					<option value="Bad">Bad</option>
					<option value="Fair">Fair</option>
					<option value="Good">Good</option>
					<option value="Excellent">Excellent</option>
					</select> 
               <span id="state_error" class="address3"></span>
               </td>
             </tr>
                <tr>
                    <td><input type="submit" id="next1" value="Next" style="width: 100px" class="box6"/></td>
                </tr>
                 <tr>
                    <td><input type="button" id="previous" value="Previous" style="width: 100px" class="box5" onclick="javascript:history.go(-1)"/></td>
                </tr>
            </table>
            </fieldset>
    </form>
</body>
</html>