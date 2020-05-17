# Banking System

### How to run?
Go to folder and run this<br>
'mvn clean install'
'java -jar target/online_banking_system-0.0.1-SNAPSHOT.jar'

### Curl Requests
 Postman collection below<br>
 https://www.getpostman.com/collections/79a42ace058aa1719f20
 
 
### Direct Curls
#### Create Branch

curl --location --request POST 'http://localhost:8080/banking-system/create-branch' \
--header 'Content-Type: application/json' \
--data-raw '{
	"branchName" : "HBJNDFJKCKJD",
	"ifscCode" : "JVFFJKFKK123",
	"address"  : {
		"state" :  "punjab",
		"pinCode" : "141001",
		"landmark" : "kbfvndjvcdknjk",
		"area" : "jnbvfjdjklvjklejdkjvkdfjxjkvhjkfnckjvhjkfnvkjfjkhbnkkj"
	},
	"headBranchId" : 1
}'

<br>

#### get all Branches of head office
curl --location --request GET 'http://localhost:8080/banking-system/get-all-branches/1'

<br>

#### get Branch
curl --location --request GET 'http://localhost:8080/banking-system/get-branch/5'

#### create account
curl --location --request POST 'http://localhost:8080/banking-system/create-account' \
--header 'Content-Type: application/json' \
--data-raw '{
	"firstName" : "Shivam",
	"lastName" : "Bagga",
	"panCardNumber"  : "DOFPK3018Q",
	"gender" : "MALE",
	"accountType" : "savings",
	"depositAmount" : "122344",
	"branchId" : 2,
	"currency" : "INR"
}'

<br>

#### get account
curl --location --request GET 'http://localhost:8080/banking-system/get-account/1'

#### get Customer
curl --location --request GET 'http://localhost:8080/banking-system/get-customer/DOFPK3018Q'

#### deposit amount transaction
curl --location --request POST 'http://localhost:8080/banking-system/deposit-money' \
--header 'Content-Type: application/json' \
--data-raw '{
	"accountId" : 1,
	"depositAmount" : 100000
}'

#### withdrawal amount transaction
curl --location --request POST 'http://localhost:8080/banking-system/withdraw-money' \
--header 'Content-Type: application/json' \
--data-raw '{
	"accountId" : 1,
	"withdrawalAmount" : 100000
}'

#### get all transactionn of account
curl --location --request GET 'http://localhost:8080/banking-system/get-all-transactions/1'

#### get mini statement of account
curl --location --request GET 'http://localhost:8080/banking-system/get-mini-statement/1'