<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Person">
	
    <form:form modelAttribute="person">
        <div>        	
            <label for="firstName">First Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="firstName" size="30"/>
            <form:errors path="firstName" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "firstName", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter First Name", required : true}})); </script>
        </div>
        <br/>
          <div>          	
            <label for="lastName">Last Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="lastName" size="30"/>
            <form:errors path="lastName" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "lastName", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Last Name", required : true}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="email">Email:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="email" size="30"/>
            <form:errors path="email" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "email", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Email (numbers only)", regExp: "[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", required : true}})); </script>
        </div>        
        <br/>
        <div>        	
            <label for="streetName">Street Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.streetName" id="streetName" size="30"/>
            <form:errors path="address.streetName" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "streetName", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Street Name", required : true}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="streetNumber">Street Number:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.streetNumber" id="streetNumber" size="30"/>
            <form:errors path="address.streetNumber" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "streetNumber", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Street Number", required : true}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="city">City:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.city" id="city" size="30"/>
            <form:errors path="address.city" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "city", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter City", required : true}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="zipCode">Zip Code:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.zipCode" id="zipCode" size="30"/>
            <form:errors path="address.zipCode" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "zipCode", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Zip Code", required : true}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="state">State:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.state" id="state" size="30"/>
            <form:errors path="address.state" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "state", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter State", required : false}})); </script>
        </div>
        <br/>
        <div>        	
            <label for="country">Country:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.country" id="country" size="30"/>
            <form:errors path="address.country" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "country", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Country", required : false}})); </script>
        </div>
        <br/>
        
        <div class="submit buttonGroup">
        	<input type="submit" id="cancel" name="_eventId_cancel" value="Cancel"/>&#160;			
			<input type="submit" id="person" name="_eventId_person" value="Create Another Person" />&#160;
			<input type="submit" id="product" name="_eventId_product" value="Proceed" />&#160;
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'product', event:'onclick'}));
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'person', event:'onclick'}));
			</script>
			
		</div>
    </form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
