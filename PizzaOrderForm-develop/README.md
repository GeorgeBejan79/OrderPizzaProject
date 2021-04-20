## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com

#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo


### Functional Test Cases

 1. Validate that you are able to place an order for pizza with following selections
	a. Select "Large 10 Slices - 2 toppings, 13.50" in Pizza1 
			Expected: Large 10 Slices - 2 toppings, 13.50 is selected 
	b. Select "Mushrooms" in Toppings1 field
			Expected: Mushrooms is selected 
	c. Select "Italian Ham" in Toppings2 field
			Expected: Italian Ham is selected 
	d. enter "2" in quantity
			Expected: 2 is entered, Validate Cost field is calculated automatically and displays 27 (13.50*2)
	e. Enter "Tester One" in Name
	f. Enter "tester.one@gmail.com" in Email
	g. Enter "9728908888" in phone 
	h. Select Cash on Pickup radio button
	i. Click Place Order button is clicked
	j. Validate "Thank you for your order! TOTAL: 27 Large 10 Slices - 2 toppings" is displayed
	8. Verify order is created in appropriate database tables
 2. Validate the title of the page <Pizza Order Form>
 3. Validate below fields exists on the page (required/optional fields are based on business requirements document/user story)
    a. Pizza1 (required)
	b. Toppings 1 
	c. Toppings 2
	d. Quantity (required)
	e. Cost
	f. PICKUP INFORMATION (heading)
	g. Name (required)
	h. Email (Optional)
	i. Phone (required)
	j. PAYMENT INFORMATION (heading)
	k. Credit Card (radio button)
	l. Cash on Pickup (radio button)
	m. Place Order button
	n. Reset button
 3. Validate Pizza1 dropdown contains below options
	a. Small 6 Slices - no toppings, 6.75,
    b. Small 6 Slices - 1 topping, 7.50,
    c. Medium 8 Slices - 2 toppings, 9.75,
    d. Large 10 Slices - no toppings, 11.75,
    e. Large 10 Slices - 2 toppings, 13.50;
 4. Validate Toppings 1 dropdown contains below options
	a. Diced Mango
    b. Olives
    c. Mushrooms,
    d. Caramelized onions,
    e. Italian Ham,
    f. Classic Pepperoni,
    g. Salami,
    h. Provolone cheese,
    i. Extra cheese,
    j. Mozzarella cheese,
    k. Parmesan cheese
 5. Validate Toppings 2 dropdown contains below options
	a. Diced Mango
    b. Olives
    c. Mushrooms,
    d. Caramelized onions,
    e. Italian Ham,
    f. Classic Pepperoni,
    g. Salami,
    h. Provolone cheese,
    i. Extra cheese,
    j. Mozzarella cheese,
    k. Parmesan cheese
 6. Validate when Credit Card radio button is selected, below fields appears to enter credti card information
	a. First Name 
	b. Last Name
	c. Credit card type (Visa, Mastercard, Discover)
	c. Credit Card Number
	      i. validate credit card number is masked after user completes the field
		  ii. ensure credit card number is not more than <16> digits based on credit card type
	d. Expiry Date (mm/yyyy)
	e. CVV number (3 digits)
 7. Validate when Cash On Pickup is clicked, Credit card radio button is unselected and Cash on Pick up is selected
 8. Validate when 'Place Order' button is clicked without entering Name, 'Missing Name' message displayed
 9. Validate when 'Place Order' button is clicked without entering Phone, 'Missing Phone' message displayed
 10. Validate when Reset button is clicked, all fields are reset and empty
 11. Validate numbers are not allowed to be entered in Name field
 12. Validate letters are not allowed to be entered in Phone Number field
 13. Validate letters are not allowed to be entered in Quantity field
 14. Validate when pizza with no toppings options are selected, Toppings1 and Toppings2 fields are disabled
 
 ### Defects: 
 1. when credit card radio button is selected and try to change it to cash on pick up, both radio buttons are selected. Selection needs to be changed to 'Cash on Pickup'
 2. All mandatory fields needs to be filled. When I clicked 'Place Order' without filling mandatory fields, order went through. 
 3. When credit card radio button is selected, credit card fields need to be displayed where customer can cc number etc. 
 4. When I click reset button, all fields need to be reset to original values but some fields are not resetting
 5. 1st option is little confusing, if no toppings is selected, toppings1 and toppings2 fields should not allow to select any options
 6. There should be a space between Toppings and 2
 7. Pizza1 and Quantity fields must be required fields