package com.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateCensusAnalyserTest {
    public static final String CSV_FILE_INDIA_STATE_CENSUS = "C:\\Users\\Nishi\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String INCORRECT_FILE = "./incorrectSample.txt";
    public static final String INCORRECT_CSV_FILE = "C:\\Users\\Nishi\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\incorrectSample2.csv";
    public static final String CSV_FILE_INDIA_STATE_CODE = "C:\\Users\\Nishi\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCode";

    @Test
    public void givenCSVFile_ReturnExactCount() {
        StateCensusAnalyserMain stateCensusAnalyserMain = new StateCensusAnalyserMain();
        try {
            int entries = stateCensusAnalyserMain.loadStateCensusData(CSV_FILE_INDIA_STATE_CENSUS);
            Assert.assertEquals(29,entries);
        } catch (IndianCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCSVFile_ReturnException_ifFileNotPresent() throws IOException {
        try {
            StateCensusAnalyserMain stateCensusAnalyserMain = new StateCensusAnalyserMain();
            ExpectedException exception = ExpectedException.none();
            exception.expect(IndianCensusAnalyserException.class);
            stateCensusAnalyserMain.loadStateCensusData(INCORRECT_FILE);
        } catch (IndianCensusAnalyserException e) {
            Assert.assertEquals(IndianCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM, e.exceptionType);
        }
    }

    @Test
    public void givenIncorrectCSVFile_ThrowExceptionForIncorrectCSVFile() {
        try {
            StateCensusAnalyserMain stateCensusAnalyserMain = new StateCensusAnalyserMain();
            ExpectedException exception = ExpectedException.none();
            exception.expect(IndianCensusAnalyserException.class);
            stateCensusAnalyserMain.loadStateCensusData(INCORRECT_CSV_FILE);
        } catch (IndianCensusAnalyserException e) {
            Assert.assertEquals(IndianCensusAnalyserException.CensusException.INCORRECT_TYPE_ISSUE, e.exceptionType);
        }
    }
}