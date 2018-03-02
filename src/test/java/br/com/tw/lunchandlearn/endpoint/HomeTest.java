package br.com.tw.lunchandlearn.endpoint;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HomeTest {

    @Test
    public void returnsHomeText() {
        Home home = new Home();

        String response = home.home();

        assertThat(response, is("Home"));
    }
}