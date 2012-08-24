<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Update Person">
    <form:form action="/FinanceManager/person/${person.id}" method="PUT" modelAttribute="person">
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
            <form:errors path="email" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "email", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Email (numbers only)", regExp: "[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", required : true}})); </script>
        </div>
        <br/>        
        <div>        	
            <label for="password">Password:</label>
            <form:password cssStyle="width:250px" maxlength="30" path="password" size="30"/>
            <form:errors path="password" cssClass="errors"/><br/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "password", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Account Password", required : true}})); </script>
        </div>        
        <br/>  
        <div>
            <label for="streetName">Street Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.streetName" id="streetName" size="30"/>
            <form:errors path="address.streetName" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "streetName", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Street Name", required : true}})); </script>
        </div>
        <br/>
        <div>
            <label for="streetNumber">Street Number:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.streetNumber" id="streetNumber" size="30"/>
            <form:errors path="address.streetNumber" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "streetNumber", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Street Number", required : true}})); </script>
        </div>
        <br/>
        <div>
            <label for="city">City:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.city" id="city" size="30"/>
            <form:errors path="address.city" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "city", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter City", required : true}})); </script>
        </div>
        <br/>
        <div>
            <label for="zipCode">Zip Code:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.zipCode" id="zipCode" size="30"/>
            <form:errors path="address.zipCode" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "zipCode", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Zip Code", required : true}})); </script>
        </div>
        <br/>
        <div>
            <label for="state">State:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="address.state" id="state" size="30"/>
            <form:errors path="address.state" cssClass="errors"/>
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
        <div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
            <input id="proceed" type="submit" value="Update"/>
        </div>
        <form:hidden path="id"/>
        <form:hidden path="version"/>
    </form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
