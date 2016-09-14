The code is written in Java.
Source files - src\main\apartment\list
Unit test - src\test\apartment\list



Working -

Main class and entry point of the program is Controller.java, method - generateSnippet(String document, String query);
This class uses the Feature abstract class. A Feature can be a BedRoom, BathRoom, Kitchen etc. Each Feature has list of properties specific to
this feature, example a Kitchen feature can have Countertops and appliances. These properties are held in the KeyWords Enum.
Using the query entered we get which Feature it belongs to (ie customer needs information for which feature). Next we parse the document to 
get text related to this Feature and return to user.

Enhancement -

New Features ca be added to cover more areas of interest to customer.
New properties related to feature can be added to increase the search domain inside the entered document.