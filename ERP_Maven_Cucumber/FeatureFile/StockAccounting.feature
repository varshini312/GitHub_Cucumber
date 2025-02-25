@tag
Feature:
as admin user validate supplier nad customer
@suppliers
Scenario Outline:
i want to verfy suppliers with multiple data
Given launch url "http://webapp.qedgetech.com/" in a browser
When Enter username  with "name" and "username" and "admin"
And Enter password with "xpath" and "//input[@id='password']" and "master"
And click login button with "xpath" and "//button[@id='btnsubmit']"
Then validate title with "Dashboard « Stock Accounting"
When click suppliers link with "xpath" and "(//a[contains(text(),'Suppliers')])[2]"
When click Add icon with "xpath"and "(//span[@data-caption='Add'])[1]"
When capture supplier number with "name"and "x_Supplier_Number"
When Enter in "<SupplierName>" with "id" and "x_Supplier_Name"
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']"  
When click Add with "id" and "btnAction"
When click confirm ok with "xpath" and "//button[normalize-space()='OK!']"
When click alert ok with "xpath" and "(//button[contains(text(),'OK')])[6]"
Then validate supplier table
When close browser
Examples:
|SupplierName|address|city|country|cperson|pnumber|mail|mnumber|note|
|Akhilesh1|Ameerpet1|Hydearbad|India|QedgeTech1|6547896547|Test@gmail.com|3456789098|Supplying goods|
|Akhilesh71|Ameerpet81|Hydearbad|India|QedgeTech81|6547896547|Test@gmail.com|3456789098|Supplying goods|
|Akhilesh51|Ameerpet14|Hydearbad|India|QedgeTech1|6547896547|Test@gmail.com|3456789098|Supplying goods|
@customer
Scenario Outline:
i want to validate customers with mutiple data
Given launch url "http://webapp.qedgetech.com/" in a browser
When Enter username  with "name" and "username" and "admin"
And Enter password with "xpath" and "//input[@id='password']" and "master"
And click login button with "xpath" and "//button[@id='btnsubmit']"
Then validate title with "Dashboard « Stock Accounting"
When click Customers link with "xpath" and "(//a[contains(text(),'Customers')])[2]"
When click Add icon with "xpath"and "(//span[@data-caption='Add'])[1]"
When capture Customer number with "name"and "x_Customer_Number"
When Enter in "<CustomerName>" with "id" and "x_Customer_Name"
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']"  
When click Add with "id" and "btnAction"
When click confirm ok with "xpath" and "//button[normalize-space()='OK!']"
When click alert ok with "xpath" and "(//button[contains(text(),'OK')])[6]"
Then validate customer table
When close browser
Examples:
|CustomerName|address|city|country|cperson|pnumber|mail|mnumber|note|
|LgCustomer1|Srnager1|Ameerpet1|India|Qedge1|9876543212|Test@gmail.com|8765432123|Lg Customer|
|LgCustomer41|Srnager51|Ameerpet17|India|Qedge1|9876543212|Test@gmail.com|8765432123|Lg Customer|
|LgCustomer71|Srnager71|Ameerpet1|India|Qedge1|9876543212|Test@gmail.com|8765432123|Lg Customer|
|LgCustomer17|Srnager12|Ameerpet61|India|Qedge1|9876543212|Test@gmail.com|8765432123|Lg Customer|
