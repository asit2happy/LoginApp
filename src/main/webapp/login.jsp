<%@taglib   uri="http://www.springframework.org/tags/form"   prefix="form"%>

<form:form    action="checkLogin.form"   method="post"    modelAttribute="loginCmd">
 <table>
    <tr>
     <td> Username:  </td>  <td><form:input   path="username"/> </td>  <td> <form:errors  path="username"/> </td>
    </tr>
    
    <tr> 
        <td>Password: </td> <td> <form:password  path="password"/> </td> <td> <form:errors  path="password"/></td>
    </tr>    
    
    <tr>
       <td  colspan="3"  align="center">    
                <input  type=submit   value="Login">
       </td>
    </tr>       
  </table>                       
</form:form>


    