<%@ taglibprefix="sf"uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create new Person</h2>
<sf:form method="POST" modelAttribute="person">
<fieldset>
<tablecellspacing="0">
<tr>
<th><label for="firstName">First Name:</label></th>
<td><sf:input path="firstName"size="15"id="firstName"/></td>
</tr>
<tr>
<th><label for="lastName">Last Name:</label></th>
<td><sf:input path="lastName"size="15"maxlength="15"
id="lastName"/>
</td>
</tr>
<tr>
<th><label for="city">City:</label></th>
<td><sf:input path="city"size="30"
id="city"/>
</td>

</tr>
</table>
</fieldset>
<input type="submit" value="Submit" />
</sf:form>
</div>