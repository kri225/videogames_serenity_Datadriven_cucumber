package com.videogames.videogameinfo;

import com.videogames.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/videogames.csv")
@RunWith(SerenityParameterizedRunner.class)
//@RunWith(SerenityRunner.class)
public class CreateVideogameDataDrivenTest extends TestBase {

    private int id;
    private String name;
    private String releaseDate;
    private int  reviewScore;
    private String category;
    private String rating;


    @Steps
    VideogameSteps videogameSteps;

//
//    @Title("Data Driven Test for getting all videogame to the application")
//    @Test
//    public  void getAllVideogames(){
//        videogameSteps.getAllVideoGameFromList().statusCode(200);
//    }
//


//    @Title("Data Driven Test for getting multiple videogame to the application")
//    @Test
//    public void createMultiplevideogames(){
//
//        videogameSteps.createNewVideoGame(id,name,releaseDate,reviewScore,category,rating);
//
//    }

    @Title("Data Driven Test for getting  videogame to the application")
    @Test
    public void getvideoGamebyid(int videogameid){

        videogameSteps.getVideogameByID(202);

    }




}
