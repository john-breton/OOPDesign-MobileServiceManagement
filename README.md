## Design Patterns 2020/21

# Mid-Term Exam

# **Exam Exercise - Mobile Services Management**
## **The Market Requirements (MRs)**
A Mobile Service Provider,  Company-A,  has the following MRs to comply with:

  ### Implement a Mobile Service Management Application that is made up of the following services: 

    1. One Account Management system to manage accounts.
    2. One User Management system to manage users.
    3. One Bundle Management system to manage bundles.
    4. One Reporting Service to generate automatic and on-demand reports.
  All  the Management and Reporting services should be able to handle multiple admins (telco operators) performing management and reporting services info without any risk of data inconsistencies.

### The Service Account must have the following data components:

    1. Phone Number (unique identifier)**
    2. User
    3. Service Bundle

### The User must have the following data components: 

    1. "Surfoplane" (probably username) (unique identifier)
    2. User Address
    3. User Email

### The Service Bundle  must have the following data components:

    1. Bundle Name (unique identifier)
    2. Calling Plan
    3. Messaging Plan
    4. Data Plan
    5. Monthly Fees

### The Bundle Management is required to support the following Service Bundles:

    1. Supported Service Bundles types

-  A service bundle can be either: 

    - &quot;**Preconfigured&quot;**
    - &quot;**Picachos (Pac)&quot; – Plain and Customized**
- #### **Preconfigured Bundles:**

      The service provider has provided the following details on the preconfigured bundles to start with:
        1. Platinum Bundle
            - Bundle Name: Platinum Bundle
            - Calling Plan: Unlimited US & Canada wide calling
            - Messaging Plan: Unlimited Messages
            - Data Plan: 10 GB
            - Monthly Fees: $100
        2. Gold Bundle
            - Bundle Name: Gold Bundle
            - Calling Plan: Unlimited Canada wide calling
            - Messaging Plan: 10K Messages
            - Data Plan: 4 GB
            - Monthly Fees: $80
        3. Silver Bundle
            - Bundle Name: Silver Bundle
            - Calling Plan: 100 min free Canada wide calling
            - Messaging Plan: 5K Messages
            - Data Plan: 2 GB
            - Monthly Fees: $45
        4. Bronze Bundle
            - Bundle Name: Bronze Bundle
            - Calling Plan: 30 min free Canada wide calling
            - Messaging Plan: 250 Messages
            - Data Plan: 1 GB
            - Monthly Fees: $25


- #### **Pac Bundles**
    The Plain PaC Bundle does not have any option, just the Bare Bone service.
    <br>A custom PaC Bundle has one or more options in addition to the Bare Bone service (e.g. adding a Gold calling option).
  
      Pick & Choose (PaC) Bundle Details:
          - Bundle Name: Pick And Choose Bundle
          - Bare Bone Phone Service (Must have - fixed)
            - Flat Rate - $10
          - Calling Plan (Optional)
            - Platinum: Unlimited US &amp; Canada wide calling - $40
            - Gold: Unlimited Canada wide calling - $30
            - Silver: 100 min free Canada wide calling - $20
            - Bronze: 30 min free Canada wide calling - $15
            - Zero min - $00
          - Messaging Plan (Optional)
            - Platinum: Unlimited Messaging - $45
            - Gold: 10K Messages - $35
            - Silver: 5K Messages - $25
            - Bronze: 250 Messages - $20
            - Zero Messages - $00
          - Data Plan (Optional)
            - Platinum: Data Included: 10 GB - $40
            - Gold: Data Included: 7 GB - $30
            - Silver: Data Included: 4 GB - $25
            - Bronze: Data Included: 2 GB - $20
            - Data Included: 0 GB - $00
          - Monthly Fees: Grand sum of the active plans in addition to the flat rate fees.

### **The User Management service must support the following functionality:**
    1. Add User (user)
    2. Add Users (user list)
    3. Delete User (user)
    4. Delete Users (users names list)
    5. Update User (user)
    6. Get User (username)
    7. User Address and email are the only attributes that can be updated when a user is updated.
    8. When a user is removed, all the associated accounts must be removed (preferably with a warning message).
    9. Duplicate users cannot be added to the system.

