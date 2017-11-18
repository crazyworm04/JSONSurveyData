# JSONSurveyData #
Java class and Junit test for accepting and handling JSON data from a survey
Created using eclipse IDE, Download into workspaces.

https://gitlab.com/futureCodersSE/KnowledgeBase/issues/9

## User story: ##
As a front end developer, I need to be able to send some survey data to a java class, in JSON format, and for it to be analysed and results sent back, also in JSON format.

## Requirements: ##
Format of input data:
{ "surveyQuestion" :[ { "question":"How valuable was today in terms of your learning?", "responses":[ { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" } ] }, { "question":"Which of these are you most likely to want to continue to learn?", "responses":[ { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" } ] } ] }
Output format: { "analysis" :[ { "question":"How valuable was today in terms of your learning?", "summary": { "answer1":"0%", "answer2":"0%", "answer3":"0%", "answer4":"0%", "answer5":"0%" } }, { "question":"Which of these are you most likely to want to continue to learn?", "summary": { "answer1":"0%", "answer2":"0%", "answer3":"0%", "answer4":"0%", "answer5":"0%" } } ] }
Please check the JSON format for errors.
Processing: Read input, each answer that is marked true is counted as one response for that question. Count the 'true' answers and calculate the percentage this is of all answers (e.g. if 2 out of 3 records had answer1 as true then the percentage is 67%. 

## Acceptance Criteria ##
Test 1: use the JSON data above - the percentages for everything should be 0.
Test 2: 
{
"surveyQuestion" :[
{ "question":"How valuable was today in terms of your learning?", "responses":[ { "answer1":"false", "answer2":"false", "answer3":"true", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"true", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"false", "answer3":"true", "answer4":"false", "answer5":"false" } ] }, { "question":"Which of these are you most likely to want to continue to learn?", "responses":[ { "answer1":"true", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"false", "answer2":"true", "answer3":"false", "answer4":"false", "answer5":"false" }, { "answer1":"true", "answer2":"false", "answer3":"false", "answer4":"false", "answer5":"false" } ] } ] } 
Answer should be: { "analysis" :[ { "question":"How valuable was today in terms of your learning?", "summary": { "answer1":"0%", "answer2":"0%", "answer3":"100%", "answer4":"0%", "answer5":"0%" } }, { "question":"Which of these are you most likely to want to continue to learn?", "summary": { "answer1":"67%", "answer2":"33%", "answer3":"0%", "answer4":"0%", "answer5":"0%" } } ] }
