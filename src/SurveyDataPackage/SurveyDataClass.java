package SurveyDataPackage;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.json.JSONArray;

public class SurveyDataClass {
	//Variables
	String emptyData = "";
	Integer percentageZero = 0;
	Integer truesCount1 = 0;
	Integer truesCount2 = 0;
	Integer truesCount3 = 0;
	Integer truesCount4 = 0;
	Integer truesCount5 = 0;
	
	
	JSONObject dataInput = new JSONObject();
	JSONObject dataOutput = new JSONObject();
				
	//Constructors
	public SurveyDataClass(){
		createEmptyOutput();
	}
	public SurveyDataClass(JSONObject dataInputObject){
		dataInput = dataInputObject;
		createDataOutput(dataInput);
	}
			
	//Getters and setters
	public void setJSONInput(){
		
	}
	public JSONObject getJSONOutput() {
		return dataOutput;
	}
	//Other processes
	//Establishes input data fields 
	private void createEmptyOutput() {
		
		JSONObject questionAnalysis1 = new JSONObject();
		questionAnalysis1.put("answer1", 0 + "%");
		questionAnalysis1.put("answer2", 0 + "%");
		questionAnalysis1.put("answer3", 0 + "%");
		questionAnalysis1.put("answer4", 0 + "%");
		questionAnalysis1.put("answer5", 0 + "%");
						
		JSONObject questionAnalysis2 = new JSONObject();
		questionAnalysis2.put("answer1", 0 + "%");
		questionAnalysis2.put("answer2", 0 + "%");
		questionAnalysis2.put("answer3", 0 + "%");
		questionAnalysis2.put("answer4", 0 + "%");
		questionAnalysis2.put("answer5", 0 + "%");
				
		Collection<JSONObject> questionsOutput = new ArrayList<JSONObject>();
		JSONObject questionsOut1 = new JSONObject();
		questionsOut1.put("question", "How valuable was today in terms of your learning?");
		questionsOut1.put("summary", questionAnalysis1);
		
		questionsOutput.add(questionsOut1);
		
		JSONObject questionsOut2 = new JSONObject();
		questionsOut2.put("question", "Which of these are you most likely to want to continue to learn?");
		questionsOut2.put("summary", questionAnalysis2);
		
		questionsOutput.add(questionsOut2);
		
		dataOutput.put("analysis", questionsOutput);
	} 
	private void createDataOutput(JSONObject dataInputObject) {
		Collection<JSONObject> questionsOutput = new ArrayList<JSONObject>();
		JSONArray questions = dataInputObject.getJSONArray("surveyQuestion");
						
		for(int i = 0; i < questions.length(); i++) {
									
			JSONObject questionInput = questions.getJSONObject(i);
			JSONArray responsesData = questionInput.getJSONArray("responses");
			
				truesCount1 = 0; truesCount2 = 0; truesCount3 = 0; truesCount4 = 0; truesCount5 = 0;
			for(int j = 0; j < responsesData.length(); j++) {
				JSONObject answers = responsesData.getJSONObject(j);
								
				if(answers.getBoolean("answer1") == true) {
					truesCount1++;
				}
				
				if(answers.getBoolean("answer2")  == true) {
					truesCount2++;
				}
				if(answers.getBoolean("answer3")  == true) {
					truesCount3++;
				}
				if(answers.getBoolean("answer4")  == true) {
					truesCount4++;
				}
				if(answers.getBoolean("answer5")  == true) {
					truesCount5++;
				}
				
				}
			
		JSONObject questionAnalysis = new JSONObject();
		questionAnalysis.put("answer1", (truesCount1 * 100 / responsesData.length()) + "%");
		questionAnalysis.put("answer2", (truesCount2 * 100 / responsesData.length()) + "%");
		questionAnalysis.put("answer3", (truesCount3 * 100 / responsesData.length()) + "%");
		questionAnalysis.put("answer4", (truesCount4 * 100 / responsesData.length()) + "%");
		questionAnalysis.put("answer5", (truesCount5 * 100 / responsesData.length()) + "%");
		
		
		JSONObject questionsOut = new JSONObject();
		questionsOut.put("question", questionInput.get("question"));
		questionsOut.put("summary", questionAnalysis);
		
		questionsOutput.add(questionsOut);
		}
		dataOutput.put("analysis", questionsOutput);
		}
}




