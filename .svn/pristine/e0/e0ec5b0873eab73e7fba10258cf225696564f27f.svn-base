<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Show Person">
    <c:if test="${not empty person}">       
        <div>
            <label for="firstName">First Name:</label>
            <div id="firstName">${person.firstName}</div>
        </div>
        <br/>
         <div>
            <label for="lastName">Last Name:</label>
            <div id="lastName">${person.lastName}</div>
        </div>
        <br/>
        <div>
            <label for="email">Email:</label>
            <div id="email">${person.email}</div>
        </div>
        <br/>
        <div>
            <label for="streetName">Street Name:</label>
            <div id="streetName">${person.address.streetName}</div>
        </div>
        <br/>
        <div>
            <label for="streetNumber">Street Number:</label>
            <div id="streetNumber">${person.address.streetNumber}</div>
        </div>
        <br/>
        <div>
            <label for="city">City:</label>
            <div id="city">${person.address.city}</div>
        </div>
         <br/>
        <div>
            <label for="zipCode">Zip Code:</label>
            <div id="zipCode">${person.address.zipCode}</div>
        </div>
        <br/>
        <div>
            <label for="state">State:</label>
            <div id="state">${person.address.state}</div>
        </div>
         <br/>
        <div>
            <label for="country">Country:</label>
            <div id="country">${person.address.country}</div>
        </div>
    </c:if>
    <c:if test="${empty person}">No person found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
