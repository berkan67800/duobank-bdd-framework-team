package com.duobank.stepDefinitions;
import org.junit.Assert;
import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBStepDefs {

    List<String> actualColumnNames;
    @When("I send a query to retrieve column names for users table")
    public void i_send_a_query_to_retrieve_column_names_for_users_table() {
        actualColumnNames = DBUtils.getColumnNames("select * from tbl_user limit 1");
    }
    @Then("The column names should be the following")
    public void the_column_names_should_be_the_following(List<String> expected) {
        Assert.assertEquals(expected,actualColumnNames);
    }

    List<List<Object>> listOfLists;
    @When("I send a request to retrieve all duplicates")
    public void i_send_a_request_to_retrieve_all_usernames() {
        listOfLists = DBUtils.getQueryResultAsListOfLists("SELECT email,COUNT(email) FROM tbl_user GROUP BY email HAVING COUNT(email) > 1;");
    }
    @Then("The email column should not contain any duplicates")
    public void the_usernames_column_should_not_contain_any_duplicates() {

        Assert.assertEquals(listOfLists.size(),0);
    }
}
