Feature: Validating place API'S

Scenario: Verify if place is being successfully added using AddPlaceApi
	  Given Add place payload
	  When user calls "AddPlaceAPI" with post hhtp request
	  Then the API call is success with status code 200
	  And  "status" in reponse body is "ok"  #for reuse the step we put it in double quote
	  And "scope" in response body is "APP"