### **The Bundle Management is required to support the following functionality:**
    1. Add Preconfigured Bundle (bundle name)
    2. Add Plain Pac Bundle (bundle name)
    3. Add Pac Bundle With Calling Option (calling plan name).
    4. Add Pac Bundle With Messaging Option (messaging plan name).
    5. Deletion of existing service bundles shall not be supported in this release.
    6. Updating of existing service bundles shall not be supported in this release.

### The Account Management is required to support the following functionality and requirements:
    1. Add Service Account (user, phone, bundle)
    2. Add Service Account (account)
    3. Delete Service Account (phone).
    4. Update Service Account (phone, bundle)
    5. Get Service Account (phone)
    6. Update Service Account bundle (upgraded or downgraded) at runtime without interrupting the service is supported
    7. User and Phone number cannot be modified for an existing account. Only the bundle can be updated.
    8. A phone number can be associated with only one service account.
    9. A user can be associated with one or more accounts.
    10. When an account is deleted, the associated user must be deleted if that user is not associated with any other service accounts.**

### **The Reporting service is required to support the following:**

    1.On-demand Reports:
      1.1 List User Details (username)
      1.2 List All Users Names
      1.3 List Account (phone number)
      1.4 List Accounts (user name)
      1.5 List Monthly Fees (phone number)
      1.6 List Monthly Fees All Accounts (user name)
      1.7 List Bundle Details <bundle name>
      1.8 List All Preconfigured Bundles Names
      1.9 List All Pac Bundles Names
    2. Automatic Reports
      2.1 When a service account is added/modified/deleted, the reporting service is required to produce a report showing:
        2.1.1 The newly created account details.
        2.1.2 When updating an account, the status before and after the change should be reported (e.g. if a Service Account is updated, then we need to see on the screen the account details before and after the update)
        2.1.3 When deleting an account, the details for the deleted account should be reported.
      2.2 When a user is added/modified/deleted, the reporting service is required to produce a report showing:
        1. The newly created user details.
        2. When updating a user, the status before and after the change should be reported (e.g. if a user is updated, then we need to see on the screen the user details before and after the update).
        3. When deleting a user, the details for the deleted user should be reported.
      2.3 When a bundle is created, the reporting service is required to produce a report showing:
        2.3.1 The newly created bundle details.

## **Demo Requirements:**

 1. Implementation of the three management services (bundle, account, and user) as well as the reporting service.
 2. Creating a system with at least 10 accounts covering all of the above-mentioned management functionality and reports.
 3. To simplify the demo, the service provider has requested a simple menu driven prototype similar to the following sample:

    1. **Add User \<user details in  comma separated list>**
    2. **Add Users \<users details in  comma separated list>**
    3. **Update User \&lt;user\&gt;**
    4. **Delete User \&lt;username\&gt;**
    5. **Delete Users\&lt; users names list\&gt;**
    6. **Add Account \&lt;phone, user, bundle\&gt;**
    7. **Add Account \&lt;account\&gt;**
    8. **Delete Account \&lt;phone\&gt;**
    9. **Update Account \&lt;phone, bundle\&gt;**
    10. **Add Preconfigured Bundle \&lt;bundle name\&gt;**
    11. **Add Pac Bundle \&lt;bundle name\&gt;**
    12. **Add Pac Bundle With Calling Option \&lt;calling plan name\&gt;**
    13. **Add Pac Bundle With Messaging Option \&lt;messaging plan name\&gt;**
    14. **List User Details \&lt;username\&gt;**
    15. **List All Users Names**
    16. **List Account \&lt;phone number\&gt;**
    17. **List Accounts \&lt;username\&gt;**
    18. **List Monthly Fees \&lt;phone number\&gt;**
    19. **List Monthly Fees All Accounts \&lt;username\&gt;**
    20. **List Bundle Details \&lt;bundle name\&gt;**
    21. **List All Preconfigured Bundles Names**
    22. **List All Pac Bundles Names**

### The demoing team is required to type in the one of the commands to invoke the action: For example:
    - Add User first Name Last Name, phone Number, email Address


### During the demo, the menu should be redisplayed after entering every command.
### During system startup, there are no users, no bundles and no accounts.
