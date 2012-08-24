<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Show Product"> 
    <c:if test="${not empty product}">
        <div>
            <label for="name">Name:</label>
            <div id="name">${product.name}</div>
        </div>
        <br/>
        <div>
            <label for="type">Type:</label>
            <div id="type">${product.class.simpleName}</div>
        </div>
        <br/>
        <div>
            <label for="description">Description:</label>
            <div id="description">${product.description}</div>
        </div>
        <br/>
        <div>
            <label for="managementFee">Management Fee:</label>
            <div id="managementFee">${product.managementFee}</div>
        </div>
        <br/>
        <c:if test="${product.class.simpleName eq 'ManagedFund'}">
	        <div>
	            <label for="fundId">Fund Id:</label>
	            <div id="fundId">${product.fundId}</div>
	        </div>
	        <br/>
	        <div>
	            <label for="distribution">Distribution:</label>
	            <div id="distribution">${product.distribution}</div>
	        </div>
	        <br/>
	        <div>
	            <label for="currentUnitPrice">Current Unit Price:</label>
	            <div id="currentUnitPrice">${product.currentUnitPrice}</div>
	        </div>
	        <br/>
        </c:if>
        <c:if test="${product.class.simpleName eq 'Cash'}">
	        <div>
	            <label for="interest">Interest:</label>
	            <div id="interest">${product.interest}</div>
	        </div>
	        <br/>
        </c:if>
        <c:if test="${product.class.simpleName eq 'Loan'}">
	        <div>
	            <label for="interest">Interest:</label>
	            <div id="interest">${product.interest}</div>
	        </div>
	        <br/>
	        <div>
	            <label for="principal">Principal:</label>
	            <div id="principal">${product.principal}</div>
	        </div>
	        <br/>
	        <div>
	            <label for="lenders">Lenders:</label>
	            <div id="lenders">${product.lenders}</div>
	        </div>
	        <br/>
        </c:if>
    </c:if>
    <c:if test="${empty product}">No product found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
