<ul>

	<li>
	<c:choose>
  		<c:when test="${not empty pageContext.request.userPrincipal}">
			<h2>Welcome <c:out value="${request.remoteUser}" /></h2>
			<ul>
			<li><a href="/FinanceManager/j_spring_security_logout">Logout</a></li>
			</ul>
		</c:when>	
		<c:otherwise>
			<h2>Security</h2>
			<ul>
			<li><a href="/FinanceManager/login.jsp">Login</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
	</li>
	<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
	<li>
	<h2>Person</h2>
	<ul>
		<li><a href="/FinanceManager/person">List</a></li>
		<sec:authorize ifAllGranted="ROLE_ADMIN">
		<li><a href="/FinanceManager/person/form">Create</a></li>
		</sec:authorize>
	</ul>
	</li>
	
	<li>
	<h2>Account</h2>
	<ul>
		<li><a href="/FinanceManager/account">List</a></li>
		<sec:authorize ifAllGranted="ROLE_ADMIN">
		<li><a href="/FinanceManager/account/form">Create</a></li>
		</sec:authorize>
	</ul>
	</li>	
	</sec:authorize>
	<li>
	<h2>Product</h2>
	<ul>
		<li><a href="/FinanceManager/product">List</a></li>
		<sec:authorize ifAllGranted="ROLE_ADMIN">
		<li><a href="/FinanceManager/product/form/cash">Create Cash Product</a></li>
		<li><a href="/FinanceManager/product/form/managedFund">Create Managed Fund Product</a></li>
		<li><a href="/FinanceManager/product/form/loan">Create Loan Product</a></li>
		</sec:authorize>
	</ul>
	</li>
	<sec:authorize ifAllGranted="ROLE_ADMIN">
	<li>
	<h2>Wizard</h2>
	<ul>
		<li><a href="/FinanceManager/wizard">Start</a></li>
	</ul>
	</li>	
	</sec:authorize>
</ul>
