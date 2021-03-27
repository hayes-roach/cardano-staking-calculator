# cardano-staking-calculator
Cardano (ADA) Staking Calculator REST API

Endpoint: ```/calculate/ada```

Type: GET

Description: Estimates ADA based on given parameters and a 5% interest rate by staking

Request Parameters: 
  - adaAmount (initial ADA amount)
  - years (how many years to hold)
  - adaAddedPerYear (how much ADA is added per year)

http://localhost:8080/calculate/ada?adaAmount=5000&years=5&adaAddedPerYear=1000


Endpoint: ```/calculate/usd```

Type: GET

Description: Estimates USD price of ADA based on given parameters and a 5% interest rate by staking

Request Parameters: 
  - adaAmount (initial ADA amount)
  - years (how many years to hold)
  - adaAddedPerYear (how much ADA is added per year)
  - (Optional) usdFuturePrice (how much you think the future USD price will be for one ADA, defaults to current USD price)

http://localhost:8080/calculate/usd?adaAmount=5000&years=5&adaAddedPerYear=1000&usdFuturePrice=10.50
