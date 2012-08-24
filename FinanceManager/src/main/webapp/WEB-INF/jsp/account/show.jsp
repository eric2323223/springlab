<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">
	dojo.require("dijit.TitlePane");
	dojo.require("dijit.Dialog");
	dojo.require("dijit.form.TextBox");  
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.FilteringSelect");		
</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Show Account">
    <c:if test="${not empty account}">
        <div>
            <label for="name">Name:</label>
            <div id="name">${account.name}</div>
        </div>
        <br/>
        <div>
            <label for="owners">Owners:</label>
            <div id="owners">${account.owners}</div>
        </div>
        <br/>
        <div>
            <label for="manager">Manager:</label>
            <div id="manager">${account.manager}</div>
        </div>
        <br/>
        <div>
           <label for="investments">Investments:</label>
            <div id="investments">${account.investments}</div>
        </div>
        <br/>
        <div>
        	<label for="newInvestmentButton"></label>
	        <div id="newInvestmentButton" dojoType="dijit.form.DropDownButton">
			  <span>Add New Investment</span>
			  <div dojoType="dijit.TooltipDialog" id="tooltipDlg" title="Enter Investment Details">
			     <form:form action="/FinanceManager/account/${account.id}/investment" method="POST" modelAttribute="investment">
			        <div>
			            <label for="unit">Unit:</label>
			            <form:input cssStyle="width:250px" maxlength="30" path="unit" size="30"/>
			            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "unit", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Unit (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : true}})); </script>
			        </div>
			        <br/>
			        <div>
			            <label for="initialUnitPrice">Initial Unit Price:</label>
			            <form:input cssStyle="width:250px" maxlength="30" path="initialUnitPrice" size="30"/>
			            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "initialUnitPrice", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Initial Unit Price (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : true}})); </script>
			        </div>
			        <br/>
			        <div>
			            <label for="transactionDate">Transaction Date:</label>
			            <form:input cssStyle="width:250px" maxlength="30" path="transactionDate" size="30"/>
			            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "transactionDate", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Transaction Date", required : true}})); </script>
			            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "transactionDate", widgetType : "dijit.form.DateTextBox", widgetAttrs : {datePattern : "MM/dd/yyyy", required : true}})); </script>
			        </div>
			        <br/>
			        <div>
			            <c:if test="${not empty products}">
			                <label for="product">Product:</label>
			                <form:select cssStyle="width:250px" path="product">
			                    <form:options itemValue="id" itemLabel="name" items="${products}"/>
			                </form:select>
			                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "product", widgetType: "dijit.form.FilteringSelect", widgetAttrs : {hasDownArrow : true}})); </script>
			            </c:if>
			        </div>
			        <br/>
			        <div class="submit">
			            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
			            <input id="proceed" type="submit" value="Save"/>
			        </div>
			    </form:form>
			  </div>
			</div>
		</div>
        
    </c:if>
    <c:if test="${empty account}">No account found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
