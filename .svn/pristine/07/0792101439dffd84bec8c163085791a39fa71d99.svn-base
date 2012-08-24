<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Update Product"> 
    <form:form action="/FinanceManager/product/${product.class.simpleName}" method="PUT" modelAttribute="product">
        <div>
            <label for="name">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" size="30"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
        </div>
        <br/>
        <div>
            <label for="description">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" path="description"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
        </div>
        <br/>
        <div>
            <label for="managementFee">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" size="30"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        </div>
        <br/>
        <c:if test="${product.class.simpleName eq 'ManagedFund'}">
	        <div>
	            <label for="fundId">Fund Id:</label>
	            <form:input cssStyle="width:250px" maxlength="15" path="fundId" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "fundId", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Fund Id", required : true}})); </script>
	        </div>
	        <br/>
	        <div>
	            <label for="distribution">Distribution:</label>
	            <form:input cssStyle="width:250px" maxlength="30" path="distribution" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "distribution", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
	        </div>
	        <br/>
	        <div>
	            <label for="currentUnitPrice">Current Unit Price:</label>
	            <form:input cssStyle="width:250px" maxlength="30" path="currentUnitPrice" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "currentUnitPrice", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Current Unit Price (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
	        </div>
        </c:if>
        <c:if test="${product.class.simpleName eq 'Cash'}">
	        <div>
	            <label for="interest">Interest:</label>
	            <form:input cssStyle="width:250px" maxlength="15" path="interest" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Interest (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}}));</script>
	        </div>
	    </c:if>
	    <c:if test="${product.class.simpleName eq 'Loan'}">
	        <div>
	            <label for="interest">Interest:</label>
	            <form:input cssStyle="width:250px" maxlength="15" path="interest" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Interest (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}}));</script>
	        </div>
	        <br/>
	        <div>
	            <label for="principal">Principal:</label>
	            <form:input cssStyle="width:250px" maxlength="15" path="principal" size="30"/>
	            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "principal", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Principal (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}}));</script>
	        </div>
	        <br/>
	        <div>
	        	 <label for="lenders">Lenders:</label>
	             <form:select cssStyle="width:250px" path="lenders">
                    <form:options itemValue="id" items="${product.lenders}"/>
                </form:select>
                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "lenders", widgetType: "dijit.form.MultiSelect", widgetAttrs : {hasDownArrow : true}})); </script>
        	</div>
	    </c:if>
	    <br/>
        <div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
            <input id="proceed" type="submit" value="Update"/>
        </div>
        <form:hidden path="id"/>
        <form:hidden path="version"/>
    </form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
