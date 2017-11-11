package SurveyDataPackage;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.json.JSONArray;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.*;

public class SurveyDataClassTest {
	String emptyData = "";
	boolean t = true; 
	boolean f = false;
	JSONObject dataInput = new JSONObject();
	JSONObject dataOutput = new JSONObject();
		
	//Test for no input data
	@Test
	public void testForNoDataInput() {
		Collection<JSONObject> questionsOutput = new ArrayList<JSONObject>();
				
		JSONObject questionAnalysis1 = new JSONObject();
		questionAnalysis1.put("answer1", "0%");
		questionAnalysis1.put("answer2", "0%");
		questionAnalysis1.put("answer3", "0%");
		questionAnalysis1.put("answer4", "0%");
		questionAnalysis1.put("answer5", "0%");
						
		JSONObject questionAnalysis2 = new JSONObject();
		questionAnalysis2.put("answer1", "0%");
		questionAnalysis2.put("answer2", "0%");
		questionAnalysis2.put("answer3", "0%");
		questionAnalysis2.put("answer4", "0%");
		questionAnalysis2.put("answer5", "0%");
				
		JSONObject questionsOut1 = new JSONObject();
		questionsOut1.put("question", "How valuable was today in terms of your learning?");
		questionsOut1.put("summary", questionAnalysis1);
		questionsOutput.add(questionsOut1);
		
		JSONObject questionsOut2 = new JSONObject();
		questionsOut2.put("question", "Which of these are you most likely to want to continue to learn?");
		questionsOut2.put("summary", questionAnalysis2);
		questionsOutput.add(questionsOut2);
		
		dataOutput.put("analysis", questionsOutput);
		
		SurveyDataClass surveyDataClass = new SurveyDataClass();
		JSONAssert.assertEquals(dataOutput, surveyDataClass.getJSONOutput(), JSONCompareMode.LENIENT);		
	}
	//Test for data and calculation of percentages for output
	@Test
	public void testForData() {
		
		//Input
		Collection<JSONObject> questionsOneResponses = new ArrayList<JSONObject>();
		Collection<JSONObject> questionsTwoResponses = new ArrayList<JSONObject>();
		
		JSONObject questionResponse1 = new JSONObject();
		questionResponse1.put("answer1", f);
		questionResponse1.put("answer2", f);
		questionResponse1.put("answer3", t);
		questionResponse1.put("answer4", f);
		questionResponse1.put("answer5", f);
		questionsOneResponses.add(questionResponse1);
		
		JSONObject questionResponse2 = new JSONObject();
		questionResponse2.put("answer1", f);
		questionResponse2.put("answer2", f);
		questionResponse2.put("answer3", t);
		questionResponse2.put("answer4", f);
		questionResponse2.put("answer5", f);
		questionsOneResponses.add(questionResponse2);
				
		JSONObject questionResponse3 = new JSONObject();
		questionResponse3.put("answer1", f);
		questionResponse3.put("answer2", f);
		questionResponse3.put("answer3", t);
		questionResponse3.put("answer4", f);
		questionResponse3.put("answer5", f);
		questionsOneResponses.add(questionResponse3);
		
		JSONObject questionResponse4 = new JSONObject();
		questionResponse4.put("answer1", t);
		questionResponse4.put("answer2", f);
		questionResponse4.put("answer3", f);
		questionResponse4.put("answer4", f);
		questionResponse4.put("answer5", f);
		questionsTwoResponses.add(questionResponse4);
		
		JSONObject questionResponse5 = new JSONObject();
		questionResponse5.put("answer1", f);
		questionResponse5.put("answer2", t);
		questionResponse5.put("answer3", f);
		questionResponse5.put("answer4", f);
		questionResponse5.put("answer5", f);
		questionsTwoResponses.add(questionResponse5);
				
		JSONObject questionResponse6 = new JSONObject();
		questionResponse6.put("answer1", t);
		questionResponse6.put("answer2", f);
		questionResponse6.put("answer3", f);
		questionResponse6.put("answer4", f);
		questionResponse6.put("answer5", f);
		questionsTwoResponses.add(questionResponse6);
				
		Collection<JSONObject> questions = new ArrayList<JSONObject>();
		JSONObject question = new JSONObject();
		question.put("question", "How valuable was today in terms of your learning?");
		question.put("responses", questionsOneResponses);
		
		questions.add(question);
		
		JSONObject question1 = new JSONObject();
		question1.put("question", "Which of these are you most likely to want to continue to learn?");
		question1.put("responses", questionsTwoResponses);
		
		questions.add(question1);
		
		dataInput.put("surveyQuestion", questions);
				
		//Output
		Collection<JSONObject> questionsOutput = new ArrayList<JSONObject>();
		
		JSONObject questionAnalysis1 = new JSONObject();
		questionAnalysis1.put("answer1", "0%");
		questionAnalysis1.put("answer2", "0%");
		questionAnalysis1.put("answer3", "100%");
		questionAnalysis1.put("answer4", "0%");
		questionAnalysis1.put("answer5", "0%");
						
		JSONObject questionAnalysis2 = new JSONObject();
		questionAnalysis2.put("answer1", "66%");
		questionAnalysis2.put("answer2", "33%");
		questionAnalysis2.put("answer3", "0%");
		questionAnalysis2.put("answer4", "0%");
		questionAnalysis2.put("answer5", "0%");
				
		JSONObject questionsOut1 = new JSONObject();
		questionsOut1.put("question", "How valuable was today in terms of your learning?");
		questionsOut1.put("summary", questionAnalysis1);
		questionsOutput.add(questionsOut1);
		
		JSONObject questionsOut2 = new JSONObject();
		questionsOut2.put("question", "Which of these are you most likely to want to continue to learn?");
		questionsOut2.put("summary", questionAnalysis2);
		questionsOutput.add(questionsOut2);
		
		dataOutput.put("analysis", questionsOutput);
						
		SurveyDataClass surveyDataClass = new SurveyDataClass(dataInput);
		JSONAssert.assertEquals(dataOutput, surveyDataClass.getJSONOutput(), JSONCompareMode.LENIENT);  
	}
	@Test
	public void testForThirdQuestion() {
		
		//Input
		Collection<JSONObject> questionsOneResponses = new ArrayList<JSONObject>();
		Collection<JSONObject> questionsTwoResponses = new ArrayList<JSONObject>();
		Collection<JSONObject> questionsThreeResponses = new ArrayList<JSONObject>();
		
		JSONObject questionResponse1 = new JSONObject();
		questionResponse1.put("answer1", f);
		questionResponse1.put("answer2", f);
		questionResponse1.put("answer3", t);
		questionResponse1.put("answer4", f);
		questionResponse1.put("answer5", f);
		questionsOneResponses.add(questionResponse1);
		
		JSONObject questionResponse2 = new JSONObject();
		questionResponse2.put("answer1", f);
		questionResponse2.put("answer2", f);
		questionResponse2.put("answer3", t);
		questionResponse2.put("answer4", f);
		questionResponse2.put("answer5", f);
		questionsOneResponses.add(questionResponse2);
				
		JSONObject questionResponse3 = new JSONObject();
		questionResponse3.put("answer1", f);
		questionResponse3.put("answer2", f);
		questionResponse3.put("answer3", t);
		questionResponse3.put("answer4", f);
		questionResponse3.put("answer5", f);
		questionsOneResponses.add(questionResponse3);
		
		JSONObject questionResponse4 = new JSONObject();
		questionResponse4.put("answer1", t);
		questionResponse4.put("answer2", f);
		questionResponse4.put("answer3", f);
		questionResponse4.put("answer4", f);
		questionResponse4.put("answer5", f);
		questionsTwoResponses.add(questionResponse4);
		
		JSONObject questionResponse5 = new JSONObject();
		questionResponse5.put("answer1", f);
		questionResponse5.put("answer2", t);
		questionResponse5.put("answer3", f);
		questionResponse5.put("answer4", f);
		questionResponse5.put("answer5", f);
		questionsTwoResponses.add(questionResponse5);
				
		JSONObject questionResponse6 = new JSONObject();
		questionResponse6.put("answer1", t);
		questionResponse6.put("answer2", f);
		questionResponse6.put("answer3", f);
		questionResponse6.put("answer4", f);
		questionResponse6.put("answer5", f);
		questionsTwoResponses.add(questionResponse6);
		
		JSONObject questionResponse7 = new JSONObject();
		questionResponse7.put("answer1", f);
		questionResponse7.put("answer2", f);
		questionResponse7.put("answer3", f);
		questionResponse7.put("answer4", t);
		questionResponse7.put("answer5", f);
		questionsThreeResponses.add(questionResponse7);
		
		JSONObject questionResponse8 = new JSONObject();
		questionResponse8.put("answer1", f);
		questionResponse8.put("answer2", t);
		questionResponse8.put("answer3", f);
		questionResponse8.put("answer4", f);
		questionResponse8.put("answer5", f);
		questionsThreeResponses.add(questionResponse8);
				
		JSONObject questionResponse9 = new JSONObject();
		questionResponse9.put("answer1", f);
		questionResponse9.put("answer2", f);
		questionResponse9.put("answer3", f);
		questionResponse9.put("answer4", f);
		questionResponse9.put("answer5", t);
		questionsThreeResponses.add(questionResponse9);
				
		Collection<JSONObject> questions = new ArrayList<JSONObject>();
		JSONObject question1 = new JSONObject();
		question1.put("question", "How valuable was today in terms of your learning?");
		question1.put("responses", questionsOneResponses);
		
		questions.add(question1);
		
		JSONObject question2 = new JSONObject();
		question2.put("question", "Which of these are you most likely to want to continue to learn?");
		question2.put("responses", questionsTwoResponses);
		
		questions.add(question2);
		
		JSONObject question3 = new JSONObject();
		question3.put("question", "How likely are you to continue learning what we've covered today?");
		question3.put("responses", questionsThreeResponses);
		
		questions.add(question3);
		
		dataInput.put("surveyQuestion", questions);
				
		//Output
		Collection<JSONObject> questionsOutput = new ArrayList<JSONObject>();
		
		JSONObject questionAnalysis1 = new JSONObject();
		questionAnalysis1.put("answer1", "0%");
		questionAnalysis1.put("answer2", "0%");
		questionAnalysis1.put("answer3", "100%");
		questionAnalysis1.put("answer4", "0%");
		questionAnalysis1.put("answer5", "0%");
						
		JSONObject questionAnalysis2 = new JSONObject();
		questionAnalysis2.put("answer1", "66%");
		questionAnalysis2.put("answer2", "33%");
		questionAnalysis2.put("answer3", "0%");
		questionAnalysis2.put("answer4", "0%");
		questionAnalysis2.put("answer5", "0%");
		
		JSONObject questionAnalysis3 = new JSONObject();
		questionAnalysis3.put("answer1", "0%");
		questionAnalysis3.put("answer2", "33%");
		questionAnalysis3.put("answer3", "0%");
		questionAnalysis3.put("answer4", "33%");
		questionAnalysis3.put("answer5", "33%");
				
		JSONObject questionsOut1 = new JSONObject();
		questionsOut1.put("question", "How valuable was today in terms of your learning?");
		questionsOut1.put("summary", questionAnalysis1);
		questionsOutput.add(questionsOut1);
		
		JSONObject questionsOut2 = new JSONObject();
		questionsOut2.put("question", "Which of these are you most likely to want to continue to learn?");
		questionsOut2.put("summary", questionAnalysis2);
		questionsOutput.add(questionsOut2);
		
		JSONObject questionsOut3 = new JSONObject();
		questionsOut3.put("question", "How likely are you to continue learning what we've covered today?");
		questionsOut3.put("summary", questionAnalysis3);
		questionsOutput.add(questionsOut3);
		
		dataOutput.put("analysis", questionsOutput);
								
		SurveyDataClass surveyDataClass = new SurveyDataClass(dataInput);
		JSONAssert.assertEquals(dataOutput, surveyDataClass.getJSONOutput(), JSONCompareMode.LENIENT);  
	}
}
