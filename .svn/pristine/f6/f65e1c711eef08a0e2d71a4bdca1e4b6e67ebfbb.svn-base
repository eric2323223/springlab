<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<c:if test="${not empty managedFund}"> 
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Managed Fund Product">
    <form:form action="/FinanceManager/product/managedFund" method="POST" modelAttribute="managedFund">
		<div>
            <label for="name">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
		</div>
        <br/>
		<div>
            <label for="description">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" path="description"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
		</div>
        <br/>
		<div>
            <label for="managementFee">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
        <br/>
		<div>
            <label for="fundId">Fund Id:</label>
            <form:input cssStyle="width:250px" maxlength="15" path="fundId" size="30"/>
            <form:errors path="fundId" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "fundId", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Fund Id", required : true}})); </script>
		</div>
	    <br/>
		<div>
            <label for="distribution">Distribution:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="distribution" size="30"/>
            <form:errors path="distribution" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "distribution", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
	    <br/>
		<div>
            <label for="currentUnitPrice">Current Unit Price:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="currentUnitPrice" size="30"/>
            <form:errors path="currentUnitPrice" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "currentUnitPrice", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Current Unit Price (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
		<br/>
		<div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed_managedFund', event:'onclick'}));</script>
            <input id="proceed_managedFund" type="submit" value="Save"/>
        </div>

    </form:form>
</div>
</c:if>
<c:if test="${not empty loan}">
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Loan Product">
    <form:form action="/FinanceManager/product/loan" method="POST" modelAttribute="loan">
		<div>
            <label for="name_loan">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" id="name_loan" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
</div>
        <br/>
<div>
            <label for="description_loan">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" id="description_loan" path="description"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_loan", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
</div>
        <br/>
<div>
            <label for="managementFee_loan">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" id="managementFee_loan" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
</div>
        <br/>
		         <div>
			 <label for="interest_loan">Interest:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="interest" id="interest_loan" size="30"/>
            <form:errors path="interest" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        	</div>
        	<br/>
        	<div>
        	<label for="principal_loan">Principal:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="principal" id="principal_loan" size="30"/>
            <form:errors path="principal" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "principal_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        	</div>
        	<br/>
        	<c:if test="${not empty lenders}">
        	<div>
	        	 <label for="lenders">Lenders:</label>
	             <form:select cssStyle="width:250px" path="lenders">
                    <form:options itemValue="id" items="${lenders}"/>
                </form:select>
                <form:errors path="lenders" cssClass="errors"/>
                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "lenders", widgetType: "dijit.form.MultiSelect", widgetAttrs : {hasDownArrow : true}})); </script>
        	</div>
        	<br/>
        	</c:if>        	
        	<div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed_loan', event:'onclick'}));</script>
            <input id="proceed_loan" type="submit" value="Save"/>
			</div>
    </form:form>
</div>
</c:if>
<c:if test="${not empty cash}">
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Cash Product">
    <form:form action="/FinanceManager/product/cash" method="POST" modelAttribute="cash">
		<div>
            <label for="name_cash">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" id="name_cash" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
</div>
        <br/>
<div>
            <label for="description_cash">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" path="description" id="description_cash"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_cash", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
</div>
        <br/>
<div>
            <label for="managementFee_cash">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" id="managementFee_cash" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
</div>
        <br/>

        
        <div>
			 <label for="interest">Interest:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="interest" size="30" id="interest_cash"/>
            <form:errors path="interest" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        	</div>
        	<br/>
      <div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed_cash', event:'onclick'}));</script>
            <input id="proceed_cash" type="submit" value="Save"/>
		</div>
    </form:form>
</div>
</c:if>

<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
